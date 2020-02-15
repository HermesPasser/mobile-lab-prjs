package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

public class ControleUsuario {
    
    public static DaoUsuario dao;
    
    // peguei do outro, arrumar para funfar
     public List<Usuario> listarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        DaoUsuario usuDao = new DaoUsuario();
        usus = usuDao.lista(usu);
        return usus;
    }
     
    public List<Usuario> listUsers() throws SQLException, ClassNotFoundException {
        DaoUsuario udao = new DaoUsuario();
        return udao.listaTodos();
    }
    
    public Usuario alterarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.altera(usu);
        return usu;
    }
    
    public Usuario buscaUsuarioPorId (Usuario u) throws SQLException, ClassNotFoundException{
        dao = new DaoUsuario();
        return dao.busca(u);
    }
    
       public Usuario validateUser(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.validateUser(usu);
        return usu;
    }
}
