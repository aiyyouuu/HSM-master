package com.example.holiday.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.holiday.Adapter.HolidayAdapter;
import com.example.holiday.Model.HolidayItem;
import com.example.holiday.Presenter.MainPresenter;
import com.example.holiday.Presenter.MainView;
import com.example.holiday.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment implements MainView {
    private RecyclerView rc;
    private HolidayAdapter adapter;
    private MainPresenter mainPresenter;
    private String country = "ID";
    private String year = "2019";
    private String month = "6";

    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        rc = (RecyclerView) view.findViewById(R.id.rec_holiday);
        mainPresenter = new MainPresenter(getContext(), this);
        mainPresenter.loadHoliday(country,year,month);
    }

    @Override
    public void onSucces(List<HolidayItem> holidayItemList) {
        adapter = new HolidayAdapter(getContext(), holidayItemList);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(),"onError" + errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(),"onFailure" + failureMessage, Toast.LENGTH_LONG).show();
    }

}
