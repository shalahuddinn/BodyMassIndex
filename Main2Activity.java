package com.example.android.bodymassindex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView hasiltext = (TextView)findViewById(R.id.hasil_textview);
        Button back = (Button)findViewById(R.id.back_button);

        //menerima hasil dari mainactivity
        Intent i = this.getIntent();
        hasiltext.setText(""+i.getStringExtra("pesan"));

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}