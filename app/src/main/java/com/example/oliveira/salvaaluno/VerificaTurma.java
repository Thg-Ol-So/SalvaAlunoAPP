package com.example.oliveira.salvaaluno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            finish();
            toast("Aplicativo Encerrado");
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
