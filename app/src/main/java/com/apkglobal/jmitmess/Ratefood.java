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
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Ritika on 7/19/2017.
 */

public class Ratefood extends Fragment{

    public RatingBar ratingBar1;
    public RatingBar ratingBar2;
    public RatingBar ratingBar3;
    Button submit1;
    Button submit2;
    Button submit3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ratefood,container,false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean Islogin = prefs.getBoolean("Islogin", false); // get value of last login status
        if(Islogin) {
            ratingBar1 = (RatingBar) view.findViewById(R.id.ratingBar1);
            ratingBar2 = (RatingBar) view.findViewById(R.id.ratingBar2);
            ratingBar3 = (RatingBar) view.findViewById(R.id.ratingBar3);
            submit1 = (Button) view.findViewById(R.id.submit1);
            submit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),
                            String.valueOf(ratingBar1.getRating()), Toast.LENGTH_LONG).show();
                    //send this rated no to server
                }
            });
            submit2 = (Button) view.findViewById(R.id.submit2);
            submit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),
                            String.valueOf(ratingBar2.getRating()), Toast.LENGTH_LONG).show();
                    //send this rated no. to server
                }
            });
            submit3 = (Button) view.findViewById(R.id.submit3);
            submit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),
                            String.valueOf(ratingBar3.getRating()), Toast.LENGTH_LONG).show();
                    //send this rated no. to server
                }
            });
        }
        else {
            Intent i=new Intent(getContext(),LoginActivity.class);
            startActivityForResult(i,1);
            //condition false take user on login form
        }

        return view;

    }
}

