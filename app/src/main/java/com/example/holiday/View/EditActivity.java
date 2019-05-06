package com.example.holiday.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.holiday.R;

public class EditActivity extends AppCompatActivity {

    EditText nama, email, telpon;
    Button kembali, simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_akun);

        nama = findViewById(R.id.isinama);
        email = findViewById(R.id.isie);
        telpon = findViewById(R.id.number);
        kembali = findViewById(R.id.cancel);
        simpan = findViewById(R.id.save);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Save save an", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nama.getText().toString().equals("")&&!email.getText().toString().equals("")&&!telpon.getText().toString().equals("")) {
                    editor.putString("Nama", nama.getText().toString());
                    editor.putString("Email", email.getText().toString());
                    editor.putString("Telpon", telpon.getText().toString());
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    finish();
                }
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
