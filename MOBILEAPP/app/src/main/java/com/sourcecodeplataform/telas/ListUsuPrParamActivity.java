package com.sourcecodeplataform.telas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.ListView;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioProjetoController;
import com.sourcecodeplataform.modelos.UsuarioProjeto;

import java.util.List;

public class ListUsuPrParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView listView;
    List<UsuarioProjeto> ups;
    Button pesqBtn;
    ArrayAdapter<UsuarioProjeto> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usupr_param);
        final Context con = getBaseContext();
        final UsuarioProjetoController ge = new UsuarioProjetoController(con);
        listView = (ListView) findViewById(R.id.listausupr);
        listView.setOnItemClickListener(this); // Clique no item
        listView.setOnItemLongClickListener(this);
        final ToggleButton owner = (ToggleButton) findViewById(R.id.isowner);

        pesqBtn = (Button) findViewById(R.id.btpesquisar);
        pesqBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UsuarioProjeto pr = new UsuarioProjeto(0);
                pr.setIsOwner(owner.isChecked());
                ups = ge.listarUsuarioProjetos(pr);
                adapter = new ArrayAdapter<UsuarioProjeto>(con, android.R.layout.simple_list_item_1, ups);
                listView.setAdapter(adapter);
            }
        });
    }

    private int click(AdapterView<?> parent, View view, int position, long id) {
        UsuarioProjeto pr = (UsuarioProjeto) parent.getItemAtPosition(position);
        Intent it = new Intent(ListUsuPrParamActivity.this, UptUsuPrActivity.class);
        it.putExtra("UsuarioProjeto", pr);
        startActivity(it);
        return pr.getId();
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