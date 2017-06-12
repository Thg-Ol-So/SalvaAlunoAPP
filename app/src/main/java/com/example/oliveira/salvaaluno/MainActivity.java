package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        if(dados.getString("nome","").isEmpty()){
            Intent i = new Intent(MainActivity.this,VerificaTurma.class);
            startActivity(i);
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();

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
        Intent i = new Intent(MainActivity.this,Atividades.class);
        startActivity(i);

    }


}
