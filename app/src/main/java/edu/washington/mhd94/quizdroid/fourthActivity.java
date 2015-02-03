package edu.washington.mhd94.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class fourthActivity extends ActionBarActivity {
    int correctCount = 0;
    int count = 1;
    String answer;
    String correct;
    String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        //Retrieves info from thirdActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            answer = extras.getString("answer");
            correct = extras.getString("correct");
            count = extras.getInt("count");
            correctCount = extras.getInt("correctCount");
            subject = extras.getString("subject");

        }
        if(count == 3) {
            Button next = (Button) findViewById(R.id.next);
            next.setText("Finish");
        }
        setSummary();

        Button b = (Button) findViewById(R.id.next);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity;
                if(count == 3) {
                   nextActivity = new Intent(fourthActivity.this, MainActivity.class);

                } else {
                   nextActivity = new Intent(fourthActivity.this, thirdActivity.class);
                }

                nextActivity.putExtra("count", count + 1);
                nextActivity.putExtra("correctCount", correctCount);
                nextActivity.putExtra("subject", subject);

                startActivity(nextActivity);
                finish();
            }
        });
    }

    //Sets the answer summary
    public void setSummary() {
        TextView yourAnswer = (TextView) findViewById(R.id.yours);
        TextView correctAnswer = (TextView) findViewById(R.id.correct);

        yourAnswer.setText("Your Answer:" + answer);
        correctAnswer.setText("Correct Answer: " + correct);

              getAnswers();

            TextView numCorrect = (TextView) findViewById(R.id.answers);
            numCorrect.setText("You have " + correctCount + " out of 3 correct");


    }

    public void getAnswers() {
        if(subject.equals("Math")) {
            mathAnswers();
        } else if(subject.equals("Physics")) {
            physicsAnswers();
        } else if(subject.equals("Marvel Super Heroes")) {
            marvelAnswers();
        }
    }

    //answers for math topic
    public void mathAnswers() {
        if(count == 1 ) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Any number times iteslf will always equal 1.");

            if (answer.equals("1")) {
                correctCount++;
            }
        } else if(count == 2) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Any even number divided by 2 equals half of that number.");

            if (answer.equals("123")){
                correctCount++;
            }

        }else  if(count == 3) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Any number multiplied by 0 will always equal 0.");

            if (answer.equals("0")) {
                correctCount++;
            }
        }


    }


    public void physicsAnswers() {
        if(count == 1 ) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Kinetic energy is an expression of the fact that a moving object can do work on anything it hits");

            if (answer.equals(correct)) {
                correctCount++;
            }
        } else if(count == 2) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Friction is the force resisting the relative motion of solid surfaces, fluid layers, and material elements sliding against each other.");

            if (answer.equals(correct)) {
                correctCount++;
            }

        }else  if(count == 3) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Inertia is the resistance of any physical object to any change in its state of motion, including changes to its speed and direction.");

            if (answer.equals(correct)) {
                correctCount++;
            }

        }
    }


    public void marvelAnswers() {
        if(count == 1 ) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Peter Benjamin Parker is also known as Spider-Man");

            if (answer.equals(correct)) {
                correctCount++;
            }
        } else if(count == 2) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Robert Bruce Banner is also known as the Hulk");

            if (answer.equals(correct)) {
                correctCount++;
            }

        }else  if(count == 3) {
            TextView description = (TextView) findViewById(R.id.description);
            description.setText("Anthony Edward Stark is also known as Iron Man");

            if (answer.equals(correct)) {
                correctCount++;
            }

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fourth, menu);
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
