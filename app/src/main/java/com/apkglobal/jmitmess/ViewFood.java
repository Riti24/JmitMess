package com.apkglobal.jmitmess;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ViewFood extends Fragment {

    public static final String JSON_URL = "http://searchkero.com/Ritika/fetch.php";

    private Button buttonGet;

    TextView tv_day, tv_menu;


    @Nullable

    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_food, container, false);

        tv_day = (TextView) view.findViewById(R.id.tv_day);

        tv_menu = (TextView) view.findViewById(R.id.tv_menu);
        buttonGet = (Button) view.findViewById(R.id.buttonGet);

return view;
    }
}





