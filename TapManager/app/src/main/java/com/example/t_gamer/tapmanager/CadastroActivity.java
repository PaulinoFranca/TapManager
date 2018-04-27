package com.example.t_gamer.tapmanager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends Activity implements View.OnClickListener {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etEmpresa;
    private EditText etCargo;
    private Button btnCadastra;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getActionBar().setTitle("Registre-se");

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etEmpresa = findViewById(R.id.etEmpresa);
        etCargo = findViewById(R.id.etCargo);
        btnCadastra = findViewById(R.id.btnCadastra);

        btnCadastra.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCadastra:
                break;
        }

    }
}
