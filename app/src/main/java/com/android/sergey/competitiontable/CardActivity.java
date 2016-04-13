package com.android.sergey.competitiontable;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sergey on 4/1/2016.
 */
public class CardActivity extends Activity{
    private String name1,name2;
    private ArrayList<Contact> participantsList;
    private Contact contact;
    private int length;
    Toast toast;
    int i =2;
    Button next;
    TextView participant1_name,participant2_name;
    TableRow row1,row2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.table_cards);

         participant1_name = (TextView) findViewById(R.id.participant1);
         participant2_name = (TextView) findViewById(R.id.participant2);
        row1 = (TableRow) findViewById(R.id.row1);
        row2 = (TableRow) findViewById(R.id.row2);

        next = (Button)findViewById(R.id.next);


        name1 = getIntent().getExtras().getString("participant1");
        name2 = getIntent().getExtras().getString("participant2");

       participantsList = getIntent().getParcelableArrayListExtra("participants");
       length = participantsList.size();



        //toast = Toast.makeText(getApplicationContext(), "size "+ length, Toast.LENGTH_SHORT);
        //toast.show();


        participant1_name.setText(name1);
        participant2_name.setText(name2);


    }

    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.next:
                if (i < length) {
                    contact = participantsList.get(i);
                    String name1 = contact.getName();
                    String weight1 = contact.getWeight();
                    String age1 = contact.getAge();


                    participant1_name.setText("Name=" + name1 + ", " + age1 + "years," + weight1 + "kg");

                    contact = participantsList.get(i + 1);
                    String name2 = contact.getName();
                    String weight2 = contact.getWeight();
                    String age2 = contact.getAge();
                    participant2_name.setText("Name=" + name2 + ", " + age2 + "years," + weight2 + "kg");

                    i = i + 2;
                    row1.setBackgroundColor(Color.WHITE);
                    row2.setBackgroundColor(Color.WHITE);
                } else {
                    toast = Toast.makeText(getApplicationContext(), "This is last pair", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.row1:
                row1.setBackgroundColor(Color.GREEN);
                row2.setBackgroundColor(Color.RED);
                break;
            case R.id.row2:
                row1.setBackgroundColor(Color.RED);
                row2.setBackgroundColor(Color.GREEN);
                break;

        }
    }
}
