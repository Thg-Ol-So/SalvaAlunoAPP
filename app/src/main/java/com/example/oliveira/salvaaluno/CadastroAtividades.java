
package com.example.oliveira.salvaaluno;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.os.Bundle;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class CadastroAtividades extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,DialogInterface.OnCancelListener{
    private TextView texto_data;
    private Button botao_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividades);
        texto_data = (TextView) findViewById(R.id.text_data);
        botao_data = (Button)   findViewById(R.id.botao_data);
        botao_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informaData(v);
            }
        });
    }
    private int ano, mes, dia, horas,minutos;

    public void informaData(View v){
        iniciarData();
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }
    public void iniciarData(){
        if(ano==0){
            Calendar c = Calendar.getInstance();
            ano = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);
            horas = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        texto_data.setText(date);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String time = "You picked the following time: "+hourOfDay+"h"+minute+"m"+second;
        //t.setText(time);

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        ano = mes = dia = minutos = horas = 0;
        texto_data.setText("");
    }
}
