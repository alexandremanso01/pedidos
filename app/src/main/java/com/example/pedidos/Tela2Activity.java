package com.example.pedidos;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedidos.DataBase.DadosOpenHelper;

public class Tela2Activity extends AppCompatActivity {

    DadosOpenHelper mdb;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        mdb = new DadosOpenHelper(this, "lista", null, 1);

        updateTf();
      //  exibirPedido();

    }

    public void exibirPedido(){
        ((EditText)findViewById(R.id.editText)).setText(" ");
        cursor = mdb.getDados();
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String id = cursor.getString(0);
                String nome = cursor.getString(1);
                String valor = cursor.getString(2);
                CharSequence registro =" N° " + id + ",      "+"Nome: "+nome+",      "+"Valor: " + valor;
                ((EditText)findViewById(R.id.editText)).append(registro + "\n");


            }while (cursor.moveToNext());
//            String idSet = cursor.getString(0);
//            TextView tvId = (TextView)findViewById(R.id.tvId);
//            tvId.setText(idSet);
        }


    }

    public void inserirDados(View view){
        String nome = ((TextView)findViewById(R.id.textView6)).getText().toString();
        String valor = ((TextView)findViewById(R.id.tvValort2)).getText().toString();
        mdb.insertDados(nome, valor);

        exibirPedido();
        toast();
    }

    public void updateTf(){
        TextView tfTexto = (TextView) findViewById(R.id.tvValort2);
        TextView tvTextoNome = (TextView)findViewById(R.id.textView6);
        Bundle extra = getIntent().getExtras();
        String prRecebido = extra.getString("parametro");
        String prRecebido1 = extra.getString("parametro1");
        tfTexto.setText(prRecebido);
        tvTextoNome.setText(prRecebido1);
    }

    public void toast(){
        Context context = getApplicationContext();
        CharSequence text = "Seu pedido foi Cadastrado com sucesso!!!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
    }


}
