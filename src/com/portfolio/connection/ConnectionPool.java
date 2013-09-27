package com.portfolio.connection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.portfolio.utils.FileHelper;

public class ConnectionPool extends ServerController {

	private final static String TAG = ConnectionPool.class.getSimpleName();
	private static ConnectionPool INSTANCE = null;
	
	private ConnectionPool(Context context) {
		super(context);

	}

	public static ConnectionPool getInstanced(Context context) {
		if (INSTANCE == null) {
			INSTANCE = new ConnectionPool(context);
		}
		// * Update pools *///

		return INSTANCE;
	}

	public JSONObject request(String resourse, JSONObject jsonRequest)
			throws Exception {
		try {
			return getResponse(resourse, jsonRequest);
		} catch (Exception e) {
			throw e;
		}
	}

	public String downloadFromURL(String urlPath, String filename) {

		String filepath = null;

		try {

			URL url = new URL(urlPath);

			// create the new connection

			HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setDoInput(true);
	        connection.connect();
			// set the path where we want to save the file
			// in this case, going to save it on the root directory of the
			// sd card.
			File file = FileHelper.createNewImageFile(this.context, filename);

			if (file != null) {
				// this will be used to write the downloaded data into the file we
				// created
				FileOutputStream fileOutput = new FileOutputStream(file);
	
				// this will be used in reading the data from the internet
				InputStream inputStream = connection.getInputStream();
	
				// this is the total size of the file
				int totalSize = connection.getContentLength();
				// variable to store total downloaded bytes
				int downloadedSize = 0;
	
				// create a buffer...
				byte[] buffer = new byte[1024];
				int bufferLength = 0; // used to store a temporary size of the
										// buffer
	
				// now, read through the input buffer and write the contents to the
				// file
				while ((bufferLength = inputStream.read(buffer)) > 0) {
					// add the data in the buffer to the file in the file output
					// stream (the file on the sd card
					fileOutput.write(buffer, 0, bufferLength);
					// add up the size so we know how much is downloaded
					downloadedSize += bufferLength;
					// this is where you would do something to report the prgress,
					// like this maybe
					Log.i("Progress:", "downloadedSize:" + downloadedSize + "totalSize:" + totalSize);
				}
				// close the output stream when done
				fileOutput.close();
				if (downloadedSize == totalSize)
					filepath = file.getPath();
			} else {
				return null;
			}
			// catch some possible errors...
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			filepath = null;
			e.printStackTrace();
			return null;
		}
		Log.i("filepath:", " " + filepath);

		return filepath;

	}
}
