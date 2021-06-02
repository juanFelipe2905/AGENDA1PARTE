package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner categoria;
    final String[] datos = new String[]{"Actividad Física","Trabajo","Compras", "Recreativo","Otros"};
    ArrayAdapter<String> adaptador;

    EditText txtName, txtLast, txtPhone;
    Button btnGuardar;


    EditText etFecha, etHora;
    ImageButton ibObtenerFecha, ibObtenerHora;

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private static final String BARRA = "/";
    public final Calendar c = Calendar.getInstance();

    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        categoria = (Spinner) findViewById(R.id.sp_category);
        categoria.setAdapter(adaptador);
        etFecha =  (EditText) findViewById(R.id.et_mostrar_fecha_picker);
        etHora =  (EditText) findViewById(R.id.et_mostrar_hora_picker);

        ibObtenerFecha = (ImageButton) findViewById(R.id.ibObtenerFecha);
        ibObtenerHora = (ImageButton) findViewById(R.id.ibObtenerHora );
        ibObtenerFecha.setOnClickListener(this);
        ibObtenerHora.setOnClickListener(this);
        txtName = findViewById(R.id.txtName);
        txtLast = findViewById(R.id.txtLastName);
        txtPhone = findViewById(R.id.txtPhone);

    }
    @Override
    public void onClick(View view) {

        if(view == ibObtenerFecha){
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    etFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,anio);
            datePickerDialog.show();
        }

        if(view == ibObtenerHora){

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    etHora.setText(hourOfDay+":"+minute);
                }
            }
                    ,hora,minuto,false);
            timePickerDialog.show();
        }

    }
}
