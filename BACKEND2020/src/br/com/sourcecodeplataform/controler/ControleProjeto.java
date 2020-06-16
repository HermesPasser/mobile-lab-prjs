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

    public Projeto buscarProjeto(Projeto pes) throws SQLException, ClassNotFoundException {
        DaoProjeto d = new DaoProjeto();
        return d.busca(pes);
    }

    public List<Projeto> listProjeto (Projeto pro) throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.lista(pro);
    }
    
    public List<Projeto> listAllProjetos () throws SQLException, ClassNotFoundException {
        dao = new DaoProjeto();
        return dao.listaTodos();
    }
       
    public void deleteAll() throws SQLException, ClassNotFoundException {
       new DaoProjeto().deleteAll();
    }
    
    // Conta o número de items na tabela para saber se o apagarusuario apagou mesmo
    public int contRows() throws SQLException, ClassNotFoundException {
        return new DaoProjeto().countRows();
    }
}
