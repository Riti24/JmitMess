package com.apkglobal.jmitmess;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.apkglobal.jmitmess.utils.VolleyHelper;
import com.apkglobal.jmitmess.utils.VolleyInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ViewFood extends Fragment implements VolleyInterface {

    public static final String JSON_URL = "http://searchkero.com/Ritika/fetch.php";

    private Button buttonGet;

    TextView tv_day, tv_menu;


    @Nullable

    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_food, container, false);

        tv_day = (TextView) view.findViewById(R.id.tv_day);

        tv_menu = (TextView) view.findViewById(R.id.tv_menu);
        int i= PreferenceManager.getDefaultSharedPreferences(getActivity()).getInt("mode",1);
        VolleyHelper.postRequestVolley(getActivity(),this,"http://searchkero.com/Ritika/"+(i==1?"fetch.php":"boysfetch.php"),new HashMap<String, String>(),1);
        return view;
    }

    @Override
    public void requestStarted(int requestCode) {

    }

    @Override
    public void requestCompleted(int requestCode, String response) {
        Log.d("res",response);
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray k=jsonObject.getJSONArray("data");
            String day=k.getJSONObject(0).getString("Day");
            String menu=k.getJSONObject(0).getString("Menu");
            tv_day.setText(day);
            tv_menu.setText(menu);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestEndedWithError(int requestCode, VolleyError error) {

    }
}





