package edu.washington.mhd94.quizdroid;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by mariam on 2/14/15.
 */
public interface TopicRepository{

   // public ArrayList<String> getTopics();
   // public void setTopics();
    public String getTopic();
    public void setTopic(String topic);
    public String getShortDescription();
    public void setShortDescription(String shortDescription);
    public String getLongDescription();
    public void setLongDescription(String longDescription);
    public ArrayList<String> getQuestions();
    public void setQuestions(ArrayList<String> questions);
    public int getQuizCount();
    public void setQuizCount(int n);

   public int getCorrectAnswer();
   public void setCorrectAnswer(int correctAnswer);
   public ArrayList<String> getAnswerOptions();
  public void setAnswerOptions(ArrayList<String> answerOptions);




}
