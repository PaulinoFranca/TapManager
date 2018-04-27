package com.example.t_gamer.tapmanager;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler executor = new Handler();
        executor.postDelayed(this,1000);
    }

    @Override
    public void run() {

        Intent telaInicio = new Intent(getApplicationContext(),LoginCadastroActivity.class);
        startActivity(telaInicio);
        finish();

    }
}
