package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioController;
import com.sourcecodeplataform.modelos.Usuario;

import java.util.List;

public class ListUsuParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView alunosListView;
    List<Usuario> usuarios;
    Button pesqUsu;
    ArrayAdapter<Usuario> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usu_param);
        final Context con = getBaseContext();
        final UsuarioController ge = new UsuarioController(con);
        alunosListView = (ListView) findViewById(R.id.listausu);
        alunosListView.setOnItemClickListener(this); // Clique no item
        alunosListView.setOnItemLongClickListener(this); //
        final EditText email = (EditText)findViewById(R.id.email);

        pesqUsu = (Button) findViewById(R.id.btpesquisar);
        pesqUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String emailStr = email.getText().toString();
                Usuario usu = new Usuario(0);
                usu.setEmail(emailStr);
                usuarios = ge.listarUsuarios(usu);
                adapter = new ArrayAdapter<Usuario>(con,android.R.layout.simple_list_item_1, usuarios);
                alunosListView.setAdapter(adapter);
            }
        });
    }

    private int click(AdapterView<?> parent, View view, int position, long id) {
        Usuario usu = (Usuario) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuParamActivity.this, UptUsuActivity.class);
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