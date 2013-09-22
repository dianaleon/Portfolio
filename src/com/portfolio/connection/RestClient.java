package com.portfolio.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
 
public class RestClient {
 
    private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
 
    /* This is a test function which will connects to a given
     * rest service and prints it's response to Android Log with
     * labels "Praeda".
     */
    public static JSONObject connect(String url) throws Exception
    {
 
        HttpClient httpclient = new DefaultHttpClient();
        // Prepare a request object
        HttpGet httpget = new HttpGet(url);
 
        // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
 
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
 
            if (entity != null) {
 
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
 
                // A Simple JSONObject Creation
                JSONObject json=new JSONObject(result);
                instream.close();
                return json;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        	throw e;
        } catch (UnknownHostException e) {
        	e.printStackTrace();
        	throw e;
        } catch (IOException e) {
            e.printStackTrace();
        	throw e;
        } catch (JSONException e) {
            e.printStackTrace();
        	throw e;
        }
        return null;
    }
}