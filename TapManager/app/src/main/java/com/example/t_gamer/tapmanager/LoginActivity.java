package com.example.t_gamer.tapmanager;

import android.app.Activity;
import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etSenha;
    private Button btnLogin;
    private Button btnEsqSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActionBar().setTitle("Entrar");

        btnLogin = findViewById(R.id.btnLogin);
        btnEsqSenha = findViewById(R.id.btnEsqSenha);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);

        btnLogin.setOnClickListener(this);
        btnEsqSenha.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                Intent telaHome = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(telaHome);
                break;
            case R.id.btnEsqSenha:
                String email = etEmail.getText().toString().trim();
                //mAuth.sendPasswordResetEmail(email);
                break;
        }

    }

}
