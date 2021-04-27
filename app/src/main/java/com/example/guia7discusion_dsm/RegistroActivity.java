package com.example.guia7discusion_dsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;


public class RegistroActivity extends AppCompatActivity {
    private EditText txtEmail, txtPassword;
    private Button btnRegistrar;
    private String email, password;

    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fAuth = FirebaseAuth.getInstance();

        txtEmail =(EditText) findViewById(R.id.txtEmailRegistro);
        txtPassword = (EditText) findViewById(R.id.txtPasswordRegistro);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()){
                    if (password.length() >= 6){

                        RegistrarUsuario();

                    }
                else{
                        Toast.makeText(RegistroActivity.this, "La contraseña debe tener almenos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegistroActivity.this, "Llene los campos vacios porfavor", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void RegistrarUsuario(){
        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegistroActivity.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(RegistroActivity.this, "Error al crear Usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}