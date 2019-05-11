package com.example.holiday.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.holiday.Connection.AddPreferences;
import com.example.holiday.Model.login.get_user.LoginResponse;
import com.example.holiday.Model.login.update.CreateResponse;
import com.example.holiday.Presenter.GetUserPresenter;
import com.example.holiday.Presenter.GetUserView;
import com.example.holiday.Presenter.UpdatePresenter;
import com.example.holiday.Presenter.UpdateView;
import com.example.holiday.R;

public class EditActivity extends AppCompatActivity implements UpdateView,GetUserView {
    EditText nama;
    Button kembali, simpan;
    UpdatePresenter updatePresenter;
    private AddPreferences addPreferences;
    GetUserPresenter getUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_akun);

        getUserPresenter = new GetUserPresenter(getApplicationContext(),this);
        addPreferences = new AddPreferences(getApplicationContext());
        getUserPresenter.ambil(addPreferences.getToken());

        nama = findViewById(R.id.isinama);
        kembali = findViewById(R.id.cancel);
        simpan = findViewById(R.id.save);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void updateUser(View view) {
        String username = nama.getText().toString();
        updatePresenter = new UpdatePresenter(getApplicationContext(), this);
        updatePresenter.update(addPreferences.getToken(),username);
    }

    @Override
    public void onSucces(CreateResponse update) {
        Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }

    @Override
    public void onSucces(LoginResponse loginResponse) {
        nama.setText(loginResponse.getNama());
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_SHORT).show();
    }
}
