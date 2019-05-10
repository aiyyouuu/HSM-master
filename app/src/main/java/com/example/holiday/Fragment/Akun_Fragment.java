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
import android.widget.Toast;

import com.example.holiday.Connection.AddPreferences;
import com.example.holiday.Model.login.get_user.LoginResponse;
import com.example.holiday.Model.login.update.CreateResponse;
import com.example.holiday.Presenter.GetUserPresenter;
import com.example.holiday.Presenter.GetUserView;
import com.example.holiday.Presenter.UpdateView;
import com.example.holiday.R;
import com.example.holiday.View.EditActivity;
import com.example.holiday.View.LoginActivity;

public class Akun_Fragment extends Fragment implements GetUserView, UpdateView {
    View view;
    private Button btnLogout, btnEdit;
    AddPreferences addPreferences;
    GetUserPresenter getUserPresenter;
    TextView userrr,imel;
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
        userrr = view.findViewById(R.id.nama);
        imel = view.findViewById(R.id.isie);
        btnLogout = view.findViewById(R.id.btn_login1);

        getUserPresenter = new GetUserPresenter(getContext(),this);
        addPreferences = new AddPreferences(getContext());
        getUserPresenter.ambil(addPreferences.getToken());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti = new Intent(getActivity().getApplicationContext(), EditActivity.class);
                startActivity(ganti);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPreferences.logout(addPreferences.getToken());
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }
    @Override
    public void onSucces(LoginResponse loginResponse){
        userrr.setText(loginResponse.getNama());
        imel.setText(loginResponse.getEmail());
    }

    @Override
    public void onSucces(CreateResponse update) {
        Toast.makeText(getContext(),"Update",Toast.LENGTH_SHORT).show();
        userrr.setText(update.getName());
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(),"Error"+errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(),"OnFailure" + failureMessage,Toast.LENGTH_SHORT).show();
    }
}
