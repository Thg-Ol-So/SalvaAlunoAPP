package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import DAO.Professor_DAO;
import DAO.TurmaDAO;
import Modelo.*;
import Modelo.Professor;

public class VerificaTurma extends AppCompatActivity {
    EditText turma;
    FloatingActionButton atualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica_turma);
        turma = (EditText) findViewById(R.id.idTurma);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        String id_turma = dados.getString("nome","");
    }

    public void visualizar(View v){
        String codigo = turma.getEditableText().toString();
        //Professor_DAO pdao = new Professor_DAO(this);
        //pdao.open();
        //pdao.criar(new Professor("Gustavo","gustavo@ifms.com","999027276"));
        //pdao.criar(new Professor("Tony","tony@ifms.com","999991411"));
        //pdao.criar(new Professor("Gilson","gilson@ifms.com","999473362"));
        TurmaDAO dao = new TurmaDAO(this);
        dao.open();
        //dao.criar(new Turmas("3212"));
        //dao.close();
        try{
            if(dao.getByIdTurma(codigo).getId()>0){
                SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
                dados.edit().putString("nome", codigo).apply();
                Intent i = new Intent(VerificaTurma.this,MainActivity.class);
                startActivity(i);
            }
        }catch (Exception e){
            Toast.makeText(this,"Codigo Invalido", Toast.LENGTH_LONG).show();
        }finally {
            dao.close();
        }
        onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividades, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.acao_sair) {
            Intent  it = new Intent(getApplicationContext(), MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            it.putExtra("SAIR", true);
            startActivity(it);
            toast("Aplicativo Encerrado");
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
