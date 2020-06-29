package com.example.profalexandre.fatecmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.UsuarioController;
import com.example.profalexandre.fatecmobile.modelos.Usuario;

public class ListUsuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        ListView alunosListView;
        List<Usuario> usuarios;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_usu);
            final UsuarioController ge = new UsuarioController(getBaseContext());
            alunosListView = (ListView) findViewById(R.id.listausu);
            usuarios = ge.listarUsuarios();
            ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1, usuarios);
            alunosListView.setAdapter(adapter);
            alunosListView.setOnItemClickListener(this);
            alunosListView.setOnItemLongClickListener(this);
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // position é a posição do item no adapter
            Usuario usu = (Usuario) parent.getItemAtPosition(position);
            Intent it = new Intent(ListUsuActivity.this, UptUsuActivity.class);
            it.putExtra("Usuario", usu);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + usu.getId(), Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Usuario usu = (Usuario) parent.getItemAtPosition(position);
            Intent it = new Intent(ListUsuActivity.this, UptUsuActivity.class);
            it.putExtra("Usuario", usu);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + usu.getId(), Toast.LENGTH_LONG).show();
        }
    }
