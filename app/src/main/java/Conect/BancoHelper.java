package Conect;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oliveira on 09/05/17.
 */

public class BancoHelper extends SQLiteOpenHelper {
    public static String BANCO_NOME = "escola.db";
    public static int BANCO_VERSAO = 1;

    public BancoHelper(Context context) {
        super(context, BANCO_NOME,null,BANCO_VERSAO);
    }

    public BancoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table atividades(id integer primary key autoincrement, tipo text, data text, conteudo text);";
        db.execSQL(sql);
        sql = "create table turmas(id integer primary key autoincrement, idTurma text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
