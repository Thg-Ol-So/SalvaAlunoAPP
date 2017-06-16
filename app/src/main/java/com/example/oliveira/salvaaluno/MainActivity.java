package com.example.oliveira.salvaaluno;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import Modelo.Professor;

import static Conect.ConectWS.pegaHTTP;

public class MainActivity extends AppCompatActivity {
    ArrayList<Professor> lista;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        if(dados.getString("nome","").isEmpty()){
            Intent i = new Intent(MainActivity.this,VerificaTurma.class);
            this.finish();
            startActivity(i);

            return;
        }
        try{
            atualizar();
        }catch (Exception e ){
            Toast.makeText(this,"Conexao Falhou",Toast.LENGTH_SHORT).show();
        }
        if(getIntent().getBooleanExtra("SAIR", false)){
            this.finish();
            System.exit(0);
            return ;
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            this.finish();
            System.exit(0);
        }
        super.onResume();
    }
    public void View_disciplinas(View view){
        Toast.makeText(this, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
    }
    public void View_horarios(View view){
        Toast.makeText(this, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
    }
    public void View_eventos(View view){
        Toast.makeText(this, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
    }
    public void View_lembretes(View view){
        Toast.makeText(this, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            //finish();

            SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
            dados.edit().putString("nome", "").apply();
            Intent i = new Intent(MainActivity.this,VerificaTurma.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void View_sair(View v){
        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        dados.edit().putString("nome", "").apply();
        Intent i = new Intent(MainActivity.this,VerificaTurma.class);
        startActivity(i);

    }
    public void View_atividades(View v){
        Intent i = new Intent(MainActivity.this, Atividades.class);
        startActivity(i);

    }
    public void View_professor(View v){
        Intent i = new Intent(MainActivity.this, Listagem_Prof.class);
        Listagem_Prof.professores = lista;
        startActivity(i);

    }
    public void retornoProfessores() {
        lista = new ArrayList<>();
        final Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = pegaHTTP("https://web322.herokuapp.com/cliente");
                    JSONArray js = new JSONArray(json);
                    if(js.length()>0) {
                        for (int i = 0; i < js.length(); i++) {
                            lista.add(new Professor(js.getJSONObject(i).getString("nome"), js.getJSONObject(i).getString("email"),
                                    js.getJSONObject(i).getString("telefone")));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }finally {
                    progress.dismiss();
                }
            }
        });
        thr.start();
    }
    public void atualizar(){
        progress = new ProgressDialog(this);
        progress.setTitle("carregando...");
        progress.show();
        retornoProfessores();
    }

}
