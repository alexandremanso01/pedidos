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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        telaActive2();

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



}
