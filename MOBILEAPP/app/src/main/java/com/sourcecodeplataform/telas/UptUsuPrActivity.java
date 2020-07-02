package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioProjetoController;
import com.sourcecodeplataform.modelos.UsuarioProjeto;

public class UptUsuPrActivity extends AppCompatActivity {
        Button uptBtn, delBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_usupr);
            final UsuarioProjetoController ge = new UsuarioProjetoController(getBaseContext());
            final EditText idu = (EditText)findViewById(R.id.idusuario);
            final EditText idp = (EditText)findViewById((R.id.idprojeto));
            final ToggleButton owner = (ToggleButton)findViewById(R.id.isowner);
            Intent it = getIntent();
            final UsuarioProjeto recuperado = (UsuarioProjeto) it.getSerializableExtra("UsuarioProjeto");

            // dunno why but this shit only works if i parse to str even tho i don't make this way on the other upts
            idu.setText(recuperado.getUsuarioId() + "");
            idp.setText(recuperado.getProjetoId() + "");
            owner.setChecked(recuperado.itIsOwner());

            uptBtn = (Button) findViewById(R.id.btalterar);
            uptBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    recuperado.setUsuarioId(Integer.parseInt("0" + idu.getText().toString()));
                    recuperado.setProjetoId(Integer.parseInt("0" + idp.getText().toString()));
                    recuperado.setIsOwner(owner.isChecked());
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
