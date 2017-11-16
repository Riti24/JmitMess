package com.apkglobal.jmitmess;

import android.app.Application;
import android.preference.PreferenceManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by arpitkh996 on 06-09-2016.
 */

public class Amaze extends Application {
    private RequestQueue mRequestQueue;
    private static Amaze mInstance;

    public static synchronized Amaze getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());

    }
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public <T> void add(Request<T> req) {
        req.setTag("tag");
        getRequestQueue().add(req);
    }

    public void cancel() {
        mRequestQueue.cancelAll("tag");
    }

}
