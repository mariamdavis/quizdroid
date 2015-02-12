package edu.washington.mhd94.quizdroid;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;




public class AnswerFragment extends android.support.v4.app.Fragment {
    int count = 1;
    int correctCount = 0;
    String subject = "";
    RadioGroup rg;
    Button b;


    public AnswerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_fourth, container, false);
        b = (Button) rootView.findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }

        });

        return rootView;
    }


}