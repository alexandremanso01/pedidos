package com.example.pedidos.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper{

    public DadosOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pedido (id integer primary key autoincrement, nome varchar(50), valor varchar(50))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDados(String nome, String valor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome", nome);
        dados.put("valor", valor);
        db.insert("pedido", null, dados);
    }

    public Cursor getDados(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from pedido", null);
    }
}
