package sefaz.util.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/db_sefaz";
    private static final String USUARIO = "root";
    private static final String SENHA = "pass123";
    
      public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
               Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao(){
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
