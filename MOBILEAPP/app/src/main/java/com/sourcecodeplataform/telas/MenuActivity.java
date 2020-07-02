package com.sourcecodeplataform.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sourcecodeplataform.R;
import com.sourcecodeplataform.modelos.Usuario;

public class MenuActivity extends AppCompatActivity {
    Button addUsu, listUsu, listUsuPar, addPr, listPr, listPrPar, addUsuPr, listUsuPr, listUsuPrPar;
    TextView textUsuLogado;
    Usuario usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (Usuario) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
        textUsuLogado.setText("Usuário logado: " + usuLogado.getEmail());

        listUsu = (Button) findViewById(R.id.btlistusu);
        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        addUsu = (Button) findViewById(R.id.btnovousupr);

        listPr = (Button) findViewById(R.id.btlistpr);
        listPrPar = (Button) findViewById(R.id.btlistprParam);
        addPr = (Button) findViewById(R.id.btnovopr);

        listUsuPr = (Button) findViewById(R.id.btlistusupr);
        listUsuPrPar = (Button) findViewById(R.id.btlistusuprParam);
        addUsuPr = (Button) findViewById(R.id.btnovousupr);

        if (!usuLogado.getType().equals("ADM")) {
            addUsu.setVisibility(View.INVISIBLE);
            addPr.setVisibility(View.INVISIBLE);
            addUsuPr.setVisibility(View.INVISIBLE);
        }

        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });

        listPr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListPrActivity.class);
                startActivity(it);
            }
        });
        listPrPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListPrParamActivity.class);
                startActivity(it);
            }
        });
        addPr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddPrActivity.class);
                startActivity(it);
            }
        });

        listUsuPr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuPrActivity.class);
                startActivity(it);
            }
        });

        listUsuPrPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuPrParamActivity.class);
                startActivity(it);
            }
        });
        addUsuPr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuPrActivity.class);
                startActivity(it);
            }
        });
    }
}
