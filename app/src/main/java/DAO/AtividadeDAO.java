package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import Modelo.AtividadeObj;

import java.util.ArrayList;
import java.util.List;

import Conect.BancoHelper;

/**
 * Created by oliveira on 04/06/17.
 */

public class AtividadeDAO {
    public SQLiteDatabase banco;
    public BancoHelper bancoHelper;
    public String[] colunas = {"id", "tipo", "data", "conteudo"};

    public  AtividadeDAO(Context c){
        bancoHelper = new BancoHelper(c);

    }
    public void open() {
        banco = bancoHelper.getWritableDatabase();
    }

    public void close() {
        bancoHelper.close();
    }
    public void criar(AtividadeObj atividade) {
        ContentValues valores = new ContentValues();
        valores.put("tipo", atividade.getTipo());
        valores.put("data", atividade.getData());
        valores.put("conteudo", atividade.getConteudo());
        banco.insert("atividades", null, valores);

    }
    public void delete (AtividadeObj p){
        banco.delete("atividades","id="+p.getId(),null);
    }

    public void atualizar(AtividadeObj atividade) {
        ContentValues valores = new ContentValues();
        valores.put("tipo", atividade.getTipo());
        valores.put("data", atividade.getData());
        valores.put("conteudo", atividade.getConteudo());
        banco.update("atividades", valores, "id=" + atividade.getId(), null);

    }

    public List<AtividadeObj> getAll() {
        List<AtividadeObj> lista = new ArrayList<>();
        Cursor cursor = banco.query("atividades", colunas, null, null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AtividadeObj p = new AtividadeObj(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
    public List<AtividadeObj> getAtividades() {
        List<AtividadeObj> lista = new ArrayList<>();
        Cursor cursor = banco.query("atividades", colunas, "tipo='ATIVIDADE'", null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AtividadeObj p = new AtividadeObj(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
    public List<AtividadeObj> getProvas() {
        List<AtividadeObj> lista = new ArrayList<>();
        Cursor cursor = banco.query("atividades", colunas, "tipo='PROVA'", null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AtividadeObj p = new AtividadeObj(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
    public List<AtividadeObj> getTrabalhos() {
        List<AtividadeObj> lista = new ArrayList<>();
        Cursor cursor = banco.query("atividades", colunas, "tipo='TRABALHO'", null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AtividadeObj p = new AtividadeObj(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
}

