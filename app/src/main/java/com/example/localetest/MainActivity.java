package com.example.localetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = this.findViewById(R.id.textView);
        this.button = this.findViewById(R.id.switch_button);
        this.button.setOnClickListener( v -> {
            /*
            Locale locale = Locale.getDefault();
            Toast toast = Toast.makeText(this, locale.getDisplayName() , Toast.LENGTH_SHORT);
            toast.show();
             */
            Resources resources = this.getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            Configuration config = resources.getConfiguration();
            config.setLocale(Locale.SIMPLIFIED_CHINESE);
            resources.updateConfiguration(config, metrics);
            //this.getBaseContext().createConfigurationContext(config);
            recreate();
            /*
            Toast toast = Toast.makeText(this, "config ok!" , Toast.LENGTH_SHORT);
            toast.show();
             */
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast toast = Toast.makeText(this, "config changed!" , Toast.LENGTH_SHORT);
        toast.show();
    }
}