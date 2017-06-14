package com.example.oliveira.salvaaluno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Modelo.AtividadeObj;

/**
 * Created by oliveira on 04/04/17.
 */

public class ListaAdapter extends BaseAdapter{
    private Context ctx;
    private List<AtividadeObj> atividades;


    public ListaAdapter(Context ctx, List<AtividadeObj> atividades){
        this.ctx = ctx;
        this.atividades = atividades;
    }

    @Override
    public int getCount() {
        return atividades.size();
    }

    @Override
    public Object getItem(int position) {
        return atividades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View visao = LayoutInflater.from(ctx).inflate(R.layout.linha_lista,parent,false);

        AtividadeObj p = atividades.get(position);
        TextView tvnome = (TextView) visao.findViewById(R.id.tvnome);
        tvnome.setText(p.getData());

        TextView tvmotivo = (TextView) visao.findViewById(R.id.tvcmotivo);
        tvmotivo.setText(p.getTipo());

        return visao;
    }
}
