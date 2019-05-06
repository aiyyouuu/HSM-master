package com.example.holiday.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.holiday.Adapter.HolidayAdapter;
import com.example.holiday.Model.HolidayItem;
import com.example.holiday.Presenter.MainPresenter;
import com.example.holiday.Presenter.MainView;
import com.example.holiday.R;

import java.util.List;

public class MainActivityRV extends AppCompatActivity implements MainView {
    private RecyclerView rc;
    private HolidayAdapter adapter;
    private MainPresenter mainPresenter;
    private String country = "US";
    private String year = "2019";
    private String month = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rv);
        rc = findViewById(R.id.rec_holiday);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadHoliday(country, year, month);
    }

    @Override
    public void onSucces(List<HolidayItem> holidayItemList) {
        adapter = new HolidayAdapter(getApplicationContext(), holidayItemList);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
