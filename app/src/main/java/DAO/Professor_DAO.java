package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Conect.BancoHelper;
import Modelo.Professor;
import Modelo.Turmas;

/**
 * Created by oliveira on 14/06/17.
 */

public class Professor_DAO {
    public SQLiteDatabase banco;
    public BancoHelper bancoHelper;
    public String[] colunas = {"id","nome","email","telefone"};

    public Professor_DAO(Context c){
        bancoHelper = new BancoHelper(c);

    }
    public void open() {
        banco = bancoHelper.getWritableDatabase();
    }

    public void close() {
        bancoHelper.close();
    }
    public void criar(Professor professor) {
        ContentValues valores = new ContentValues();
        valores.put("nome", professor.getNome());
        valores.put("email", professor.getEmail());
        valores.put("telefone", professor.getTelefone());
        banco.insert("professores", null, valores);

    }
    public void delete (Professor p){
        banco.delete("professores","id="+p.getId(),null);
    }

    public void atualizar(Professor professor) {
        ContentValues valores = new ContentValues();
        valores.put("nome", professor.getNome());
        valores.put("email", professor.getEmail());
        valores.put("telefone", professor.getTelefone());
        banco.update("professores", valores, "id=" + professor.getId(), null);

    }

    public List<Professor> getAll() {
        List<Professor> lista = new ArrayList<>();
        Cursor cursor = banco.query("professores", colunas, null, null, null, null,"id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Professor p = new Professor(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            lista.add(p);
            cursor.moveToNext();
        }
        return lista;
    }
    public Turmas getById(int id)
    {
        Cursor cursor = banco.query("professores", colunas, "id="+id, null, null, null,"id desc", null);
        cursor.moveToFirst();
        Turmas p = null;
        if(!cursor.isAfterLast()){
            p = new Turmas(cursor.getString(1));
            p.setId(cursor.getInt(0));
        }
        return p;
    }

}
