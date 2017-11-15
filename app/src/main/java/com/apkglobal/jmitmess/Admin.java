package com.apkglobal.jmitmess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
 TextView textview_Admin;
    EditText Eittexemail;
    Button btn_admin;
    String message="345678";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        textview_Admin=(TextView)findViewById(R.id.textview_Admin);
        Eittexemail=(EditText)findViewById(R.id.Eittexemail);
        btn_admin=(Button)findViewById(R.id.btn_admin);
        btn_admin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = Eittexemail.getText().toString();
                if (password.equals(message))
                {
                    Intent i=new Intent(Admin.this,RegisterIncharge.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

}
}
