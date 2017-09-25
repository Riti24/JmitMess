package com.apkglobal.jmitmess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Created by Ritika on 8/5/2017.
 */



    public class MenuLogout extends AppCompatActivity {
    MenuItem LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.equals(LogOut))
        {
            SharedPreferences mSharedPreference =getSharedPreferences("SharedData", Context.MODE_PRIVATE);
            SharedPreferences.Editor mSaveState = mSharedPreference.edit();
            mSaveState.putBoolean("LoginSession", false);
            mSaveState.commit();
            Intent logout = new Intent(this,LoginActivity.class);
            logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logout);

        }
        return true;

        }

    }


