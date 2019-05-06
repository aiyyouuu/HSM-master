package com.example.holiday.View;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.holiday.Fragment.AllFragment;
import com.example.holiday.Fragment.MemoFragment;
import com.example.holiday.R;

public class MenuActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
        BottomNavigationView bottomNavigationView;
        Fragment fragment;
        TextView userrr;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigationView = findViewById(R.id.bnv);
        loadFragment(new AllFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        }

private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        return true;
        }
        return false;
        }

public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
        case R.id.menu2:
        fragment = new AllFragment();
        break;
        case R.id.menu3:
        fragment = new MemoFragment();
        break;
        }
        return loadFragment(fragment);
        }
}
