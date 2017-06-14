package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import Tab_Atividades.Atividades;
import Tab_Professores.Listagem_Prof;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        if(getIntent().getBooleanExtra("SAIR", false)){
            this.finish();
            System.exit(0);
            return ;
        }
        if(dados.getString("nome","").isEmpty()){
            Intent i = new Intent(MainActivity.this,VerificaTurma.class);
            startActivity(i);
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
        startActivity(i);

    }


}
