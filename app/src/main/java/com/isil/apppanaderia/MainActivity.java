    package com.isil.apppanaderia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

    public class MainActivity extends AppCompatActivity {
    //declaracion
    RadioGroup radio_Group;
    EditText cantidad;
    TextView txtresultado;
    DecimalFormat df=new DecimalFormat("0.00");
    double cant;
    String mensaje = "";
    double total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //extraccion de datos por medio de id
        cantidad=findViewById(R.id.n);
        radio_Group=findViewById(R.id.radioGroup);
        txtresultado=findViewById(R.id.resultado);
    }

    public void calcular(View view) {


            switch (radio_Group.getCheckedRadioButtonId()) {
                case R.id.rbA:
                    total = 4.50 * cant;
                    break;
                case R.id.rbB:
                    total = 5.00 * cant;
                    break;
                case R.id.rbC:
                    total = 7.50 * cant;
                    break;
                case R.id.rbD:
                    total = 13.50 * cant;
                    break;
                default:
                    mensaje = "- Elija una de las opciones";
            }
        if (!cantidad.getText().toString().isEmpty()) {
            cant = Integer.parseInt(cantidad.getText().toString());
        }else{
               mensaje = mensaje + "\n" + "-Debe asignar una cantidad";

            }

            if (mensaje.isEmpty()) {
                txtresultado.setText("Precio Total: S/." + df.format(total));
            } else {
                txtresultado.setText(mensaje);
                borrar();
            }

        }
        void borrar(){
            mensaje="";
        }
        public void eliminar(View view){
            cantidad.setText("");
            txtresultado.setText("");
        }

    }








