package com.portfolio.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.portfolio.model.entities.Media;

/**
 * 
 * @author aperez
 * 
 */
public class MediaDAO extends GenericDAO<Media> {

    private final static String TAG = MediaDAO.class.getSimpleName();
    private static MediaDAO instance = null;

    private static final String TABLE = "media";

    private String[] FIELDS = new String[] { "id", "url", "path" };

    /* Singleton */
    protected MediaDAO(final Context context) {
        super(context);

    }

    public static MediaDAO getInstanced(final Context context) {
        if (instance == null) {
            instance = new MediaDAO(context);
        }
        return instance;
    }

    /* Methods to CRUD */
    /**
     * Inserting new media
     * 
     * @param media
     */
    @Override
    public long insert(final Media media) throws Exception {
        long id = 0;
        try {
            /* Enable BDD */
            enableBDD();

            db.beginTransaction();
            /* Set content to BDD */
            ContentValues initialValues = new ContentValues();
            initialValues.put(FIELDS[1], media.getUrl());
            initialValues.put(FIELDS[2], media.getPath());

            /* Insert in BDD */
            id = db.insert(TABLE, "", initialValues);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e("BDD", "Insert error ", e);
            throw e;
        } finally {
            db.endTransaction();
            /* Close BDD */
            closeBDD();
        }

        return id;
    }

    /**
     * Updating a media
     * 
     * @param media
     */
    @Override
    public int update(final Media media) throws Exception {
        int id = 0;
        try {
            /* Enable BDD */
            enableBDD();
            db.beginTransaction();
            /* Set content to BDD */
            ContentValues initialValues = new ContentValues();
            initialValues.put(FIELDS[1].toString(), media.getUrl());
            initialValues.put(FIELDS[2].toString(), media.getPath());

            /* Update in BDD */
            id = db.update(TABLE, initialValues, "id=?", new String[] { Long.toString(media.getId()) });

            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e("BDD", "Insert error ", e);
            throw e;
        } finally {
            db.endTransaction();
            /* Close BDD */
            closeBDD();
        }

        // TODO Auto-generated method stub
        return id;
    }

    /**
     * 
     */
    @Override
    public int delete(final Media media) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 
     */
    @Override
    public List<Media> getAll() throws Exception {
        List<Media> result = new ArrayList<Media>();

        try {
            /* Enable BDD */
            enableBDD();
            Log.i("BDD", "Load records");
            // Consulting table "TABLE"
            Cursor c = db.query(true, TABLE, FIELDS, "", null, null, null, null, null);
            // Making sure at least one record exists
            if (c.moveToFirst()) {
                // Looping with cursor
                do {
                    Media media = new Media();
                    media.setId(c.getLong(0));
                    media.setUrl(c.getString(1));
                    media.setPath(c.getString(2));

                    /* Add to list */

                    result.add(media);

                } while (c.moveToNext());
            }
            // Close Cursor
            c.close();
        } catch (Exception e) {
            Log.e("BDD", "Load error ", e);
            throw e;
        } finally {
            /* Close BDD */
            closeBDD();
        }
        return result;
    }

    /**
     * Getting a media by ID
     * 
     * @param mediaId
     */
    @Override
    public Media get(final long mediaId) throws Exception {

        List<Media> result = new ArrayList<Media>();

        try {
            /* Enable BDD */
            enableBDD();
            Log.i("BDD", "Load records");
            Cursor c = db.query(true, TABLE, FIELDS, "id =" + mediaId, null, null, null, null, null);

            if (c == null) {
                return null;
            }
            // Making sure at least one record exists
            if (c.moveToFirst()) {
                // Looping with cursor
                do {
                    Media media = new Media();
                    media.setId(c.getLong(0));
                    media.setUrl(c.getString(1));
                    media.setPath(c.getString(2));

                    // Add to list
                    result.add(media);

                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            Log.e("BDD", "Load error ", e);
            throw e;
        } finally {
            /* Close BDD */
            closeBDD();
        }
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param media
     * @return
     * @throws Exception
     */
    public Media insertAndUpdate(final Media media) throws Exception {
        Media newRec = null;
        long res = 0;
        try {
            Media old = get(media.getId());
            if (old == null) {
                Log.i("SQL", "Insert new record");
                res = insert(media);
                media.setId(res);
            } else {
                Log.i("SQL", "Update record " + media.getId());
                res = update(media);
            }
        } catch (Exception e) {
            Log.i("SQL", "Error update and insert and insert");
            res = insert(media);
        }
        try {
            newRec = get(media.getId());
        } catch (Exception e) {
            Log.e(TAG, "Error insert update get the new REC", e);
        }
        return newRec;
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            /* Enable BDD */
            enableBDD();

            db.beginTransaction();
            /* Set content to BDD */

            /* Delete in BDD */
            db.delete(TABLE, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e("BDD", "Insert error ", e);
            throw e;
        } finally {
            db.endTransaction();
            /* Close BDD */
            closeBDD();
        }
    }
    
    public Media getByUrl(String url) throws Exception {
        Media result = null;

        try {
            /* Enable BDD */
            enableBDD();
            Log.i("BDD", "Load records");
            Cursor c = db.query(true, TABLE, FIELDS, "url ='" + url + "'", null, null, null, null, null);

            if (c == null) {
                return null;
            }
            // Making sure at least one record exists
            if (c.moveToFirst()) {
                result = new Media();
                result.setUrl(c.getString(1));
                result.setPath(c.getString(2));
                result.setId(c.getLong(0));
            }
            c.close();
        } catch (Exception e) {
            Log.e("BDD", "Load error ", e);
            throw e;
        } finally {
            /* Close BDD */
            closeBDD();
        }
        return result;
    }

}
