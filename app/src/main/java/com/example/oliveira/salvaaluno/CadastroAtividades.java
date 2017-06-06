
package com.example.oliveira.salvaaluno;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.os.Bundle;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class CadastroAtividades extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,DialogInterface.OnCancelListener{
    private TextView texto_data;
    private Button botao_data;
    private String valor_data = "";
    private EditText data_conteudo;
    private int ano, mes, dia, horas,minutos;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividades);
        texto_data      = (TextView) findViewById(R.id.text_data);
        botao_data      = (Button)   findViewById(R.id.botao_data);
        data_conteudo   = (EditText) findViewById(R.id.conteudo);
        addItemsOnSpinner();
        botao_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informaData(v);
            }
        });
    }
    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.tipoAtividade);
        List<String> list = new ArrayList<String>();
        list.add("PROVA");
        list.add("TRABALHO");
        list.add("ATIVIDADE");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void salvar(View v){
        AtividadeDAO dao    = new AtividadeDAO(this);
        String data         = valor_data;
        String conteudo     = data_conteudo.getEditableText()+"";
        String tipo         = String.valueOf(spinner.getSelectedItem());
        // AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        // alerta.setMessage(data);
        // alerta.show();

        if(!conteudo.equals("") && !data.equals("")){
            dao.open();
            dao.criar(new AtividadeObj(tipo,data,conteudo));
            dao.close();
            Intent i = new Intent(CadastroAtividades.this,Atividades.class);
            startActivity(i);
        }

    }

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
        valor_data = date;
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
