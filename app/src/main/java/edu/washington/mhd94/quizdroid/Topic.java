package edu.washington.mhd94.quizdroid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mariam on 2/14/15.
 */
public class Topic {
   private String topic;
   private String shortDescription;
   private String longDescription;
   private ArrayList<String> questions;

   public Topic() {
       topic = "";
       shortDescription = "";
       longDescription = "";
       questions = new ArrayList<String>();


   }




    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

}
