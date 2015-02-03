package edu.washington.mhd94.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class SecondActivity extends ActionBarActivity {
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subject = extras.getString("subject");
        }

        TextView topic = (TextView) findViewById(R.id.topic);
        topic.setText("Topic Overview " + subject );

        TextView description = (TextView) findViewById(R.id.description);
        description.setText("This quiz will ask basic " + subject + " questions.");



        Button b = (Button) findViewById(R.id.begin);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(SecondActivity.this, thirdActivity.class);

                nextActivity.putExtra("subject", subject);

                startActivity(nextActivity);
                finish();
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
