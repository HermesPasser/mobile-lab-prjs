package com.sourcecodeplataform.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.sourcecodeplataform.dbs.UsuarioController;
import com.sourcecodeplataform.modelos.Usuario;
import com.sourcecodeplataform.R;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button addUsu, entrar;
    Usuario usuEnt;
    Usuario usuSai;

    private void feedUsuEnt() {
        String e = email.getText().toString();
        String p = password.getText().toString();

        usuEnt = new Usuario(0, null, e, p, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final UsuarioController ge = new UsuarioController(getBaseContext());

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });

        entrar = (Button) findViewById(R.id.btentrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                feedUsuEnt();
                usuSai = ge.validarUsuarios(usuEnt);

                if (usuSai == null) {
                    Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                    usuSai = new Usuario(0);
                    return;
                }

                Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                it.putExtra("UsuarioLogado", usuSai);
                startActivity(it);
            }
        });
    }
}
