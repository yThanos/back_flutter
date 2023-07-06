package br.ufsm.csi.back_flutter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/back_flutter";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConexao() throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        return conexao;
    }
}
