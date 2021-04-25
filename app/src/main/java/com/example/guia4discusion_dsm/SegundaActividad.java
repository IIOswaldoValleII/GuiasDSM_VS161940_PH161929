package com.example.guia4discusion_dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundaActividad extends AppCompatActivity {

    private TextView txtNombre, txtISSS, txtAFP, txtRenta, txtSalario, txtSalarioNeto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

    txtNombre = (TextView) findViewById(R.id.txtNombre2);
    txtSalario = (TextView) findViewById(R.id. txtSalario);
    txtISSS = (TextView) findViewById(R.id.txtISSS);
    txtAFP = (TextView) findViewById(R.id.txtAFP);
    txtRenta = (TextView) findViewById(R.id.txtRenta);
    txtSalarioNeto = (TextView) findViewById(R.id.txtNeto);

    Bundle bundle = getIntent().getExtras();

    String nombre = "Salario de: " + bundle.getString("txtNombre");
    String Salario = "Su salario original es de: " + bundle.getString("SalarioTotal");
    String ISSS = "Su descuento de ISSS (2%) es de: " + bundle.getString("ISSS");
    String AFP = "Su descuento de AFP (3%) es de: " + bundle.getString("AFP");
    String Renta = "Su descuento de Renta (4%) es de: " + bundle.getString("Renta");
    String SalarioNeto = "Su salario neto fijo con descuentos incluidos es de: " + bundle.getString("SalarioNeto");

    txtNombre.setText(nombre);
    txtSalario.setText(Salario);
    txtAFP.setText(AFP);
    txtISSS.setText(ISSS);
    txtRenta.setText(Renta);
    txtSalarioNeto.setText(SalarioNeto);


    }
}