package edu.washington.mhd94.quizdroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OverviewFragment extends android.support.v4.app.Fragment {

        String subject = "math";


        public OverviewFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View rootView = inflater.inflate(R.layout.activity_second, container, false);
            //String subject = (String) getActivity().getSubject();



            TextView topic = (TextView) rootView.findViewById(R.id.question);
            topic.setText("Topic Overview " + subject );

            TextView description = (TextView) rootView.findViewById(R.id.description);
            description.setText("This quiz will ask basic " + subject + " questions.");

            return rootView;
        }

    }