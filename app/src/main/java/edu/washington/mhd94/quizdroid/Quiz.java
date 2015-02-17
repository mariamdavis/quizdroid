package edu.washington.mhd94.quizdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by mariam on 2/14/15.
 */
public class Quiz {

    private ArrayList<String> answerOptions;
    private int correctAnswer;

    Quiz() {
        answerOptions = new ArrayList<String>();
        correctAnswer = -1;
    }


    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(ArrayList<String> answerOptions) {
        this.answerOptions = answerOptions;
    }


}
