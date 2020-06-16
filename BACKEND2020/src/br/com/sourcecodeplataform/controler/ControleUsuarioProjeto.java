package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.bean.UsuarioProjeto;
import br.com.sourcecodeplataform.dao.DaoUsuarioProjeto;
import java.sql.SQLException;
import java.util.List;

public class ControleUsuarioProjeto {
    
    public static DaoUsuarioProjeto daoUsuarioProjeto;
    public static ControleProjeto contProj = new ControleProjeto();
    public static ControleUsuario contUsu = new ControleUsuario();
        
    public UsuarioProjeto inserirUsuarioProjeto(UsuarioProjeto up) throws SQLException, ClassNotFoundException {
        DaoUsuarioProjeto d = new DaoUsuarioProjeto();
        return d.inseri(up);
    }

    public boolean usuarioHasNoProjetos(Usuario u) throws SQLException, ClassNotFoundException {
        return new DaoUsuarioProjeto().usuarioHasNoProjetos(u);
    }
    
    public boolean projetoIsOwnedByNoUsuarios(Projeto p) throws SQLException, ClassNotFoundException {
        return new DaoUsuarioProjeto().projetoIsOwnedByNoUsuarios(p);
    }
    
    public UsuarioProjeto buscaUsuarioProjetoPorId (UsuarioProjeto up) throws SQLException, ClassNotFoundException {
        daoUsuarioProjeto = new DaoUsuarioProjeto();
        
        up = daoUsuarioProjeto.busca(up);
        
        Usuario user = new Usuario(up.getUsuarioId());
        up.setUsuario(contUsu.buscaUsuarioPorId(user));

        Projeto pr = new Projeto(up.getProjetoId());
        up.setProjeto(contProj.buscaProjetoPorId(pr));
     
        return up;
    } 
    
    public UsuarioProjeto buscarUsuarioProjeto(UsuarioProjeto usuarioProjeto) throws SQLException, ClassNotFoundException {
        DaoUsuarioProjeto usupesDao = new DaoUsuarioProjeto();
        usuarioProjeto = usupesDao.busca(usuarioProjeto);

        Usuario usu = new Usuario(usuarioProjeto.getUsuarioId());
        usu = contUsu.buscaUsuarioPorId(usu);
        usuarioProjeto.setUsuario(usu);

        Projeto proj = new Projeto(usuarioProjeto.getProjetoId());
        proj = contProj.buscarProjeto(proj);
        usuarioProjeto.setProjeto(proj);

        return usuarioProjeto;
    }

    public List<UsuarioProjeto> listarUsuarioProjeto(UsuarioProjeto usuarioProjeto) throws SQLException, ClassNotFoundException {
        DaoUsuarioProjeto upDao = new DaoUsuarioProjeto();
        List<UsuarioProjeto> usuarioProjetos = upDao.lista(usuarioProjeto);

        for (UsuarioProjeto usuPrj : usuarioProjetos) {
            Usuario usu = new Usuario(usuPrj.getUsuarioId());
            Projeto pesfis = new Projeto(usuPrj.getProjetoId());
            usuPrj.setProjeto(contProj.buscarProjeto(pesfis));
            usuPrj.setUsuario(contUsu.buscaUsuarioPorId(usu));
        }

        return usuarioProjetos;
    }
    
    public UsuarioProjeto alterarUsuarioProjeto(UsuarioProjeto usupe) throws SQLException, ClassNotFoundException {
        DaoUsuarioProjeto usupesDao = new DaoUsuarioProjeto();
        return usupesDao.altera(usupe);
    }
    
    public UsuarioProjeto excluirUsuarioProjeto(UsuarioProjeto usuProj) throws SQLException, ClassNotFoundException {
        DaoUsuarioProjeto d = new DaoUsuarioProjeto();
        return d.exclui(usuProj);
    }
        
    public void deleteAll() throws SQLException, ClassNotFoundException {
       new DaoUsuarioProjeto().deleteAll();
    }
    
    public int contRows() throws SQLException, ClassNotFoundException {
        return new DaoUsuarioProjeto().countRows();
    }
}
