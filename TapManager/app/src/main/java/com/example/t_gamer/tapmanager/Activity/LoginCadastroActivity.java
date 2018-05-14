package com.example.t_gamer.tapmanager.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.t_gamer.tapmanager.R;

public class LoginCadastroActivity extends Activity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnRegistra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cadastro);
       //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegistra = findViewById(R.id.btnRegistra);

        btnLogin.setOnClickListener(this);
        btnRegistra.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                Intent telaLogin = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(telaLogin);
                break;
            case R.id.btnRegistra:
                Intent telaRegistra = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(telaRegistra);
                break;
        }

    }
}
