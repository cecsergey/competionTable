package com.android.sergey.competitiontable;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] participants = {"John", "Bob", "Alex" ,"Brown"};
    //private List<Contact> tempList;
    private ArrayList<Contact> tempList;
    private Contact contact;
    EditText inputParticipant;
    TextView outputParticipant;
    TableLayout participateTable;
    String participant="", pWeight =" ", pAge = " ";
    TextView participantWeight;
    Spinner spinnerForms;
    Button submit,delete,toss;
    private DatabaseHandler db;
    String[] objects = {"10","11","12","13","14","15","16","17","18","19","20","21","22"};

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db = new DatabaseHandler(this);
        inputParticipant = (EditText)findViewById(R.id.inputParticipant);
        participantWeight = (TextView) findViewById(R.id.weight);
        participateTable = (TableLayout)findViewById(R.id.tableLayout);

        //set on click for buttons
        submit = (Button)findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(this);
        delete = (Button)findViewById(R.id.buttonDelete);
        delete.setOnClickListener(this);
        toss = (Button)findViewById(R.id.buttonToss);
        toss.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, objects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerForms = (Spinner) findViewById(R.id.participantAge);
        spinnerForms.setAdapter(adapter);

        spinnerForms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // Todo: write code
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Todo: write code
            }
        });

        BuildTable();


        /**
         * CRUD Operations
         * */
        // Inserting Contacts


    }

    private void BuildTable() {
        Cursor cursor = db.readEntry();

        int  rows = cursor.getCount();
        int  colums = cursor.getColumnCount();
        cursor.moveToFirst();

        for (int i =0; i< rows;i++){

            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            for (int j = 0;j < colums; j++){

                TextView tv = new TextView(this);
                tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(cursor.getString(j));
                row.addView(tv);
            }

            cursor.moveToNext();

           participateTable.addView(row);
        }
    }



    public void onClick(View view) {

        Log.d("Insert: ", "Inserting ..");
        Log.d("Participan: ", participant);
        participateTable.removeAllViews();
        Toast toast;


        switch (view.getId()) {
            case R.id.buttonSubmit:
                participant = inputParticipant.getText().toString();
                pWeight = participantWeight.getText().toString();
                pAge = spinnerForms.getSelectedItem().toString();
                db.addContact(new Contact(participant, pWeight, pAge));
                BuildTable();
                toast = Toast.makeText(getApplicationContext(), "Participant " + participant + "weight" + pWeight + "age" + pAge, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.buttonDelete:
                toast = Toast.makeText(getApplicationContext(), "Table deleted ", Toast.LENGTH_SHORT);
                toast.show();
                db.deleteAllContacts();
                break;
            case R.id.buttonToss:
                tossParticipants();
                contact = tempList.get(0);
                String name1 = contact.getName();
                String age1 = contact.getAge();
                String weight1 = contact.getWeight();
                name1= "Name=" + name1 + ", " + age1 + "years," + weight1+"kg";

                contact =tempList.get(1);
                String name2 = contact.getName();
                BuildTable();
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                intent.putExtra("participant1",name1);
                intent.putExtra("participant2", name2);
                intent.putParcelableArrayListExtra("participants", tempList);
                startActivity(intent);
                break;
        }
    }



    public void tossParticipants() {
        int index;
        List<Contact> participantsList;
        tempList = new ArrayList<Contact>();
        participantsList = db.getAllContacts();
        int length = participantsList.size();

        Random rnd = new Random();

        //toss participant and add to new list
        while(length>0){
            index = rnd.nextInt(length);
            Contact smth = participantsList.get(index);
            tempList.add(smth);
            participantsList.remove(index);
            length=length-1;
        }


    }
}
