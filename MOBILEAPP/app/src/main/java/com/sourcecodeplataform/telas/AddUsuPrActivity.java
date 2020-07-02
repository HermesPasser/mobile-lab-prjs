package com.sourcecodeplataform.telas;

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

public class AddUsuPrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usupr);
        final UsuarioProjetoController ge = new UsuarioProjetoController(getBaseContext());
        Button inserir = (Button) findViewById(R.id.btinserir);
        final ToggleButton owner = (ToggleButton) findViewById(R.id.isowner);

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idu = (EditText) findViewById(R.id.idusuario);
                EditText idp = (EditText) findViewById((R.id.idprojeto));

                UsuarioProjeto pr = new UsuarioProjeto(
                        0,
                        Integer.parseInt(idu.getText().toString()),
                        Integer.parseInt(idp.getText().toString()),
                        owner.isChecked());

                String msg = ge.inserir(pr);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
