package com.portfolio.model.db.dao;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.portfolio.model.db.DatabaseHelper;

/**
 * 
 * @author aperez
 *
 * @param <T>
 */
public class GenericDAO<T> implements GenericInterfaceDAO<T>{

    protected SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;

    public GenericDAO(final Context context) {
        super();
        this.context = context;
    }

    @Override
    public long insert(final T o) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(final T o) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(final T o) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List getAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object get(final long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean enableBDD(){
        if(dbHelper==null)
            dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return false;
    }


    @Override
    public boolean closeBDD(){
        if(db.inTransaction())
            db.endTransaction();
        db.close();

        return true;
    }

    @Override
    public void deleteAll() throws Exception {

    }
}
