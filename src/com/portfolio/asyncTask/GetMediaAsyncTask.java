package com.portfolio.asyncTask;

import android.content.Context;
import android.os.Handler;

import com.portfolio.connection.ConnectionPool;
import com.portfolio.connection.MyAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;

public class GetMediaAsyncTask extends MyAsyncTask{
	
	private static String TAG = GetMediaAsyncTask.class.getSimpleName();
	 
	private Handler handler;
	private String url;
	private String name;
	private String path;
	
	public GetMediaAsyncTask(Context ctx, Handler handler, String url, String name) {
		super(ctx);
		this.handler = handler;
		this.url = url;
		this.name = name;
	}

	@Override
	protected Integer doInBackground(Integer... arg0) {
		try {
			ConnectionPool pool = ConnectionPool.getInstanced(_context);
			path = pool.downloadFromURL(url, name);
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
			msg.obj = path;
		}
		handler.sendMessage(msg);
	}
}
