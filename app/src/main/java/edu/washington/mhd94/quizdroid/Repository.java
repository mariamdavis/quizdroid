package edu.washington.mhd94.quizdroid;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariam on 2/17/15.
 */
public class Repository implements TopicRepository {

        //TOPICS
        private Topic currentTopic;
        private String topic;


        public ArrayList<String> initializeSubjects() {
            ArrayList<String> subjects = new  ArrayList<String>();
            Topic t = new Topic();
            setMathTopic(t);
            subjects.add("Math: " + t.getShortDescription());
            setPhysicsTopic(t);
            subjects.add("Physics: " + t.getShortDescription());
            setMarvelTopic(t);
            subjects.add("Marvel Super Heroes: " + t.getShortDescription());
            return subjects;
        }

        public void retrieveTopic(String t) {
            topic = t;
        }

        public void setTopics() {
            currentTopic = new Topic();

            if (topic.equals("Math")) {
                setMathTopic(currentTopic);

            } else if(topic.equals("Physics")) {
                setPhysicsTopic(currentTopic);

            } else if(topic.equals("Marvel Super Heroes")){
                setMarvelTopic(currentTopic);

            }

        }

        public Topic getCurrentTopic() {
            return currentTopic;
        }

        public Topic setMathTopic(Topic topic) {
            topic.setTopic("Math");
            topic.setLongDescription("This quiz will ask 2 math questions");
            topic.setShortDescription("This is a math Quiz");
            ArrayList<String> questions = new ArrayList<String>();
            topic.setQuestions(setMathQuestions(questions));
            return topic;
        }

        public Topic setPhysicsTopic(Topic topic) {
            topic.setTopic("Physics");
            topic.setLongDescription("This quiz will ask 2 physics questions");
            topic.setShortDescription("This is a physics Quiz");
            ArrayList<String> questions = new ArrayList<String>();
            topic.setQuestions(setPhysicsQuestions(questions));
            return topic;
        }

        public Topic setMarvelTopic(Topic topic) {
            topic.setTopic("Marvel Super Heroes");
            topic.setLongDescription("This quiz will ask 2 Marve Super Hero questions");
            topic.setShortDescription("This is a marvel Quiz");
            ArrayList<String> questions = new ArrayList<String>();
            topic.setQuestions(setMarvelQuestions(questions));
            return topic;
        }

        public ArrayList<String> setMathQuestions(ArrayList<String> options) {
            options.add("What does 1 * 1 equal?");
            options.add("What does 246 / 2 equal?");
            return options;
        }

        public ArrayList<String> setPhysicsQuestions(ArrayList<String> options) {
            options.add("If an object is in motion, what kind of energy does it possess?");
            options.add("What is the force that holds back a sliding object?");
            return options;
        }

        public ArrayList<String> setMarvelQuestions(ArrayList<String> options) {
            options.add("Which character was bitten by a radioactive spider as a high school student?");
            options.add("Which character was in a gamma bomb explosion while trying to save the life of a teenager");
            return options;
        }

        //QUIZZES
        private Quiz mathQuiz;
        private Quiz physicsQuiz;
        private Quiz marvelQuiz;
        private int quizCount;

        private Map<String, ArrayList<String>> answerMap;

        private Quiz currentQuiz;

        public void setTopicQuiz() {
            currentQuiz = new Quiz();
            answerMap = new HashMap<String, ArrayList<String>>();

            if(currentTopic.getTopic().equals("Math")) {
                setMathQuiz(currentQuiz);

            } else if(currentTopic.getTopic().equals("Physics")) {
                setPhysicsQuiz(currentQuiz);

            } else if(currentTopic.getTopic().equals("Marvel Super Heroes")) {
                setMarvelQuiz(currentQuiz);

            }
        }

        public Quiz getCurrentQuiz() {
            return currentQuiz;
        }

        public Map<String, ArrayList<String>> getAnswerMap() {
            return answerMap;
        }

        public void setMathQuiz(Quiz quiz) {
            ArrayList<String> answerList = new ArrayList<String>();
            String question;

            if (quizCount == 0) {
                question = currentTopic.getQuestions().get(0);

                answerList.add("1");
                answerList.add("2");
                answerList.add("11");
                answerList.add("110");

                currentQuiz.setAnswerOptions(answerList);
                currentQuiz.setCorrectAnswer(0);
                answerMap.put(question, currentQuiz.getAnswerOptions());

            } else if (quizCount == 1) {
                question = currentTopic.getQuestions().get(1);
                answerList = new ArrayList<String>();

                answerList.add("2");
                answerList.add("100");
                answerList.add("123");
                answerList.add("246");

                quiz.setAnswerOptions(answerList);
                quiz.setCorrectAnswer(2);
                answerMap.put(question, currentQuiz.getAnswerOptions());
            }
        }


        public void setPhysicsQuiz(Quiz quiz){
            ArrayList<String> answerList = new ArrayList<String>();
            String question;
            if(quizCount == 0) {
                question = currentTopic.getQuestions().get(0);
                answerList.add("Potential Energy");
                answerList.add("Metabolic Energy");
                answerList.add("Kinetic Energy");
                answerList.add("Caloric Energy");
                quiz.setAnswerOptions(answerList);
                quiz.setCorrectAnswer(2);
                answerMap.put(question, currentQuiz.getAnswerOptions());

            } else if(quizCount == 1) {
                question = currentTopic.getQuestions().get(1);
                answerList = new ArrayList<String>();
                answerList.add("Deceleration");
                answerList.add("Momentum");
                answerList.add("Gravity");
                answerList.add("Friction");
                quiz.setAnswerOptions(answerList);
                quiz.setCorrectAnswer(3);
                answerMap.put(question, currentQuiz.getAnswerOptions());

            }
        }

        public void setMarvelQuiz(Quiz quiz){
            ArrayList<String> answerList = new ArrayList<String>();
            String question;
            if(quizCount == 0) {
                question = currentTopic.getQuestions().get(0);
                answerList.add("Peter Benjamin Parker");
                answerList.add("Robert Bruce Banner");
                answerList.add("Anthony Edward Stark");
                answerList.add("Steven Rogers");
                quiz.setAnswerOptions(answerList);
                quiz.setCorrectAnswer(0);
                answerMap.put(question, currentQuiz.getAnswerOptions());

            } else if(quizCount == 1) {
                question = currentTopic.getQuestions().get(1);
                answerList = new ArrayList<String>();
                answerList.add("Peter Benjamin Parker");
                answerList.add("Robert Bruce Banner");
                answerList.add("Anthony Edward Stark");
                answerList.add("Steven Rogers");
                quiz.setAnswerOptions(answerList);
                quiz.setCorrectAnswer(1);
                answerMap.put(question, currentQuiz.getAnswerOptions());
            }
        }

        //Getters/Setters

        @Override
        public String getTopic() {
            return currentTopic.getTopic();
        }

        @Override
        public void setTopic(String topic) {
            currentTopic.setTopic(topic);

        }

        @Override
        public String getShortDescription() {
            return currentTopic.getShortDescription();
        }

        @Override
        public void setShortDescription(String shortDescription) {
            currentTopic.setShortDescription(shortDescription);


        }

        @Override
        public String getLongDescription() {
            return currentTopic.getLongDescription();
        }

        @Override
        public void setLongDescription(String longDescription) {
            currentTopic.setLongDescription(longDescription);

        }

        @Override
        public ArrayList<String> getQuestions() {
            return currentTopic.getQuestions();
        }

        @Override
        public void setQuestions(ArrayList<String> questions) {
            currentTopic.setQuestions(questions);

        }

        @Override
        public int getQuizCount() {
            return quizCount;
        }

        @Override
        public void setQuizCount(int n) {
            quizCount = n;
        }

        public int getCorrectAnswer() {
            return currentQuiz.getCorrectAnswer();

        }

        public void setCorrectAnswer(int correctAnswer) {
            currentQuiz.setCorrectAnswer(correctAnswer);

        }

        public ArrayList<String> getAnswerOptions() {
            return currentQuiz.getAnswerOptions();

        }

        public void setAnswerOptions(ArrayList<String> answerOptions) {
            currentQuiz.getAnswerOptions();

        }



    }


