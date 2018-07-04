package com.example.nguyenbaongoc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText edtAccout;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAccout = (EditText) findViewById(R.id.account);
        edtPassword = (EditText) findViewById(R.id.password);

    }

    public void onForgotpass(View view) {
        onCreatacc(view);
    }

    public void onCreatacc(View view) {

    }

    public void onVerify(View view) {

    }

    public void onBtlogin(View view) {
        String text = edtAccout.getText() + "\n" + edtPassword.getText();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                "http://kangarooiot.com/api/v1/auth/login", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("AAAA", response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("AAAA", error.toString());
            }
        }) {

            @Override
            public byte[] getBody() {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("username", "demo");
                params.put("password", "ZmUwMWNlMmE3ZmJhYzhmYWZhZWQ3Yzk4MmEwNGUyMjk=");

                return new JSONObject(params).toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        RequestQueue mRequestQueue = Volley.newRequestQueue(this.getApplicationContext());
        mRequestQueue.add(jsonObjectRequest);
        mRequestQueue.start();
    }

    public void onBtoffline(View view) {
    }
}
