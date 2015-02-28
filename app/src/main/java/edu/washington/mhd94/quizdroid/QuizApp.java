package edu.washington.mhd94.quizdroid;

import android.app.Application;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariam on 2/14/15.

    */
    public class QuizApp extends Application {
    private static QuizApp instance;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Repository repo;

    public QuizApp() {
        repo = new Repository();
        if (instance == null)
            instance = this;
        else {
            Log.e("QuizApp", "*** MORE THAN ONE CONSTRUCTED!");
            throw new RuntimeException("Multiple app exception");
        }
    }

    public static QuizApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate event fired!!!!!!!!!");

   /*     FileInputStream fis = null;
        try
        {
            fis = openFileInput("quizdata.json");
            String json = readJSONFile(fis);
            JSONArray jsonTopics = new JSONArray(json);
            Log.i(TAG, jsonTopics.get(0).toString() + "HELLO");
            //for(int i = 0; i <= jsonTopics.length(); i++) {

          //  }

         }
        catch (JSONException jsonEx)
        {
            Log.e("QuizApp", "Exception in reading JSON file!!: " + jsonEx.getMessage());
        }
        catch (IOException ioEx)
        {
            Log.e("QuizApp", "Exception in reading JSON file!: " + ioEx.getMessage());
        }
        finally
        {
            try
            {
                if (fis != null)
                    fis.close();
            }
            catch (IOException ioEx)
            {
                // Not much we can do here....
            }
        }*/

    }

    private String readJSONFile(FileInputStream fis)
            throws IOException
    {
        int size = fis.available();
        byte[] buffer = new byte[size];
        fis.read(buffer);

        return new String(buffer, "UTF-8");
    }




    public Repository getRepository() {
        return repo;
    }


}
