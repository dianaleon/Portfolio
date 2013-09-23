package com.portfolio.asyncTask;

import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.portfolio.connection.ConnectionPool;
import com.portfolio.connection.MyAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;
import com.portfolio.model.entities.Portfolio;

public class GetPortfolioAsyncTask extends MyAsyncTask{
	
	private static String TAG = GetPortfolioAsyncTask.class.getSimpleName();
	 
	private Handler handler;
	private JSONObject param;
	private Portfolio response;
	
	public GetPortfolioAsyncTask(Context ctx, Handler handler) {
		super(ctx);
		this.handler = handler;
	}

	@Override
	protected Integer doInBackground(Integer... arg0) {
		try {
			Looper.prepare();
			ConnectionPool pool = ConnectionPool.getInstanced(_context);
			JSONObject result = pool.request("", param);
			response = new Portfolio(result);
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
			msg.obj = response;
		}
		handler.sendMessage(msg);
	}
}
