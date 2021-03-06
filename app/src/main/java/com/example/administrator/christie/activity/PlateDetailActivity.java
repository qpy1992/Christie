package com.example.administrator.christie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.christie.R;
import com.example.administrator.christie.adapter.CardsAdapter;
import com.example.administrator.christie.entity.Plate;
import com.example.administrator.christie.util.Consts;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlateDetailActivity extends AppCompatActivity {
    private TextView tv_plateno,tv_mobs,tv_model,tv_color;
    private LinearLayout ll_lxdh;
    private Button btn_back;
    public static final int SHOW_RESPONSE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate_detail);
        setViews();
        setListeners();
    }

    protected void setViews(){
        tv_plateno = (TextView)findViewById(R.id.tv_plateno);
        tv_mobs = (TextView)findViewById(R.id.tv_mobs);
        tv_model = (TextView)findViewById(R.id.tv_model);
        tv_color = (TextView)findViewById(R.id.tv_color);
        btn_back = (Button)findViewById(R.id.btn_back);
        ll_lxdh = (LinearLayout)findViewById(R.id.ll_lxdh);
        Intent intent = getIntent();
        Plate plate = (Plate) intent.getSerializableExtra("platedetail");
        tv_plateno.setText(plate.getFplateno());
        tv_mobs.setText(plate.getFmobile());
        tv_model.setText(plate.getFmodel());
        tv_color.setText(plate.getFcolor());
    }

    protected void setListeners(){
        ll_lxdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
