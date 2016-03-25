package com.android.sergey.competitiontable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] participants = {"John", "Bob", "Alex" ,"Brown"};
    EditText inputParticipant;
    TextView outputParticipant;
    TableLayout participateList;
    String participant="";
    private DatabaseHandler db;
    String[] objects = {"10","11","12","13","14","15","16","17","18","19","20","21","22"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView participant1_name = (TextView) findViewById(R.id.participant1);
//        TextView participant2_name = (TextView) findViewById(R.id.participant2);
//        TextView participant3_name = (TextView) findViewById(R.id.participant3);
//        TextView participant4_name = (TextView) findViewById(R.id.participant4);

        db = new DatabaseHandler(this);
        inputParticipant = (EditText)findViewById(R.id.inputParticipant);
        participateList = (TableLayout)findViewById(R.id.tableLayout);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, objects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerForms = (Spinner) findViewById(R.id.participantAge);
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

    }

    public void onClick(View view) {

        Log.d("Insert: ", "Inserting ..");
        Log.d("Participan: ", participant);

        participant = inputParticipant.getText().toString();
        Toast toast =Toast.makeText(getApplicationContext(), "Participant " + participant, Toast.LENGTH_SHORT);
        toast.show();
        db.addContact(new Contact(participant));

//        Contact cn = db.getContact(10);
//
//        outputParticipant.setText(cn.getName());
    }

//    public void onClick(View view) {
//        Random rnd = new Random();
//        int index = rnd.nextInt(participants.length);
//        Toast toast =Toast.makeText(getApplicationContext(),"Participant "+ participants[index], Toast.LENGTH_SHORT);
//        toast.show();
//
//
//    }
}
