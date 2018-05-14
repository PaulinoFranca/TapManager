package com.example.t_gamer.tapmanager.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t_gamer.tapmanager.Activity.HomeActivity;
import com.example.t_gamer.tapmanager.Entidades.Usuarios;
import com.example.t_gamer.tapmanager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etSenha;
    private Button btnLogin;
    private Button btnEsqSenha;
    private Usuarios usuarios;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getActionBar().setTitle("Entrar");

        btnLogin = findViewById(R.id.btnLogin);
        btnEsqSenha = findViewById(R.id.btnEsqSenha);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);

        btnLogin.setOnClickListener(this);
        btnEsqSenha.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if (!etEmail.getText().toString().equals("") && !etSenha.getText().toString().equals("")) {

                    usuarios = new Usuarios();
                    usuarios.setEmail(etEmail.getText().toString());
                    usuarios.setSenha(etSenha.getText().toString());

                    validarLogin();

                }else {
                    Toast.makeText(LoginActivity.this,"Preencha os campos!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEsqSenha:
                //usuarios = new Usuarios();
                String email = etEmail.getText().toString();
                mAuth.sendPasswordResetEmail(email);
                Toast.makeText(LoginActivity.this,"Sua senha foi resetada, cheque seu email!",Toast.LENGTH_SHORT).show();
                break;
        }

    }
    /***/
    private void validarLogin() {

        mAuth.signInWithEmailAndPassword(usuarios.getEmail(),usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent telaHome = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(telaHome);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Email ou Senha errados!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /***/
}
