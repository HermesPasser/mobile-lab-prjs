package com.sourcecodeplataform.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sourcecodeplataform.modelos.Projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetoController {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ProjetoController(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(Projeto pr) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("NAME", pr.getName());
        valores.put("DESCRIPTION", pr.getDescription());
        valores.put("FILEPATH", pr.getArchiveFilename());
        valores.put("SCMTYPE", pr.getScmType());
        long resultado = db.insert(BancoHelper.TABELA_P, null, valores);
        db.close();
        return resultado == -1 ? "Erro ao inserir registro" : "Registro Inserido com sucesso";
    }

    public String excluir(Projeto pr) {
        String where = "ID = " + pr.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_P,where,null);
        db.close();
        return "Resgistro excluido com Sucesso";
    }

    public String alterar(Projeto pr) {
        db = dbHelper.getWritableDatabase();
        String where = "ID = " + pr.getId();
        ContentValues valores = new ContentValues();
        valores.put("NAME", pr.getName());
        valores.put("DESCRIPTION", pr.getDescription());
        valores.put("FILEPATH", pr.getArchiveFilename());
        valores.put("SCMTYPE", pr.getScmType());
        db.update(BancoHelper.TABELA_P, valores,where,null);
        db.close();
        return "Registro Alterado com sucesso";
    }

    public List<Projeto> listarProjetos() {
        List<Projeto> prs = new ArrayList<Projeto>();
        String selectQuery = "SELECT * FROM projetos" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                prs.add(new Projeto(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return prs;
    }

    public List<Projeto> listarProjetos(Projeto pr) {
        List<Projeto> prs = new ArrayList<Projeto>();
        String parametro = pr.getName();
        String selectQuery = "SELECT * FROM projetos WHERE name LIKE ?";
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);

        if (cursor.moveToFirst()) {
            do {
                prs.add(new Projeto(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return prs;
    }
}
