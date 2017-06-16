package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Modelo.Professor;
import Tab_Professores.ListaAdapter_Prof;

public class Listagem_Prof extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    static public ArrayList<Professor> professores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        //Professor_DAO pdao = new Professor_DAO (this);
        //pdao.open();


        //pdao.close();
        ListaAdapter_Prof adapter = new ListaAdapter_Prof(this, professores);
        ListView lv = (ListView) findViewById(R.id.listagem);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this); // Clique no item
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(Listagem_Prof.this, Tab_Prof.class);
        i.putExtra("nome",professores.get(position).getNome() );
        i.putExtra("telefone",professores.get(position).getTelefone());
        i.putExtra("email",professores.get(position).getEmail());
        startActivity(i);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
