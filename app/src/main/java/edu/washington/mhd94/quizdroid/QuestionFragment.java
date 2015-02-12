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




public class QuestionFragment extends android.support.v4.app.Fragment {
    int count = 1;
    int correctCount = 0;
    String subject = "";
    RadioGroup rg;
    Button b;

    public QuestionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_third, container, false);
       /* b = (Button) rootView.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }

        });*/

        return rootView;
    }


    public void button(View v) {
        Button b = (Button) getView().findViewById(R.id.submit);
        b.setVisibility(View.VISIBLE);
    }


}
