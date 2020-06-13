package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControleProjeto {
    
    public TesteControleProjeto() { }
    
    @Test
    public void inserir() throws SQLException, ClassNotFoundException {
          Projeto pr = new Projeto(0, "linux", "Sistema operacional baseado em unix", "\\server\\file242342.zip", "");
          ControleProjeto conPro = new ControleProjeto();
          pr = conPro.inseriProjeto(pr);
          assertEquals("linux", pr.getName());
    }

    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Projeto pr = new Projeto(0, "linux", "Sistema operacional baseado em unix", "\\server\\file242342.zip", "");
          ControleProjeto conPro = new ControleProjeto();
          pr = conPro.excluiProjeto(pr);
          assertEquals(0, pr.getId());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Projeto pr = new Projeto(0, "linux", "Sistema operacional baseado em unix", "\\server\\file242342.zip", "");
          ControleProjeto conPro = new ControleProjeto();
          pr = conPro.buscaProjetoPorId(pr);
          assertEquals("linux", pr.getName());
    }

    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Projeto pr = new Projeto(0, "linux-1.9", "Sistema operacional baseado em unix", "\\server\\file242342.zip", "");
          ControleProjeto conPro = new ControleProjeto();
          pr = conPro.alteraProjeto(pr);
          assertEquals("linux-1.9", pr.getName());
    }

}
