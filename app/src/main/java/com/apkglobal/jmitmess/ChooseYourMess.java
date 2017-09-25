package com.apkglobal.jmitmess;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseYourMess extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    Button btn_incharge;
    String []name={"Select Your mess","Padmavatti Bhavan","Jagat Bhavan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_mess);
        /*setContentView(R.layout.spinner);*/
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(ChooseYourMess.this,android.R.layout.simple_spinner_item,name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btn_incharge=(Button)findViewById(R.id.btn_incharge);

        btn_incharge.setOnClickListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position)
        {
            case 0:
              /*  Intent in=new Intent(ChooseYourMess.this,MenuActivity.class);
                startActivity(in);*/
                break;
            case 1:
                Intent x=new Intent(ChooseYourMess.this,MenuActivity.class);
                startActivity(x);
                break;
            case 2:
                Intent z=new Intent(ChooseYourMess.this,MenuActivity.class);
                startActivity(z);
                break;
            default:



        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //r
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(ChooseYourMess.this,LoginActivity.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed(){
        int backpress=0;
        backpress = (backpress + 1);
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

        if (backpress>1) {
            this.finish();
        }
    }
}
