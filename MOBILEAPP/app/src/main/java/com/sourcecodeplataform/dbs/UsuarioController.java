package com.sourcecodeplataform.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sourcecodeplataform.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public UsuarioController(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(Usuario usu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("NAME", usu.getName());
        valores.put("EMAIL", usu.getEmail());
        valores.put("PASSWORD", usu.getPassword());
        valores.put("TYPE", usu.getType());
        long resultado = db.insert(BancoHelper.TABELA_U, null, valores);
        db.close();
        return resultado == -1 ? "Erro ao inserir registro" : "Registro Inserido com sucesso";
    }

    public String excluir(Usuario usu) {
        String where = "ID = " + usu.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_U,where,null);
        db.close();
        return "Resgistro Excluir com Sucesso";
    }

    public String alterar(Usuario usu) {
        db = dbHelper.getWritableDatabase();
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + usu.getId();
        ContentValues valores = new ContentValues();
        valores.put("NAME", usu.getName());
        valores.put("EMAIL", usu.getEmail());
        valores.put("PASSWORD", usu.getPassword());
        valores.put("TYPE", usu.getType());
        db.update(BancoHelper.TABELA_U, valores,where,null);
        db.close();
        return retorno;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String selectQuery = "SELECT * FROM usuarios" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Usuario usu = new Usuario(cursor.getInt(0));
                usu.setName(cursor.getString(1));
                usu.setEmail(cursor.getString(2));
                usu.setPassword(cursor.getString(3));
                usu.setType(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return usuarios;
    }

    public List<Usuario> listarUsuarios(Usuario usuEnt) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String parametro = usuEnt.getEmail();
        String selectQuery = "SELECT * FROM usuarios WHERE email LIKE ?";
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);

        if (cursor.moveToFirst()) {
            do {
                Usuario usu = new Usuario(cursor.getInt(0));
                usu.setName(cursor.getString(1));
                usu.setEmail(cursor.getString(2));
                usu.setPassword(cursor.getString(3));
                usu.setType(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return usuarios;
    }

    /**
     *
     * @param usuEnt where the data we will look at is
     * @return an evaluated Usuario or null if not found
     */
    public Usuario validarUsuarios(Usuario usuEnt) {
        Usuario usu = new Usuario(0);
        String selectQuery = "SELECT * FROM usuarios WHERE email = ? AND password = ? ";
        db = dbHelper.getWritableDatabase();
        String params[] = new String[]{ usuEnt.getEmail().trim(), usuEnt.getPassword().trim()};
        Cursor cursor = db.rawQuery(selectQuery, params);

        if (cursor.moveToFirst()) {
            do {
                usu.setId(cursor.getInt(0));
                usu.setName(cursor.getString(1));
                usu.setEmail(cursor.getString(2));
                usu.setPassword(cursor.getString(3));
                usu.setType(cursor.getString(4));
            } while (cursor.moveToNext());
            cursor.close();
        } else {
            cursor.close();
            return null;
        }
        return usu;
    }
}
