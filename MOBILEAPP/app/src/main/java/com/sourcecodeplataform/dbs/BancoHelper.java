package com.sourcecodeplataform.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "sourcecodeplataform.db";
    public static final String TABELA_U = "usuarios";
    public static final String TABELA_P = "projetos";
    public static final String TABELA_UP = "usuarios_projetos";

    private static final int VERSAO_SCHEMA = 2;
    private final String S_CREATE_U;
    private final String S_CREATE_P;
    private final String S_CREATE_UP;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        // change from 'BIGINT NOT NULL AUTO_INCREMENT... PRIMARY KEY()' to 'INTEGER AUTOINCREMENT...' cuz sqlite is shit
        this.S_CREATE_U = "create table usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255) NOT NULL, email VARCHAR(100) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, type VARCHAR(20) DEFAULT 'normal');";
        this.S_CREATE_P = "create table projetos (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, filepath VARCHAR(255) UNIQUE, scmType VARCHAR(20) DEFAULT 'git');";
        this.S_CREATE_UP = "create table usuarios_projetos (id INTEGER PRIMARY KEY AUTOINCREMENT, idUsuario BIGINT NOT NULL, idProjeto BIGINT NOT NULL, isOwner BOOL DEFAULT false, "
                + "foreign key (idUsuario) references usuarios(id), foreign key (idProjeto) references projetos(id));";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE_U);
        db.execSQL(S_CREATE_P);
        db.execSQL(S_CREATE_UP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_U);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_P);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_UP);
        onCreate(db);
    }
}
