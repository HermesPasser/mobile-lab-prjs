package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;
import javafx.util.Pair;

public class ControleUsuario {
    
    public static DaoUsuario dao;
    
     public List<Usuario> listUser(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        return usuDao.lista(usu);
    }
     
    public List<Usuario> listAllUsers() throws SQLException, ClassNotFoundException {
        DaoUsuario udao = new DaoUsuario();
        return udao.listaTodos();
    }
    
    public Usuario excluirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        return usuDao.exclui(usu);
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
    
    public Usuario insertUser(Usuario usu) throws SQLException, ClassNotFoundException {
       DaoUsuario usuDao = new DaoUsuario();
       return usuDao.inseri(usu);
    }
    
    public void deleteAll() throws SQLException, ClassNotFoundException {
       new DaoUsuario().deleteAll();
    }
    
    // Conta o número de items na tabela para saber se o apagarusuario apagou mesmo
    public int contRows() throws SQLException, ClassNotFoundException {
        return new DaoUsuario().countRows();
    }
    
    /**
    * Validates the user 
    * @return a pair with the evaluated Usuário and a boolean
    * that is true if the validation was successfully
    */
    public Pair<Usuario, Boolean> validateUser(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        return usuDao.validateUser(usu);
    }
}
