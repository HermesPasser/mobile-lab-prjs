package com.sourcecodeplataform.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioController;
import com.sourcecodeplataform.modelos.Usuario;

public class ListUsuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        ListView listView;
        List<Usuario> usuarios;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_usu);
            final UsuarioController ge = new UsuarioController(getBaseContext());
            listView = (ListView) findViewById(R.id.listausu);
            usuarios = ge.listarUsuarios();
            ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1, usuarios);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
            listView.setOnItemLongClickListener(this);
        }

        private int click(AdapterView<?> parent, View view, int position, long id) {
            Usuario usu = (Usuario) parent.getItemAtPosition(position);
            Intent it = new Intent(ListUsuActivity.this, UptUsuActivity.class);
            it.putExtra("Usuario", usu);
            startActivity(it);
            return usu.getId();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            id = click(parent, view, position, id);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + id, Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            id = click(parent, view, position, id);
            Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + id, Toast.LENGTH_LONG).show();
        }
    }
