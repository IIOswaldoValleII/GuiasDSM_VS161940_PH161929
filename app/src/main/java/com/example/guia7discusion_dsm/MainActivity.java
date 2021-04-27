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

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button Login, Registro, FB, Google;

    private String email = "";
    private String password = "";

    private FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Registro = (Button) findViewById(R.id.btnRegistro);
        FB = (Button) findViewById(R.id.btnFB);
        Google = (Button) findViewById(R.id.btnGoogle);



        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    InicioLogin();
                }else{
                    Toast.makeText(MainActivity.this, "Porfavor, complete los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void  InicioLogin(){
        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent( MainActivity.this, PrincipalActivity.class);
                    startActivity(intent);

                }
                else   {
                    Toast.makeText(MainActivity.this, "Error de inicio de sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}