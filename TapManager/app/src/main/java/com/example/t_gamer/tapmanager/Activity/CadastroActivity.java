package com.example.t_gamer.tapmanager.Activity;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t_gamer.tapmanager.Entidades.Usuarios;
import com.example.t_gamer.tapmanager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class CadastroActivity extends Activity implements View.OnClickListener {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etConfirmaSenha;
    private EditText etEmpresa;
    private EditText etCargo;
    private Button btnCadastra;
    private FirebaseAuth mAuth;
    private Usuarios usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //getActionBar().setTitle("Registre-se");

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etConfirmaSenha = findViewById(R.id.etConfirmaSenha);

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
                if (etSenha.getText().toString().equals(etConfirmaSenha.getText().toString())) {
                    usuarios = new Usuarios();
                    usuarios.setEmail(etEmail.getText().toString());
                    usuarios.setNome(etNome.getText().toString());
                    usuarios.setSenha(etSenha.getText().toString());
                    usuarios.setEmpresa(etEmpresa.getText().toString());
                    usuarios.setCargo(etCargo.getText().toString());

                    CadastraUsuario();



                }else {
                    Toast.makeText(CadastroActivity.this,"As senhas não estão iguais!",Toast.LENGTH_SHORT).show();

                }
                break;
        }


    }

    private  void CadastraUsuario() {
        mAuth.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String nome = etNome.getText().toString().trim();
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(nome).build();
                    user.updateProfile(profileChangeRequest);
                    Toast.makeText(CadastroActivity.this,"Cadastro concluído!",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(CadastroActivity.this,"Cadastro nao teve exito!",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
