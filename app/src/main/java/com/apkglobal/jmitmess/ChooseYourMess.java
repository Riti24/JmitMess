package com.apkglobal.jmitmess;
import android.content.Intent;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ChooseYourMess extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String []name={"Select Your mess","Padmavatti Bhavan","Jagat Bhavan"};
    Spinner spin;
    Button btn_incharge;
    TextView tv_admin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_mess);
        /*setContentView(R.layout.spinner);*/
        spin=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(ChooseYourMess.this,R.layout.spinner_item,name);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        btn_incharge=(Button)findViewById(R.id.btn_incharge);
        tv_admin=(TextView) findViewById(R.id.tv_admin);
       // btn_incharge.setOnClickListener(this);
        //tv_admin.setOnClickListener(this);
        btn_incharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(ChooseYourMess.this,InchargeLogin.class);
                        startActivity(i);

            }
        });
        tv_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChooseYourMess.this,Admin.class);
                startActivity(i);

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("mode",position).commit();
        switch(position)
        {
            case 0:
              /*  Intent in=new Intent(ChooseYourMess.this,MenuActivity.class);
                startActivity(in);*/
                break;
            case 1:

                Intent x=new Intent(ChooseYourMess.this,MenuActivity.class);
               // x.putExtra(Intent.EXTRA_TEXT, "girls");
                startActivity(x);
                break;
            case 2:

                Intent z=new Intent(ChooseYourMess.this,MenuActivity.class);
                //z.putExtra(Intent.EXTRA_TEXT, "boys");

                startActivity(z);
                break;
            default:



        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //r
    }

  /*  @Override*//*
    public void onClick(View v) {
        Intent i=new Intent(ChooseYourMess.this,LoginActivity.class);
        startActivity(i);

    }*/
    int backpress=0;
    long time=0;
    @Override
    public void onBackPressed(){
        if(backpress==0 || System.currentTimeMillis()-time>2000){
            time= System.currentTimeMillis();
            Log.d("time",time+"");
            backpress=1;
            Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
        }else{
            super.onBackPressed();
        }

    }
}
