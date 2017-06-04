package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VerificaTurma extends AppCompatActivity {
    EditText turma;
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
        SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        dados.edit().putString("nome", codigo).apply();
        Intent i = new Intent(VerificaTurma.this,MainActivity.class);
        startActivity(i);
        onResume();

    }
}
