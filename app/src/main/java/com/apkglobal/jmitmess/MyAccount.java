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
import android.widget.TextView;

import com.apkglobal.jmitmess.Reset_Password;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Ritika on 7/19/2017.
 */

public class MyAccount extends Fragment {
    @Nullable
    TextView tv_name;
    TextView tv_email;
    Button btn_changepassword;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.myaccount,container,false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean Islogin = prefs.getBoolean("Islogin", false); // get value of last login status

         tv_name=(TextView)view.findViewById(R.id.tv_name);
        tv_email=(TextView)view.findViewById(R.id.tv_email);
        if(Islogin)
        {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {

                // Name, email address, and profile photo Url
                String name = user.getDisplayName();
                String email = user.getEmail();
                //Uri photoUrl = user.getPhotoUrl();

                // The user's ID, unique to the Firebase project. Do NOT use this value to
                // authenticate with your backend server, if you have one. Use
                // FirebaseUser.getToken() instead.
                String uid = user.getUid();
                tv_name.setText(name.toString());
                tv_email.setText(email.toString());

            }

            //fetch and display the data from server of logged in person
            btn_changepassword=(Button)view.findViewById(R.id.btn_changepassword);
            btn_changepassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getActivity(),Reset_Password.class);
                    startActivity(i);

                }
            });

        }

        else
        {
            Intent i=new Intent(getContext(),LoginActivity.class);
            startActivityForResult(i,1);
            //condition false take user on login form
        }
        return view;

    }
}
