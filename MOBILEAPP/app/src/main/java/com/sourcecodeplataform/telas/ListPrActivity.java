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
import com.sourcecodeplataform.dbs.ProjetoController;
import com.sourcecodeplataform.modelos.Projeto;

public class ListPrActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        ListView listView;
        List<Projeto> projetos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_pr);
            final ProjetoController ge = new ProjetoController(getBaseContext());
            listView = (ListView) findViewById(R.id.listapr);
            projetos = ge.listarProjetos();
            ArrayAdapter<Projeto> adapter = new ArrayAdapter<Projeto>(this,android.R.layout.simple_list_item_1, projetos);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
            listView.setOnItemLongClickListener(this);
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // position é a posição do item no adapter
            Projeto pr = (Projeto) parent.getItemAtPosition(position);
            Intent it = new Intent(ListPrActivity.this, UptPrActivity.class);
            it.putExtra("Projeto", pr);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + pr.getId(), Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Projeto pr = (Projeto) parent.getItemAtPosition(position);
            Intent it = new Intent(ListPrActivity.this, UptPrActivity.class);
            it.putExtra("Projeto", pr);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + pr.getId(), Toast.LENGTH_LONG).show();
        }
    }
