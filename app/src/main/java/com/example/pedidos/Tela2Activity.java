package com.example.pedidos;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pedidos.DataBase.DadosOpenHelper;

public class Tela2Activity extends AppCompatActivity {
    DadosOpenHelper mbd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView tfTexto = (TextView) findViewById(R.id.tvValort2);
        TextView tvTextoNome = (TextView)findViewById(R.id.textView6);
      //  EditText editText = (EditText)findViewById(R.id.editTex);
            Bundle extra = getIntent().getExtras();
        String prRecebido = extra.getString("parametro");
        String prRecebido1 = extra.getString("parametro1");
//
        tfTexto.setText(prRecebido);
         tvTextoNome.setText(prRecebido1);
    }





}
