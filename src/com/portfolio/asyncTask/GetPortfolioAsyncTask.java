package com.portfolio.asyncTask;

import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;

import com.portfolio.connection.ConnectionPool;
import com.portfolio.connection.MyAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;

public class GetPortfolioAsyncTask extends MyAsyncTask{
	
	private static String TAG = GetPortfolioAsyncTask.class.getSimpleName();
	 
	private Handler handler;
	private JSONObject param;
//	private Register response;
	
	public GetPortfolioAsyncTask(Context ctx, Handler handler) {
		super(ctx);
		this.handler = handler;
		try {
//			this.param = RegisterJSON.getInstance().serialize(user, categories);
		} catch (Exception e) {
			e.printStackTrace();
			param = null;
		}
	}

	@Override
	protected Integer doInBackground(Integer... arg0) {
		try {
			ConnectionPool pool = ConnectionPool.getInstanced(_context);
			JSONObject result = pool.request("user/register", param);
//			response = (Register) RegisterJSON.getInstance().deserialize(result);
//			user.setCode(response.getUserID());
		} catch (Exception e) {
			return AsyncTaskHandler.ERRORREQUEST; 
		}
		return AsyncTaskHandler.ACEPTREQUEST;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		android.os.Message msg = new android.os.Message();
		msg.what = result;
		if(result == AsyncTaskHandler.ACEPTREQUEST){
//			if(response.getCode()==101){
//				msg.obj = user;
//			}else{
//				msg.what = AsyncTaskHandler.ERRORREQUEST;
//				msg.arg1 = typeError;
//			}
		}
		handler.sendMessage(msg);
	}
}
