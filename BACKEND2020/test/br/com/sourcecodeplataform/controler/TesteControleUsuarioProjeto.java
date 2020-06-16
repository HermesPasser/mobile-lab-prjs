package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.bean.UsuarioProjeto;
import br.com.sourcecodeplataform.util.ConexaoDB;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControleUsuarioProjeto {
    ControleUsuarioProjeto c;
    UsuarioProjeto up;
    
    ControleProjeto cp;
    Projeto p;
    
    ControleUsuario cu;
    Usuario u;
    
    public TesteControleUsuarioProjeto() { }
    @Before
    public void setUp() { 
        ConexaoDB.isMock = true;
        
        c = new ControleUsuarioProjeto();
        cu = new ControleUsuario();
        cp = new ControleProjeto();
        
        p = new Projeto(1, "linux", "sistema operativo", "file/path/linux", "git");
        u = new Usuario(1, "bil", "gates@mail.com", "", "");
        
        try {
            u = cu.insertUser(u);
            u = cu.listUser(u).get(0);
            
            p = cp.inseriProjeto(p);
            p = cp.listProjeto(p).get(0);
            
            up = new UsuarioProjeto(1, u.getId(), p.getId(),  true);
        } catch(Exception e) {}
    }
    
    @After
    public void tearDown() { 
        // Apaga todos os registros
        try { 
          c.deleteAll();
          cu.deleteAll();
          cp.deleteAll();
        } catch(Exception e) {}
    }
    
    @Test
    public void insertion() throws SQLException, ClassNotFoundException { 
        c.inserirUsuarioProjeto(up);
        
        UsuarioProjeto temp = c.buscaUsuarioProjetoPorId(up);
        assertEquals(temp.getId(), temp.getId());
    }
    
    @Test
    public void search() throws SQLException, ClassNotFoundException {       
        c.inserirUsuarioProjeto(up);     
        assertEquals(true, c.buscaUsuarioProjetoPorId(up).itIsOwner());
    }
          
    @Test
    public void update() throws SQLException, ClassNotFoundException {
        up.setIsOwner(false);
        c.inserirUsuarioProjeto(up);
        
        UsuarioProjeto temp = c.buscaUsuarioProjetoPorId(up);
        assertEquals(false, temp.itIsOwner()); 
    }
    
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        c.inserirUsuarioProjeto(up);
        assertEquals(1, c.contRows()); 
        
        up = c.listarUsuarioProjeto(up).get(0);
        c.excluirUsuarioProjeto(up);
        assertEquals(0, c.contRows());
    } 
}
