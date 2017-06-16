package com.example.oliveira.salvaaluno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Informacao extends AppCompatActivity {
    String tipo;
    String data;
    String conteudos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

        TextView nome_prof = (TextView) findViewById(R.id.nome_professor);
        TextView tele = (TextView) findViewById(R.id.num_telefone);
        TextView email = (TextView) findViewById(R.id.email);
        TextView cont = (TextView) findViewById(R.id.cont_id);
        TextView tel = (TextView) findViewById(R.id.tel_id);

        Bundle conteudo = getIntent().getExtras();
        data = conteudo.getString("data");
        conteudos = conteudo.getString("conteudo");
        tipo = conteudo.getString("tipo");

        nome_prof.setText(tipo);
        tele.setText(data);
        email.setText(conteudos);
        tel.setText("Data");
        cont.setText("Conteudo");

    }
}
