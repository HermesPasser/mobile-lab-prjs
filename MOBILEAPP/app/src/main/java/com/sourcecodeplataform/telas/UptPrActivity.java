package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.ProjetoController;
import com.sourcecodeplataform.modelos.Projeto;

public class UptPrActivity extends AppCompatActivity {
        Button uptBtn, delBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_pr);
            final ProjetoController ge = new ProjetoController(getBaseContext());
            final EditText name = (EditText)findViewById(R.id.name);
            final EditText desc = (EditText)findViewById((R.id.desc));
            final EditText filepath = (EditText)findViewById(R.id.filepath);
            final EditText scm = (EditText)findViewById(R.id.scm);
            Intent it = getIntent();
            final Projeto recuperado = (Projeto) it.getSerializableExtra("Projeto");
            name.setText(recuperado.getName());
            desc.setText(recuperado.getDescription());
            filepath.setText(recuperado.getArchiveFilename());
            scm.setText(recuperado.getScmType());

            uptBtn = (Button) findViewById(R.id.btalterar);
            uptBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    recuperado.setName(name.getText().toString());
                    recuperado.setDescription(desc.getText().toString());
                    recuperado.setArchiveFilename(filepath.getText().toString());
                    recuperado.setScmType(scm.getText().toString());
                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delBtn = (Button) findViewById(R.id.btexcluir);
            delBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
