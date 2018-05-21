package com.example.t_gamer.tapmanager.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.t_gamer.tapmanager.R;

public class HomeActivity extends Activity implements View.OnClickListener  {

    private FloatingActionButton btnTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTap = findViewById(R.id.btnTap);

        btnTap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTap:
                Intent telaTap = new Intent(HomeActivity.this,TapActivity.class);
                startActivity(telaTap);
                finish();

                break;
        }

    }
}
