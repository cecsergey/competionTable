package com.android.sergey.competitiontable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Sergey on 4/1/2016.
 */
public class CardActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.table_cards);

        TextView participant1_name = (TextView) findViewById(R.id.participant1);
        TextView participant2_name = (TextView) findViewById(R.id.participant2);



    }
}
