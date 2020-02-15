package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.bean.UsuarioProjeto;
import br.com.sourcecodeplataform.dao.DaoUsuarioProjeto;
import java.sql.SQLException;

public class ControleUsuarioProjeto {
    
    public static DaoUsuarioProjeto daoUsuarioProjeto;
    public static ControleProjeto contProj = new ControleProjeto();
    public static ControleUsuario contUsu = new ControleUsuario();
    
    public UsuarioProjeto buscaUsuarioProjetoPorId (UsuarioProjeto up) throws SQLException, ClassNotFoundException {
        daoUsuarioProjeto = new DaoUsuarioProjeto();
        
        up = daoUsuarioProjeto.busca(up);
        
        Usuario user = new Usuario(up.getUsuarioId());
        up.setU(contUsu.buscaUsuarioPorId(user));

        Projeto pr = new Projeto(up.getProjetoId());
        up.setP(contProj.buscaProjetoPorId(pr));
     
        return up;
    } 
}
