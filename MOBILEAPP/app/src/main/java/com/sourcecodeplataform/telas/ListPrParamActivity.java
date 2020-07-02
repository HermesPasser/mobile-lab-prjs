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
import com.sourcecodeplataform.dbs.ProjetoController;
import com.sourcecodeplataform.modelos.Projeto;

import java.util.List;

public class ListPrParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView projetosListView;
    List<Projeto> projetos;
    Button pesqPr;
    ArrayAdapter<Projeto> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pr_param);
        final Context con = getBaseContext();
        final ProjetoController ge = new ProjetoController(con);
        projetosListView = (ListView) findViewById(R.id.listapr);
        projetosListView.setOnItemClickListener(this); // Clique no item
        projetosListView.setOnItemLongClickListener(this);
        final EditText name = (EditText)findViewById(R.id.name);

        pesqPr = (Button) findViewById(R.id.btpesquisar);
        pesqPr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                Projeto pr = new Projeto(0);
                pr.setName(nameStr);
                projetos = ge.listarProjetos(pr);
                adapter = new ArrayAdapter<Projeto>(con, android.R.layout.simple_list_item_1, projetos);
                projetosListView
                .setAdapter(adapter);
            }
        });
    }

    private int click(AdapterView<?> parent, View view, int position, long id) {
        // position é a posição do item no adapter
        Projeto pr = (Projeto) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPrParamActivity.this, UptPrActivity.class);
        it.putExtra("Projeto", pr);
        startActivity(it);
        return pr.getId();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        click(parent, view, position, id);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + id, Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        click(parent, view, position, id);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + id, Toast.LENGTH_LONG).show();
    }
}