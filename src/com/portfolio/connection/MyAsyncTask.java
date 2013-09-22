package com.portfolio.connection;

import android.content.Context;
import android.os.AsyncTask;

public abstract class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {

	protected Context _context;
	protected Runnable _callback;
	protected boolean error = false;
	protected int typeError = 0;
	 

	public boolean getError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public MyAsyncTask( Context context )
	{
		super();
		_context = context;
		error = false;
	}
	
	public MyAsyncTask(Context ctx, Runnable callback) {
		super();
		_context = ctx;
		_callback = callback;
		error = false;
	}

	public void exec() {
		this.execute(0);
	}
	
	public void setContext( Context context )
	{
		_context = context;
	}
}
