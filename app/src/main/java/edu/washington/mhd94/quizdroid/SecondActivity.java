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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SecondActivity extends ActionBarActivity {
    //Overview Fragment
    static String subject;
    static RadioGroup rg;

    //Question Fragment

    static int count = 1;
    static int correctCount;

    //Answer Fragment
    static String answer;
    static String correctAnswerr;

    //Quiz app

    static QuizApp app = QuizApp.getInstance();
    static Topic topic;
    static int quizCount;


    FragmentManager fm;
    FragmentTransaction ft;
    Fragment myFragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_activity);
        correctCount = 0;

        QuizApp app = QuizApp.getInstance();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subject = extras.getString("subject");
        }

        app.getRepository().retrieveTopic(subject);
        app.getRepository().setTopics();

        topic = new Topic();
        topic = app.getRepository().getCurrentTopic();

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


    //OVERVIEW FRAGMENT

    public static class OverviewFragment1 extends android.support.v4.app.Fragment {
        public OverviewFragment1() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View rootView = inflater.inflate(R.layout.activity_second, container, false);

            TextView topicText = (TextView) rootView.findViewById(R.id.topic);
            topicText.setText("Topic Overview: " + subject);

            TextView description = (TextView) rootView.findViewById(R.id.description);
            description.setText(app.getRepository().getLongDescription());

            return rootView;
        }

    }

    //QUESTION FRAGMENT
    public static class QuestionFragment1 extends android.support.v4.app.Fragment {
        static View rootView;

        public QuestionFragment1() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rootView = inflater.inflate(R.layout.activity_third, container, false);

            app.getRepository().setTopicQuiz();
            Quiz currentQuiz =  app.getRepository().getCurrentQuiz();


            TextView question = (TextView) rootView.findViewById(R.id.question);
            RadioButton a1 = (RadioButton) rootView.findViewById(R.id.a1);
            RadioButton a2 = (RadioButton) rootView.findViewById(R.id.a2);
            RadioButton a3 = (RadioButton) rootView.findViewById(R.id.a3);
            RadioButton a4 = (RadioButton) rootView.findViewById(R.id.a4);

            if(quizCount <= 1) {
                ArrayList<String> questionLists = app.getRepository().getQuestions();
                String currentQuestion = questionLists.get(quizCount);

                Map<String, ArrayList<String>> answerMap = new HashMap<String, ArrayList<String>>();
                answerMap = app.getRepository().getAnswerMap();
                ArrayList<String> answers = answerMap.get(currentQuestion);

                correctAnswerr = answers.get(currentQuiz.getCorrectAnswer());


                question.setText(currentQuestion);
                a1.setText(answers.get(0));
                a2.setText(answers.get(1));
                a3.setText(answers.get(2));
                a4.setText(answers.get(3));

                quizCount++;
                app.getRepository().setQuizCount(quizCount);
            }

            return rootView;
        }

        public static String saveAnswer() {
            rg = (RadioGroup) rootView.findViewById(R.id.radioSex);
            RadioButton selectRadio = (RadioButton) rootView.findViewById(rg.getCheckedRadioButtonId());
            return selectRadio.getText().toString();
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

            TextView yourAnswer = (TextView) rootView.findViewById(R.id.yours);
            TextView correctAnswerText = (TextView) rootView.findViewById(R.id.correct);

            yourAnswer.setText("Your Answer: " + answer);
            correctAnswerText.setText("Correct Answer: " + correctAnswerr);
            if (answer.equals(correctAnswerr)) {
                correctCount++;
            }

            TextView correctTotal = (TextView) rootView.findViewById(R.id.total);
            correctTotal.setText("You have answered " + correctCount + " out of " + (count));

            return rootView;
        }

    }
}









