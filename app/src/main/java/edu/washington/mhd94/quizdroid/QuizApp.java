package edu.washington.mhd94.quizdroid;

import android.app.Application;
import android.util.Log;

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
    }


    public Repository getRepository() {
        return repo;
    }


}
