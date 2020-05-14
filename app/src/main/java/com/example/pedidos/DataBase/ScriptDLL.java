package com.example.pedidos.DataBase;

public class ScriptDLL {
    public static String getCrateTablePedido(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS PEDIDO ( ");
        sql.append("    CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("    NOME VARCHAR (250) NOT NULL DAFAULT(''), ");
        sql.append("    VALOR VARCHAR (250) NOT NULL DAFAULT('') ) ");

        return sql.toString();
    }

}
