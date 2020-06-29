package com.example.profalexandre.fatecmobile.telas;

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

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.UsuarioController;
import com.example.profalexandre.fatecmobile.modelos.Usuario;

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

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // position é a posição do item no adapter
        Usuario usu = (Usuario) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuParamActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario", usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + usu.getId(), Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Usuario usu = (Usuario) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuParamActivity.this, UptUsuActivity.class);
        it.putExtra("Usuario", usu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + usu.getId(), Toast.LENGTH_LONG).show();
    }
}