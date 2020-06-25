package com.example.profalexandre.fatecmobile.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author ProfAlexandre
 */
public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "RESGATFATEC.db";
    public static final String TABELA_U = "USUARIOS";
    public static final String TABELA_P = "PESSOAS";
    public static final String TABELA_UP = "USU_PES";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE_U;
    private final String S_CREATE_P;
    private final String S_CREATE_UP;

    // APLICAR CHAVE ESTRANGEIRA

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE_U = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATE_P = "CREATE TABLE PESSOAS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,CPF TEXT);";
        this.S_CREATE_UP = "CREATE TABLE USU_PES (ID INTEGER PRIMARY KEY AUTOINCREMENT,ID_U TEXT,ID_P TEXT, OBS TEXT );";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE_U);
        db.execSQL(S_CREATE_P);
        db.execSQL(S_CREATE_UP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_U);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_P);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_UP);

        onCreate(db);
    }

}
