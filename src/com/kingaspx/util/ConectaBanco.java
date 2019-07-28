package com.kingaspx.util;

import static com.kingaspx.util.LoggerOutput.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;

    private final String driver = "org.mysql.Driver";
    private final String root = "jdbc:mysql://127.0.0.1/image_table";
    private final String user = "root";
    private final String pass = "";

    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(root, user, pass);
            log("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executaSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconecta() {
        try {
            conn.close();
            log("Desconectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
