package com.example.profalexandre.fatecmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.modelos.Usuario;

public class MenuActivity extends AppCompatActivity {

    Button addUsu, listUsu, listUsuPar;
    TextView textUsuLogado;
    Usuario usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (Usuario) it.getSerializableExtra("UsuarioLogado");
        listUsu = (Button) findViewById(R.id.btlistusu);
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
        textUsuLogado.setText(usuLogado.getEmail());
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });
    }
}
