package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Conect.BancoHelper;
import Modelo.Turmas;

/**
 * Created by oliveira on 11/06/17.
 */

public class TurmaDAO {
    public SQLiteDatabase banco;
    public BancoHelper bancoHelper;
    public String[] colunas = {"id", "idTurma"};

    public TurmaDAO(Context c){
        bancoHelper = new BancoHelper(c);

    }
    public void open() {
        banco = bancoHelper.getWritableDatabase();
    }

    public void close() {
        bancoHelper.close();
    }
    public void criar(Turmas turmas) {
        ContentValues valores = new ContentValues();
        valores.put("idTurma", turmas.getIdTurma());
        banco.insert("turmas", null, valores);

    }
    public void delete (Turmas p){
        banco.delete("turmas","id="+p.getId(),null);
    }

    public void atualizar(Turmas turmas) {
        ContentValues valores = new ContentValues();
        valores.put("idTurma", turmas.getIdTurma());
        banco.update("turmas", valores, "id=" + turmas.getId(), null);

    }

    public List<Turmas> getAll() {
        List<Turmas> lista = new ArrayList<>();
        Cursor cursor = banco.query("turmas", colunas, null, null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Turmas p = new Turmas(cursor.getString(1));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
    public Turmas getByIdTurma(String turma)
    {
        Cursor cursor = banco.query("turmas", colunas, "idTurma='"+turma+"'", null, null, null,"id desc", null);
        cursor.moveToFirst();
        Turmas p = null;
        if(!cursor.isAfterLast()){
            p = new Turmas(cursor.getString(1));
            p.setId(cursor.getInt(0));
        }
        return p;
    }

 }
