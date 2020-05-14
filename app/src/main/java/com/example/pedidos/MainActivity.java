package com.example.pedidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pedidos.DataBase.DadosOpenHelper;

public class MainActivity extends AppCompatActivity {
    DadosOpenHelper mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb = new DadosOpenHelper(this, "lista", null, 1);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        telaActive2();



    }

    public void inserirDados(View view){
        String nome = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String valor = ((TextView)findViewById(R.id.tvTotal)).getText().toString();
        mdb.insertDados(nome, valor);

        exibirPedido();

    }



    public void fazerPedido(View view){

        EditText etQtd = (EditText)findViewById(R.id.etQtd);
        TextView tvTotal = (TextView)findViewById(R.id.tvTotal);
        String total = etQtd.getText().toString();

        int totalPedido = Integer.parseInt(total)*10;
        String totalString =  "R$ " + Integer.toString(totalPedido) + ",00";
        tvTotal.setText(totalString);

    }

    public void telaActive2(){
        final TextView tvActivity2 = (TextView) findViewById(R.id.tvTotal);
        final EditText tvActivity1 = (EditText) findViewById(R.id.editText3);

        Button btTela2 = (Button)findViewById(R.id.button2);
        btTela2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Tela2Activity.class);
                it.putExtra("parametro", tvActivity2.getText().toString());
               it.putExtra("parametro1", tvActivity1.getText().toString());
                startActivity(it);
            }
        });


    }

    public void exibirPedido(){
        ((EditText)findViewById(R.id.editText2)).setText(" ");
        Cursor cursor = mdb.getDados();
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                String id = cursor.getString(0);
                String nome = cursor.getString(1);
                String valor = cursor.getString(2);
                CharSequence registro = id + ", " + nome+", " + valor;
                ((EditText)findViewById(R.id.editText2)).append(registro + "\n");
            }while (cursor.moveToNext());
        }

    }

}
