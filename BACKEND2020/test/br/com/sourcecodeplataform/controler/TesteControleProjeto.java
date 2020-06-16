package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.util.ConexaoDB;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControleProjeto {
    ControleProjeto c;
    Projeto p, p2;
    
    public TesteControleProjeto() { }
    @Before
    public void setUp() { 
        // Diz para usar o banco de dados de teste
        ConexaoDB.isMock = true;
        
        c = new ControleProjeto();
        p = new Projeto(1, "linux", "sistema operativo", "file/path/linux", "git");
        p2 = new Projeto(2, "dos", "sistema operacional", "file/path/dos", "mercurio"); 
    }
    
    @After
    public void tearDown() { 
        // Apaga todos os registros
        try { 
          c.deleteAll();
        } catch(Exception e) {}
    }
    
    @Test
    public void insertion() throws SQLException, ClassNotFoundException {
        c.inseriProjeto(p);
        c.inseriProjeto(p2);
        
        Projeto ptemp = c.buscaProjetoPorId(p);
        assertEquals(ptemp.getId(), ptemp.getId());
        
        ptemp = c.buscaProjetoPorId(p2);
        assertEquals(ptemp.getId(), ptemp.getId());
    }
    
    @Test
    public void search() throws SQLException, ClassNotFoundException {       
        // Adiciona no db para procurar já que o db ta vazio
        c.inseriProjeto(p);
        
        // Procura
        assertEquals("linux", c.buscaProjetoPorId(p).getName());
    }
          
    @Test
    public void update() throws SQLException, ClassNotFoundException {
        c.inseriProjeto(p);
        p.setName("GNULinux");
        c.alteraProjeto(p); 
       
        Projeto ptemp = c.buscaProjetoPorId(p);
        assertEquals("GNULinux", ptemp.getName()); 
    }
          
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        c.inseriProjeto(p);
        assertEquals(1, c.contRows()); 
        
        c.excluiProjeto(p); 
        assertEquals(0, c.contRows()); 
    } 
}
