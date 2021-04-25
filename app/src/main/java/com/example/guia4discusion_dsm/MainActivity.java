package com.example.guia4discusion_dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText txtNombre;
private EditText txtHoras;
private Button btnCalcular;

private String nombre;
private int horas;
private double SalarioTotal, ISSS, AFP, Renta, SalarioNeto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtHoras = (EditText) findViewById(R.id.txtHoras);
        btnCalcular = (Button) findViewById(R.id.btnCacular);




    btnCalcular.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nombre = txtNombre.getText().toString();
            horas = Integer.parseInt(txtHoras.getText().toString());
            SalarioTotal = 8.50 * horas;
            ISSS = SalarioTotal * 0.02;
            AFP = SalarioTotal * 0.03;
            Renta = SalarioTotal * 0.04;
            SalarioNeto = SalarioTotal - (ISSS + AFP + Renta);

            Intent i = new Intent(MainActivity.this, SegundaActividad.class);

            i.putExtra("txtNombre", txtNombre.getText().toString());
            i.putExtra("SalarioTotal", String.valueOf(SalarioTotal));
            i.putExtra("ISSS", String.valueOf(ISSS));
            i.putExtra("AFP", String.valueOf(AFP));
            i.putExtra("Renta", String.valueOf(Renta));
            i.putExtra("SalarioNeto", String.valueOf(SalarioNeto));
            startActivity(i);



        }
    });
    }
private void calcularSalario(){

}
}