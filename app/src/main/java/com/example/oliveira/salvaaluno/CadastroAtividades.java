
package com.example.oliveira.salvaaluno;


import android.app.SearchManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        );
        Calendar cMax = Calendar.getInstance();
        Calendar cMin = Calendar.getInstance();
        cMax.set(cMax.get(Calendar.YEAR),11,31);
        datePickerDialog.setMaxDate(cMax);
        datePickerDialog.setMaxDate(cMin);
        List<Calendar> daysList = new LinkedList<>();
        Calendar[] arrayDias;
        Calendar cAux = Calendar.getInstance();
        while(cAux.getTimeInMillis() <= cMax.getTimeInMillis()){
            if(cAux.get(Calendar.DAY_OF_WEEK)!= Calendar.SUNDAY && cAux.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY){
                    Calendar c = Calendar.getInstance();
                    c.setTimeInMillis(cAux.getTimeInMillis());
                    daysList.add(c);
            }
            cAux.setTimeInMillis(cAux.getTimeInMillis()+(24*60*60*1000));
        }
        arrayDias = new  Calendar[daysList.size()];
        for (int i = 0; i < arrayDias.length;i++){
            arrayDias[i] = daysList.get(i);
        }
        datePickerDialog.setSelectableDays(arrayDias);
        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(getFragmentManager(),"DatePickerDialog");
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
        Calendar tCalendar = Calendar.getInstance();
        tCalendar.set(ano, mes, dia);
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;

        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                this,
                tCalendar.get(Calendar.HOUR_OF_DAY),
                tCalendar.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.setOnCancelListener(this);
        timePickerDialog.show(getFragmentManager(),"timePickerDialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
            if(minute<9 || second >19){
                onDateSet(null,ano,mes,dia);
                Toast.makeText(this,"somente entre 9 e 19", Toast.LENGTH_SHORT).show();
                return;
            }
        horas = minute;
        minutos = second;

        texto_data.setText((dia<10 ? "0"+dia:dia)+"/"+
                           (mes+1<10?"0"+(mes+1):mes)+"/"+
                            ano);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        ano = mes = dia = minutos = horas = 0;
        texto_data.setText("");
    }
}
