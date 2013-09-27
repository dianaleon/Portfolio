package com.portfolio.utils;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;


public class FileHelper {

	public static File createNewImageFile(Context context, String filename) {
		File folder = null;
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			String path = Environment.getExternalStorageDirectory().getPath() + Config.IMAGES_EXTERNAL_PATH;
			folder = new File(path);//"/mnt/sdcard/Portfolio/Images");//context.getFilesDir();//ExternalFilesDir("Images");
		} else {
			folder = new File(context.getFilesDir() + Config.IMAGES_INTERNAL_PATH);
		}
		folder.mkdirs();

		// create a new file, specifying the path, and the filename
		// which we want to save the file as.

		File file = new File(folder, filename);

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return file;
	}
}