package sefaz.dao;

import sefaz.entity.Usuario;
import sefaz.util.exception.ConexaoDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sefaz.util.exception.ConexaoDB;
import sefaz.entity.Usuario;

public class UsuarioDAO {
    public void salvar(Usuario usuario){
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps;
            if(usuario.getId() == null){
                ps = conexao.prepareCall("INSERT INTO usuarios (nome,email,senha,ddd, numero, tipo) VALUES (?,?,?,?,?,?");
            }else{
                ps = conexao.prepareStatement("update usuario set nome=?, email=?, senha=?, ddd=?, numero=?, tipo=? where id=?");
                ps.setInt(6, usuario.getId());
            }
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getDdd());
            ps.setString(5, usuario.getNumero());
            ps.setString(6, usuario.getTipo_telefone());
            ps.execute();
            ConexaoDB.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> buscar(){
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuarios");
            ResultSet resultSet = ps.executeQuery();
            List<Usuario> ListaUsuarios = new ArrayList<>();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setDdd(resultSet.getInt("ddd"));
                usuario.setNumero(resultSet.getString("numero"));
                usuario.setTipo_telefone(resultSet.getString("tipo"));
                ListaUsuarios.add(usuario);
            }
            return ListaUsuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void deletar(Usuario usuario){
        try {
            Connection conexao = ConexaoDB.getConexao();
            PreparedStatement ps = conexao.prepareStatement("Delete From usuarios where id=?");
            ps.setInt(1, usuario.getId());
            ps.execute();
            
        } catch (Exception e) {
            
        }
    }
}
