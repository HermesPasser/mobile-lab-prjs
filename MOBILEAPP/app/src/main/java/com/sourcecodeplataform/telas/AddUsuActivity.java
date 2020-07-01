package com.sourcecodeplataform.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.UsuarioController;
import com.sourcecodeplataform.modelos.Usuario;

public class AddUsuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usu);
        final UsuarioController ge = new UsuarioController(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name  = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById((R.id.email));
                EditText passw = (EditText) findViewById(R.id.password);
                EditText type = (EditText) findViewById(R.id.type);

                Usuario usu = new Usuario(
                        0,
                        name.getText().toString(),
                        email.getText().toString(),
                        passw.getText().toString(),
                        type.getText().toString()
                 );

                String msg = ge.inserir(usu);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
