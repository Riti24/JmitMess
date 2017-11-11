package com.apkglobal.jmitmess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ritika on 7/19/2017.
 */

public class Feedback extends Fragment {
    Button btn_feedback;
    EditText ed_message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback, container, false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean Islogin = prefs.getBoolean("Islogin", false); // get value of last login status


        if (Islogin) {
            ed_message = (EditText) view.findViewById(R.id.ed_message);
            btn_feedback = (Button) view.findViewById(R.id.btn_feedback);

            btn_feedback.setOnClickListener(new OnClickListener());

        } else {

            Intent i = new Intent(getContext(), LoginActivity.class);
            startActivityForResult(i, 1);
            //condition false take user on login form
        }
        return view;
    }

    public EditText getEd_message() {
        return ed_message;
    }

    class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Feedback fd;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(intent.EXTRA_EMAIL, new String[]{"ritikabhattacharya248@gmail.com"});
            intent.putExtra(intent.EXTRA_SUBJECT, "My feedback for today's food");

            intent.putExtra(intent.EXTRA_TEXT,ed_message.getText().toString());
            intent.setType("email/rfc822");
            startActivity(Intent.createChooser(intent, "Send Email"));
            Toast.makeText(getActivity(), "Your feedback is being recorded", Toast.LENGTH_LONG).show();


        }
    }


}
