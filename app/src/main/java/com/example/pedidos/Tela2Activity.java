package com.example.pedidos;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pedidos.DataBase.DadosOpenHelper;

public class Tela2Activity extends AppCompatActivity {
    DadosOpenHelper mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        mdb = new DadosOpenHelper(this, "lista", null, 1);



        TextView tfTexto = (TextView) findViewById(R.id.tvValort2);
        TextView tvTextoNome = (TextView)findViewById(R.id.textView6);

        Bundle extra = getIntent().getExtras();
        String prRecebido = extra.getString("parametro");
        String prRecebido1 = extra.getString("parametro1");
        tfTexto.setText(prRecebido);
        tvTextoNome.setText(prRecebido1);
        exibirPedido();

    }


    public void exibirPedido(){
        ((EditText)findViewById(R.id.editText)).setText(" ");
        Cursor cursor = mdb.getDados();
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String id = cursor.getString(0);
                String nome = cursor.getString(1);
                String valor = cursor.getString(2);
                CharSequence registro = id + ", " + nome+", " + valor;
                ((EditText)findViewById(R.id.editText)).append(registro + "\n");
            }while (cursor.moveToNext());
        }
    }

    public void inserirDados(View view){
        String nome = ((TextView)findViewById(R.id.textView6)).getText().toString();
        String valor = ((TextView)findViewById(R.id.tvValort2)).getText().toString();
        mdb.insertDados(nome, valor);
        exibirPedido();

    }


}
