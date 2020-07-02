package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioProjetoController;
import com.sourcecodeplataform.modelos.UsuarioProjeto;

import java.util.List;

public class ListUsuPrActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        ListView upsListView;
        List<UsuarioProjeto> ups;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_usupr);
            final UsuarioProjetoController ge = new UsuarioProjetoController(getBaseContext());
            upsListView = (ListView) findViewById(R.id.listausupr);
            ups = ge.listarUsuarioProjetos();
            ArrayAdapter<UsuarioProjeto> adapter = new ArrayAdapter<UsuarioProjeto>(this, android.R.layout.simple_list_item_1, ups);
            upsListView.setAdapter(adapter);
            upsListView.setOnItemClickListener(this);
            upsListView.setOnItemLongClickListener(this);
        }

        private int click(AdapterView<?> parent, View view, int position, long id) {
            UsuarioProjeto pr = (UsuarioProjeto) parent.getItemAtPosition(position);
            Intent it = new Intent(ListUsuPrActivity.this, UptUsuPrActivity.class);
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
