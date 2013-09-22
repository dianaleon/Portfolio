package com.portfolio.handler;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.portfolio.R;

public abstract class AsyncTaskHandler extends Handler{
	
	private static String TAG = AsyncTaskHandler.class.getSimpleName();

	public static int ACEPTREQUEST    = 0;	   // Acept request
	public static int ERRORREQUEST    = 1;	   //Cancel request (Error)
	public static int CONNECTIONERROR = 2;	   // Conection Error request
//	public static int EXCEPTIONERROR  = 3;	  //Exception
	
	protected Context context;
	private AlertDialog alert;

	public AsyncTaskHandler(Context context) {
		this.context = context;
	}
	
	public void setAlert(AlertDialog alert) {
		this.alert = alert;
	}

	@Override
	public void dispatchMessage(Message msg) {
		
		switch (msg.what) {
		case  0://Acept
			acceptRequest(msg);
		break;

		case 1://Cancel
			errorRequest(msg);
			break;

		case 2://Conection error
			conectionError(msg);
			break;

		default:
			break;
		}
		
		
		
	};
	
	public abstract void acceptRequest(Message msg);
	
	public void errorRequest(Message msg) {
		Log.i(TAG,"Error request");
		if (alert != null) {
			alert.dismiss();
		}
		if (context != null) {
			String error = (String) msg.obj;
			if (error == null) {
				error = (String) context.getResources().getString(R.string.dialog_general_error);				
			}
			Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
		}
	}
	
	public void conectionError(Message msg) {
		Log.i(TAG,"Connection error");
		if (context != null) {
			String message = (String) context.getResources().getString(R.string.dialog_connection_error);
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		}
		if (alert != null) {
			alert.dismiss();
		}
	}
}
