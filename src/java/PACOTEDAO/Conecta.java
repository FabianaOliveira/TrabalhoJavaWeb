package PACOTEDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta {
    
    private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String DRIVER_DERBY = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String BANCO_DE_DADOS = "sample";
    private static final String IP = "localhost"; //"192.168.0.1";
    private static final String USUARIO = "fabi";
    private static final String SENHA = "fabi";

    private static final String STR_MYSQL = "jdbc:mysql://" + IP + ":3306/" + BANCO_DE_DADOS;
    private static final String STR_DERBY = "jdbc:derby://" + IP + ":1527/" + BANCO_DE_DADOS;
    
    public static Connection getConexao() throws JavaWebException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_DERBY);
            conn = DriverManager.getConnection(STR_DERBY, USUARIO, SENHA);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new JavaWebException(errorMsg, e);
        }  catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new JavaWebException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
        }
    }
}

