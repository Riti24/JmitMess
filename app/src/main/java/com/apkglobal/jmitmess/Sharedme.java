package com.apkglobal.jmitmess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Ritika on 7/31/2017.
 */

public class Sharedme {
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    Context c;
    String Filename="merifile";
    String Islogin="islogin";
    int mode=0;
    public Sharedme(Context c)
    {
        this.c=c;
        sp=c.getSharedPreferences(Filename,mode);
        ed=sp.edit();

    }


    //for the first time user
    public void createlogin()
    {
        ed.putBoolean(Islogin,true);
        ed.commit();
    }
    //for second time user
    public void checklogin()
    {
        if(!this.login())
        {
            Intent login=new Intent(c,LoginActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(login);
        }
    }

    private boolean login() {
        return sp.getBoolean(Islogin,false);
    }
}
