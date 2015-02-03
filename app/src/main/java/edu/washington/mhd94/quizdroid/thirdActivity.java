package edu.washington.mhd94.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;



public class thirdActivity extends ActionBarActivity {
    int count = 1;
    int correctCount = 0;
    String subject = "";
    RadioGroup rg;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        int tempCount = 0;
        int tempCorrectCount = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tempCount = extras.getInt("count");
            tempCorrectCount = extras.getInt("correctCount");
            subject = extras.getString("subject");
        }

        if (tempCount != 0) {
            count = tempCount;
            correctCount = tempCorrectCount;
        }


        setQuestion(subject);

        b = (Button) findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(thirdActivity.this, fourthActivity.class);
                nextActivity.putExtra("answer", saveAnswer());
                nextActivity.putExtra("count", count);
                nextActivity.putExtra("correct", getCorrectAnswer(subject));
                nextActivity.putExtra("correctCount", correctCount);
                nextActivity.putExtra("subject", subject);

                startActivity(nextActivity);
                finish();
            }

        });
    }


    public void button(View v) {
            Button b = (Button) findViewById(R.id.submit);
            b.setVisibility(View.VISIBLE);
        }

    public String saveAnswer() {
         rg = (RadioGroup) findViewById(R.id.radioSex);
         RadioButton selectRadio = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
         return selectRadio.getText().toString();
  }

  public void setQuestion(String subject) {
      if(subject.equals("Math")) {
          setMathQuestion();
      } else if (subject.equals("Physics")) {
          setPhysicsQuestion();
      } else if(subject.equals("Marvel Super Heroes")) {
          setMarvelQuestion();
      }
  }

  public void setMathQuestion() {
      TextView question = (TextView) findViewById(R.id.question);
      RadioButton a1 = (RadioButton) findViewById(R.id.a1);
      RadioButton a2 = (RadioButton) findViewById(R.id.a2);
      RadioButton a3 = (RadioButton) findViewById(R.id.a3);
      RadioButton a4 = (RadioButton) findViewById(R.id.a4);


      if(count == 1) {

           question.setText("What does 1 * 1 equal?");
           a1.setText("1");
           a2.setText("2");
           a3.setText("11");
           a4.setText("110");
    } else if(count == 2) {
          question.setText("What does 246 / 2 equal?");
          a1.setText("2");
          a2.setText("100");
          a3.setText("123");
          a4.setText("246");

      } else if(count == 3) {
          question.setText("What does 2945 * 0 equal?");
          a1.setText("2945");
          a2.setText("0");
          a3.setText("29450");
          a4.setText("29");
      } else {
          question.setText(count + "");
          a1.setText(" ");
          a2.setText(" ");
          a3.setText(" ");
          a4.setText(" ");

      }
  }

  public String getCorrectAnswer(String subject) {
      if(subject.equals("Math")) {
          return getCorrectMathAnswer();
      } else if(subject.equals("Physics")) {
          return getCorrectPhysicAnswers();
      } else {
          return getCorrectMarvelAnswer();
      }
  }

  public String getCorrectMathAnswer() {

      if(count == 1) {
          return "1";
      } else if(count == 2) {
          return "123";
      } else {
          return "0";
      }
  }




    public void setPhysicsQuestion() {
        TextView question = (TextView) findViewById(R.id.question);
        RadioButton a1 = (RadioButton) findViewById(R.id.a1);
        RadioButton a2 = (RadioButton) findViewById(R.id.a2);
        RadioButton a3 = (RadioButton) findViewById(R.id.a3);
        RadioButton a4 = (RadioButton) findViewById(R.id.a4);

        if(count == 1) {
            question.setText("If an object is in motion, what kind of energy does it possess?");
            a1.setText("Potential Energy");
            a2.setText("Metabolic Energy");
            a3.setText("Kinetic Energy");
            a4.setText("Caloric Energy");
        } else if(count == 2) {
            question.setText("What is the force that holds back a sliding object?");
            a1.setText("Deceleration");
            a2.setText("Momentum");
            a3.setText("Gravity");
            a4.setText("Friction");
        } else if(count == 3) {
            question.setText("What property causes a moving object to continue moving?");
            a1.setText("Inertia");
            a2.setText("Impetus");
            a3.setText("Velocity");
            a4.setText("Speed");
        }
    }

    public String getCorrectPhysicAnswers() {
        if(count == 1) {
            return "Kinetic Energy";
        } else if(count == 2) {
            return "Friction";
        } else {
            return "Inertia";
        }
    }

    public void setMarvelQuestion() {
        TextView question = (TextView) findViewById(R.id.question);
        RadioButton a1 = (RadioButton) findViewById(R.id.a1);
        RadioButton a2 = (RadioButton) findViewById(R.id.a2);
        RadioButton a3 = (RadioButton) findViewById(R.id.a3);
        RadioButton a4 = (RadioButton) findViewById(R.id.a4);

        if(count == 1) {
            question.setText("Which character was bitten by a radioactive spider as a high school student?");
            a1.setText("Peter Benjamin Parker");
            a2.setText("Robert Bruce Banner");
            a3.setText("Anthony Edward Stark");
            a4.setText("Steven Rogers");
        } else if(count == 2) {
            question.setText("Which character was in a gamma bomb explosion while trying to save the life of a teenager");
            a1.setText("Peter Benjamin Parker");
            a2.setText("Robert Bruce Banner");
            a3.setText("Anthony Edward Stark");
            a4.setText("Steven Rogers");
        } else if(count == 3) {
            question.setText("Which character was wounded, captured and forced to build a weapon by his enemies who instead created an advanced suit of armor to save his life and escape captivity?");
            a1.setText("Peter Benjamin Parker");
            a2.setText("Robert Bruce Banner");
            a3.setText("Anthony Edward Stark");
            a4.setText("Steven Rogers");
        }
    }

    public String getCorrectMarvelAnswer() {
        if(count == 1) {
            return "Peter Benjamin Parker";
        } else if(count == 2) {
            return "Robert Bruce Banner ";
        } else {
            return "Anthony Edward Stark";
        }
    }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
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
