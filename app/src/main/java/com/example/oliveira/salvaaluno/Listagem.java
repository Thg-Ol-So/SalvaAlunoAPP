package com.example.oliveira.salvaaluno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class Listagem extends AppCompatActivity {
    List<AtividadeObj> atividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        AtividadeDAO pdao = new AtividadeDAO (this);
        pdao.open();
        atividades = pdao.getAll();

        pdao.close();
        ListAdapter adapter = new ListaAdapter(this,atividades);
        ListView lv = (ListView) findViewById(R.id.listagem);
        lv.setAdapter(adapter);
    }
}
