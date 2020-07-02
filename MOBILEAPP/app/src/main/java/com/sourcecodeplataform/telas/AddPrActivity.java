package com.sourcecodeplataform.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.dbs.ProjetoController;
import com.sourcecodeplataform.modelos.Projeto;

public class AddPrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pr);
        final ProjetoController ge = new ProjetoController(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name  = (EditText) findViewById(R.id.name);
                EditText desc = (EditText) findViewById((R.id.desc));
                EditText filename = (EditText) findViewById(R.id.filename);
                EditText scm = (EditText) findViewById(R.id.scm);

                Projeto pr = new Projeto(
                        0,
                        name.getText().toString(),
                        desc.getText().toString(),
                        filename.getText().toString(),
                        scm.getText().toString()
                 );

                String msg = ge.inserir(pr);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
