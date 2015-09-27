package com.example.administrator.spinnerreview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


public class MainActivity2Activity extends ActionBarActivity implements Serializable, View.OnClickListener{

    TextView Send;
    Button GoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        GoBack = (Button)findViewById(R.id.GoBack);
        GoBack.setOnClickListener(this);

        Send = (TextView) findViewById(R.id.Send);

        Intent intent2 = this.getIntent();

        String a = (String)intent2.getStringExtra("Testing");

        Send.setText(a);



    }


    @Override
    public void onClick(View v) {

        finish();

    }
}
