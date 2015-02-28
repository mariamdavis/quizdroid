package edu.washington.mhd94.quizdroid;

import java.util.ArrayList;

/**
 * Created by mariam on 2/25/15.
 */
public class fileInfo implements TopicRepository {
    String json;



    public String getJSON() {
        return null;
    }

    public void setJSON(String json) {
        this.json = json;

    }



    @Override
    public String getTopic() {
        return null;
    }

    @Override
    public void setTopic(String topic) {

    }

    @Override
    public String getShortDescription() {
        return null;
    }

    @Override
    public void setShortDescription(String shortDescription) {

    }

    @Override
    public String getLongDescription() {
        return null;
    }

    @Override
    public void setLongDescription(String longDescription) {

    }

    @Override
    public ArrayList<String> getQuestions() {
        return null;
    }

    @Override
    public void setQuestions(ArrayList<String> questions) {

    }

    @Override
    public int getQuizCount() {
        return 0;
    }

    @Override
    public void setQuizCount(int n) {

    }

    @Override
    public int getCorrectAnswer() {
        return 0;
    }

    @Override
    public void setCorrectAnswer(int correctAnswer) {

    }

    @Override
    public ArrayList<String> getAnswerOptions() {
        return null;
    }

    @Override
    public void setAnswerOptions(ArrayList<String> answerOptions) {

    }
}
