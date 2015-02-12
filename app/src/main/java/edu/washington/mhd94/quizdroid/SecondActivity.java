package edu.washington.mhd94.quizdroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {
    //Overview Fragment
    static String subject;
    static RadioGroup rg;

    //Question Fragment

    static int count = 1;
    static int correctCount;

    //Answer Fragment
    static String answer;
    static String correct;


    FragmentManager fm;
    FragmentTransaction ft;
    Fragment myFragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_activity);
        correctCount = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subject = extras.getString("subject");
        }


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        final Button b = (Button) findViewById(R.id.button);

        if (savedInstanceState == null) {
            OverviewFragment1 myFragment = new OverviewFragment1();


            Bundle bundle = new Bundle();
            bundle.putString("subject", subject);
            OverviewFragment1 fragInfo = new OverviewFragment1();
            fragInfo.setArguments(bundle);

            ft.add(R.id.container, myFragment);
            ft.commit();
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Fragment fragment = new QuestionFragment1();
                if (count <= 3) {
                    if (b.getText().toString().equals("Continue")) {
                        b.setVisibility(View.GONE);

                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, fragment)
                                .commit();
                    } else if (b.getText().toString().equals("Next")) {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, new AnswerFragment1())
                                .commit();
                        Button b = (Button) findViewById(R.id.button);
                        b.setText("Next Question");


                    } else if (b.getText().toString().equals("Next Question")) {
                        count++;
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, fragment)
                                .commit();

                    }
                } else {

                    b.setText("Finish");
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.remove(fragment)
                            .commit();

                }
            }

        });

    }

    public void button(View v) {

        Button b = (Button) findViewById(R.id.button);
        b.setVisibility(View.VISIBLE);
        b.setText("Next");
        answer = QuestionFragment1.saveAnswer();
    }

    public String getSubject() {
        return subject;
    }


    //OVERVIEW FRAGMENT


    public static class OverviewFragment1 extends android.support.v4.app.Fragment {
        public OverviewFragment1() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View rootView = inflater.inflate(R.layout.activity_second, container, false);

            TextView topic = (TextView) rootView.findViewById(R.id.topic);
            topic.setText("Topic Overview " + subject);

            TextView description = (TextView) rootView.findViewById(R.id.description);
            description.setText("This quiz will ask basic " + subject + " questions.");

            return rootView;
        }

    }


    //QUESTION FRAGMENT


    public static class QuestionFragment1 extends android.support.v4.app.Fragment {


        static View rootView;
        TextView question;
        RadioButton a1;
        RadioButton a2;
        RadioButton a3;
        RadioButton a4;


        public QuestionFragment1() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rootView = inflater.inflate(R.layout.activity_third, container, false);

            //setQuestion(subject);

            TextView question = (TextView) rootView.findViewById(R.id.question);
            RadioButton a1 = (RadioButton) rootView.findViewById(R.id.a1);
            RadioButton a2 = (RadioButton) rootView.findViewById(R.id.a2);
            RadioButton a3 = (RadioButton) rootView.findViewById(R.id.a3);
            RadioButton a4 = (RadioButton) rootView.findViewById(R.id.a4);

            //Math Questions
            if (subject.equals("Math")) {
                if (count == 1) {

                    question.setText("What does 1 * 1 equal?");
                    a1.setText("1");
                    a2.setText("2");
                    a3.setText("11");
                    a4.setText("110");
                } else if (count == 2) {
                    question.setText("What does 246 / 2 equal?");
                    a1.setText("2");
                    a2.setText("100");
                    a3.setText("123");
                    a4.setText("246");

                } else if (count == 3) {
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
            } else if (subject.equals("Physics")) {

                //Physics Question

                if (count == 1) {
                    question.setText("If an object is in motion, what kind of energy does it possess?");
                    a1.setText("Potential Energy");
                    a2.setText("Metabolic Energy");
                    a3.setText("Kinetic Energy");
                    a4.setText("Caloric Energy");
                } else if (count == 2) {
                    question.setText("What is the force that holds back a sliding object?");
                    a1.setText("Deceleration");
                    a2.setText("Momentum");
                    a3.setText("Gravity");
                    a4.setText("Friction");
                } else if (count == 3) {
                    question.setText("What property causes a moving object to continue moving?");
                    a1.setText("Inertia");
                    a2.setText("Impetus");
                    a3.setText("Velocity");
                    a4.setText("Speed");
                }
            } else if (subject.equals("Marvel Super Heroes")) {

                //Marvel Question

                if (count == 1) {
                    question.setText("Which character was bitten by a radioactive spider as a high school student?");
                    a1.setText("Peter Benjamin Parker");
                    a2.setText("Robert Bruce Banner");
                    a3.setText("Anthony Edward Stark");
                    a4.setText("Steven Rogers");
                } else if (count == 2) {
                    question.setText("Which character was in a gamma bomb explosion while trying to save the life of a teenager");
                    a1.setText("Peter Benjamin Parker");
                    a2.setText("Robert Bruce Banner");
                    a3.setText("Anthony Edward Stark");
                    a4.setText("Steven Rogers");
                } else if (count == 3) {
                    question.setText("Which character was wounded, captured and forced to build a weapon by his enemies who instead created an advanced suit of armor to save his life and escape captivity?");
                    a1.setText("Peter Benjamin Parker");
                    a2.setText("Robert Bruce Banner");
                    a3.setText("Anthony Edward Stark");
                    a4.setText("Steven Rogers");
                }

            }
            getCorrectAnswer(subject);




           /* rg = (RadioGroup) rootView.findViewById(R.id.radioSex);
            RadioButton selectRadio = (RadioButton) rootView.findViewById(rg.getCheckedRadioButtonId());
            answer = selectRadio.getText().toString();*/

            return rootView;
        }

        public static String saveAnswer() {
            rg = (RadioGroup) rootView.findViewById(R.id.radioSex);
            RadioButton selectRadio = (RadioButton) rootView.findViewById(rg.getCheckedRadioButtonId());
            return selectRadio.getText().toString();

    }

        public void getCorrectAnswer(String subject) {
            if (subject.equals("Math")) {
                 getCorrectMathAnswer();
            } else if (subject.equals("Physics")) {
                 getCorrectPhysicAnswers();
            } else {
                 getCorrectMarvelAnswer();
            }
        }

        public void getCorrectMathAnswer() {

            if (count == 1) {
                correct = "1";
            } else if (count == 2) {
                correct = "123";
            } else {
                correct = "0";
            }
        }

        public void getCorrectPhysicAnswers() {
            if (count == 1) {
                correct = "Kinetic Energy";
            } else if (count == 2) {
                correct  = "Friction";
            } else {
                correct = "Inertia";
            }
        }

        public void getCorrectMarvelAnswer() {
            if (count == 1) {
                correct = "Peter Benjamin Parker";
            } else if (count == 2) {
                correct = "Robert Bruce Banner ";
            } else {
                correct = "Anthony Edward Stark";
            }
        }
     }

        //Answer Fragment

        public static class AnswerFragment1 extends android.support.v4.app.Fragment {
            RadioGroup rg;
            Button b;
            static View rootView;

            public AnswerFragment1() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                rootView = inflater.inflate(R.layout.activity_fourth, container, false);


                //

                TextView yourAnswer = (TextView) rootView.findViewById(R.id.yours);
                TextView correctAnswer = (TextView) rootView.findViewById(R.id.correct);

                yourAnswer.setText("Your Answer: " + answer);
                correctAnswer.setText("Correct Answer: " + correct);


                if(subject.equals("Math")) {


                    //Math Answers

                    if (count == 1) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Any number times iteslf will always equal 1.");

                        if (answer.equals("1")) {
                            correctCount++;
                        }
                    } else if (count == 2) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Any even number divided by 2 equals half of that number.");

                        if (answer.equals("123")) {
                            correctCount++;
                        }

                    } else if (count == 3) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Any number multiplied by 0 will always equal 0.");

                        if (answer.equals("0")) {
                            correctCount++;
                        }
                    }
                } else if(subject.equals("Physics")) {

                    //Physics Answers

                    if (count == 1) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Kinetic energy is an expression of the fact that a moving object can do work on anything it hits");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }
                    } else if (count == 2) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Friction is the force resisting the relative motion of solid surfaces, fluid layers, and material elements sliding against each other.");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }

                    } else if (count == 3) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Inertia is the resistance of any physical object to any change in its state of motion, including changes to its speed and direction.");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }

                    }
                } else if(subject.equals("Marvel Super Heroes")) {


                    //Marvel Answers

                    if (count == 1) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Peter Benjamin Parker is also known as Spider-Man");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }
                    } else if (count == 2) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Robert Bruce Banner is also known as the Hulk");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }

                    } else if (count == 3) {
                        TextView description = (TextView) rootView.findViewById(R.id.description);
                        description.setText("Anthony Edward Stark is also known as Iron Man");

                        if (answer.equals(correct)) {
                            correctCount++;
                        }

                    }
                }

                TextView correctTotal = (TextView) rootView.findViewById(R.id.total);
                correctTotal.setText("You have answered " + correctCount + " out of " + (count));

                return rootView;
            }

        }
    }








