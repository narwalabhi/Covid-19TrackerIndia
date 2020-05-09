package com.abhisheknarwal.covid_19trackerindia;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenuActivity extends AppCompatActivity {

    private static final String TAG = "OptionsMenuActivity";
    private boolean isDark = true;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.themeChange:
                if(isDark){
                    isDark = false;
                    getTheme().applyStyle(R.style.LightTheme, true);
//                    setTheme();
                }else{
                    isDark = true;
                    setTheme(R.style.DarkTheme);
                }
                Log.d(TAG, "onOptionsItemSelected: " + isDark);
                return true;
        }
        return false;
    }
}
