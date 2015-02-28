package edu.washington.mhd94.quizdroid;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;


public class Preferences extends ActionBarActivity {

    private PendingIntent pendingIntent;
    private Intent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        alarmIntent = new Intent(Preferences.this, AlarmReceiver.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pendingIntent.cancel();
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public void download(View v) {

            String url = "http://tednewardsandbox.site44.com/questions.json";
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setTitle("File download");
            request.setDescription("File is being downloaded...");

            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            String nameOfFile = "quizdata.json";
            request.setDestinationUri(Uri.fromFile(new File("/data/data/edu.washington.mhd94.quizdroid/files/quizdata.json")));

            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);

            DownloadManager manager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);


        }
    }


   /* private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/



/*  public void start(View v) {
        EditText urlText = (EditText) findViewById(R.id.url);
        String url  = urlText.getText().toString();

        EditText intervalText = (EditText) findViewById(R.id.interval);
        String intervalString = intervalText.getText().toString();
        int interval = 0;


        try {
            interval = Integer.parseInt(intervalString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please Enter a number", Toast.LENGTH_SHORT);
        }

        interval = Integer.parseInt(intervalString) * 1000;

        alarmIntent.putExtra("url", url);
        pendingIntent = PendingIntent.getBroadcast(Preferences.this, 0, alarmIntent, 0);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();

    }*/