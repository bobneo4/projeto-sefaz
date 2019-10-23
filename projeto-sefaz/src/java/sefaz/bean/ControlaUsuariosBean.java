package sefaz.bean;

import sefaz.dao.UsuarioDAO;
import sefaz.entity.Usuario;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import sefaz.entity.Usuario;

@ManagedBean

public class ControlaUsuariosBean {
    
    private Usuario Usuario = new Usuario();
    private List<Usuario> ListaUsuario = new ArrayList<>();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public void adicionarUsuario(){
        ListaUsuario.add(Usuario);
        new UsuarioDAO().salvar(Usuario);
        Usuario = new Usuario();
    }        
    
    public void Listar(){
        ListaUsuario = usuarioDAO.buscar();
    }
    
//    public void Editar(Usuario u){
//        usuario = u;
//    }
    
    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public List<Usuario> getListaUsuario() {
        return ListaUsuario;
    }

    public void setListaUsuario(List<Usuario> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }
    
}

