package com.example.profalexandre.fatecmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.profalexandre.fatecmobile.dbs.UsuarioController;
import com.example.profalexandre.fatecmobile.modelos.Usuario;
import com.example.profalexandre.fatecmobile.R;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button addUsu, entrar;
    String emailStr;
    String passwStr;
    Usuario usuEnt;
    Usuario usuSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final UsuarioController ge = new UsuarioController(getBaseContext());

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        emailStr = email.getText().toString();
        passwStr = password.getText().toString();

        usuEnt = new Usuario(0);
        usuEnt.setEmail(emailStr);
        usuEnt.setPassword(passwStr);

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
                usuSai = ge.validarUsuarios(usuEnt);
                Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                it.putExtra("UsuarioLogado", usuSai);
                startActivity(it);
            }
        });
    }
}
