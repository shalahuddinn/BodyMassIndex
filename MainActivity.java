package com.example.android.bodymassindex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    //kamus
    EditText inputberat, inputtinggi;
    Float berat, tinggi, temp;
    String hasil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mendefinisi
        inputberat = (EditText) findViewById(R.id.inputberat_edittext);
        inputtinggi = (EditText) findViewById(R.id.inputtinggi_edittext);

        Button submit = (Button)findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //cek input kosong
                if((inputberat.getText().toString().equals("")) || (inputtinggi.getText().toString().equals("")))
                {
                    Toast.makeText(MainActivity.this, "Error : Input Kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    //input tidak kosong
                    berat = Float.valueOf(inputberat.getText().toString());
                    tinggi = Float.valueOf(inputtinggi.getText().toString());
                    //perhitungan
                    temp = berat / (tinggi * tinggi / 10000);
                    //klasifikasi
                    if (temp <= 17) {
                        hasil = "Sangat Kurus";
                    } else if (temp > 17 && temp <= 18.5) {
                        hasil = "Kurus";
                    } else if (temp > 18.5 && temp <= 24.9) {
                        hasil = "Normal";
                    } else if (temp > 24.9 && temp <= 29.9) {
                        hasil = "Gemuk";
                    } else if (temp > 29.9 && temp <= 34.9) {
                        hasil = "Obesitas Level I";
                    } else if (temp > 34.9 && temp <= 39.9) {
                        hasil = "Obesitas Level II";
                    } else {
                        hasil = "Obesitas Level III";
                    }
                    //pindah activity
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("pesan", hasil); //mengirim hasil ke main2activity
                    startActivity(i);
                }
            }
        });
    }
}