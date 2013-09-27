package com.portfolio.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.portfolio.R;

/**
 * 
 * @author aperez
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "database.sqlite";

    public DatabaseHelper(final Context context) {
        super(context, DB_NAME, null, Integer.parseInt(context.getResources().getString(R.string.databaseVersion)));
    }

    // SQL snippet for creating user table
    String sqlCreateD = "CREATE TABLE media (id INTEGER primary key autoincrement, url TEXT, path TEXT)";

    @Override
    public void onCreate(final SQLiteDatabase db) {
        // SQL sentence execution for table creation
        db.execSQL(sqlCreateD);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        // TODO Auto-generated method stub
    }


}
