package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioController;
import com.sourcecodeplataform.modelos.Usuario;

public class UptUsuActivity extends AppCompatActivity {
        Button uptUsu, delUsu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_usu);
            final UsuarioController ge = new UsuarioController(getBaseContext());
            final EditText name = (EditText)findViewById(R.id.name);
            final EditText email = (EditText)findViewById((R.id.email));
            final EditText password = (EditText)findViewById(R.id.password);
            final EditText type = (EditText)findViewById(R.id.type);
            Intent it = getIntent();
            final Usuario recuperado = (Usuario) it.getSerializableExtra("Usuario");
            name.setText(recuperado.getName());
            email.setText(recuperado.getEmail());
            password.setText(recuperado.getPassword());
            type.setText(recuperado.getType());

            uptUsu = (Button) findViewById(R.id.btalterar);
            uptUsu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    recuperado.setName(name.getText().toString());
                    recuperado.setEmail(email.getText().toString());
                    recuperado.setPassword(password.getText().toString());
                    recuperado.setType(type.getText().toString());
                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delUsu = (Button) findViewById(R.id.btexcluir);
            delUsu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
