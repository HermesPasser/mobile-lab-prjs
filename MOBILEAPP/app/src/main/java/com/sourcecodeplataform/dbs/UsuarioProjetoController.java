package com.sourcecodeplataform.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sourcecodeplataform.modelos.UsuarioProjeto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioProjetoController {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;
    private Context ctx;

    public UsuarioProjetoController(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
        ctx = context;
    }

    public String inserir(UsuarioProjeto pr) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("IDUSUARIO", pr.getUsuarioId());
        valores.put("IDPROJETO", pr.getProjetoId());
        valores.put("ISOWNER", pr.itIsOwner());
        long resultado = db.insert(BancoHelper.TABELA_UP, null, valores);
        db.close();
        return resultado == -1 ? "Erro ao inserir registro" : "Registro Inserido com sucesso";
    }

    public String excluir(UsuarioProjeto pr) {
        String where = "ID = " + pr.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_UP,where,null);
        db.close();
        return "Resgistro excluido com Sucesso";
    }

    public String alterar(UsuarioProjeto pr) {
        db = dbHelper.getWritableDatabase();
        String where = "ID = " + pr.getId();
        ContentValues valores = new ContentValues();
        valores.put("IDUSUARIO", pr.getUsuarioId());
        valores.put("IDPROJETO", pr.getProjetoId());
        valores.put("ISOWNER", pr.itIsOwner());
        db.update(BancoHelper.TABELA_UP, valores, where,null);
        db.close();
        return "Registro Alterado com sucesso";
    }

    public List<UsuarioProjeto> listarUsuarioProjetos() {
        List<UsuarioProjeto> prs = new ArrayList<UsuarioProjeto>();
        String selectQuery = "SELECT * FROM usuarios_projetos" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                prs.add(new UsuarioProjeto(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getInt(3) > 0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return prs;
    }

    public List<UsuarioProjeto> listarUsuarioProjetos(UsuarioProjeto pr) {
        List<UsuarioProjeto> prs = new ArrayList<UsuarioProjeto>();
        String selectQuery = "SELECT * FROM usuarios_projetos WHERE isOwner = ?";
        String[] whereArgs = new String[] {  pr.itIsOwner() ? "1" : "0"};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);

        if (cursor.moveToFirst()) {
            do {
                prs.add(new UsuarioProjeto(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getInt(3) > 0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return prs;
    }
}
