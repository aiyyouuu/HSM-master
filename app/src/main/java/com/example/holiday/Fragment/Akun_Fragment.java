package com.example.holiday.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.holiday.R;
import com.example.holiday.View.EditActivity;

public class Akun_Fragment extends Fragment {
    View view;
    private Button btnLogout, btnEdit;
    EditText isi, nomor;
    SharedPreferences sharedPreferences;
    TextView userr;
    Boolean savelogin;
    String kata,email,hp;


    public Akun_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_akun, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEdit = view.findViewById(R.id.edit);
        isi = view.findViewById(R.id.isie);
        nomor = view.findViewById(R.id.number);
        String name = getActivity().getIntent().getStringExtra("username");
        String text = name;
        userr.setText(text);

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("Save save an", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        kata = pref.getString("Nama", "");
        if (!kata.equals("")) {
            userr.setText(kata);
        }
        email = pref.getString("Email", "");
        if (!kata.equals("")) {
            isi.setText(email);
        }

        hp = pref.getString("Telpon", "");
        if (!kata.equals("")) {
            nomor.setText(hp);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti = new Intent(getActivity().getApplicationContext(), EditActivity.class);
                startActivity(ganti);
            }
        });

    }

}
