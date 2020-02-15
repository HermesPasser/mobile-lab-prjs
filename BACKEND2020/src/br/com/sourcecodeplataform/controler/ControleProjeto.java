package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.dao.DaoProjeto;
import java.sql.SQLException;
import java.util.List;

public class ControleProjeto {
    
    public static DaoProjeto dao;

    public Projeto buscaProjetoPorId (Projeto pro) throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.busca(pro);
    }

    public Projeto inseriProjeto (Projeto pro) throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.inseri(pro);
    }

    public Projeto alteraProjeto (Projeto pro) throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.altera(pro);
    }

    public Projeto excluiProjeto (Projeto pro) throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.exclui(pro);
    }

    public List<Projeto> listProjeto (Projeto pro) throws SQLException, ClassNotFoundException {
        List<Projeto> list;
        dao = new DaoProjeto();
        list = dao.lista(pro);
        return list;
    }
}
