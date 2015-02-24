package edu.washington.mhd94.quizdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by mariam on 2/22/15.
 */

 public class AlarmReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String url = intent.getStringExtra("url");
            Toast.makeText(context, url, Toast.LENGTH_SHORT).show();


        }

    }


