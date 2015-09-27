package com.example.administrator.spinnerreview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button GoOn;
    Button AddAPerson;
    TextView oNameOfPerson;
    TextView oStatOfPerson;
    EditText iNameOfPerson;
    EditText iStatOfPerson;
    Spinner PersonSpinner;

    ArrayList<String> course;

    HashMap<String, Person> holder;
    Person p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = new Person();
        p1.name = "Hi There";
        p1.stat1 = "-1";
        course = new ArrayList<String>();
        course.add("Hi There");


        holder = new HashMap<String, Person>();
        holder.put("Hi There", p1);

        AddAPerson = (Button)findViewById(R.id.AddAPerson);
        AddAPerson.setOnClickListener(this);

        GoOn = (Button)findViewById(R.id.GoOn);
        GoOn.setOnClickListener(this);

        iNameOfPerson = (EditText)findViewById(R.id.iNameOfPerson);
        iStatOfPerson = (EditText)findViewById(R.id.iStatOfPerson);

        oNameOfPerson = (TextView)findViewById(R.id.oNameOfPerson);
        oStatOfPerson = (TextView)findViewById(R.id.oStatOfPerson);

        PersonSpinner = (Spinner)findViewById(R.id.PersonSpinner);
        PersonSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        PersonSpinner.setAdapter(adapter);

        course.add("Buddy");


    }


    @Override
    public void onClick(View v) {

        if(v == AddAPerson)
        {

            Person pTemp = new Person();
            pTemp.name = iNameOfPerson.getText().toString();
            pTemp.stat1 = iStatOfPerson.getText().toString();

            holder.put(iNameOfPerson.getText().toString(), pTemp);

            course.add(iNameOfPerson.getText().toString());

        }

        if(v == GoOn)
        {

            Intent intent1 = new Intent(this, MainActivity2Activity.class);

            intent1.putExtra("Testing", "This is my String");

            intent1.putExtra("table", holder);

            startActivityForResult(intent1, 100);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(view == PersonSpinner)
        {

            //Doesn't actually get to this part of the program. Why?
            Person pTemp = holder.get(PersonSpinner.getSelectedItem().toString());
            oNameOfPerson.setText( pTemp.name );
            oStatOfPerson.setText( pTemp.stat1 );

            course.add(iNameOfPerson.getText().toString());

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
