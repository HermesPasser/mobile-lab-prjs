package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.util.ConexaoDB;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControleUsuario {
    ControleUsuario c;
    Usuario u, u2;
     
    public TesteControleUsuario() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        // Diz para usar o banco de dados de teste
        ConexaoDB.isMock = true;
        
        c = new ControleUsuario();
        u = new Usuario(1, "bil", "gates@mail.com", "", "");
        u2 = new Usuario(2, "tom", "tom@mail.com", "", "");   
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
        c.insertUser(u);
        c.insertUser(u2);
        
        Usuario utemp = c.buscaUsuarioPorId(u);
        assertEquals(utemp.getId(), utemp.getId());
        
        utemp = c.buscaUsuarioPorId(u2);
        assertEquals(utemp.getId(), utemp.getId());
    }
    
    @Test
    public void search() throws SQLException, ClassNotFoundException {
        // Adiciona no db para procurar já que o db ta vazio
        c.insertUser(u);
        
        // Procura
        assertEquals("bil", c.buscaUsuarioPorId(u).getName());
    }
          
    @Test
    public void update() throws SQLException, ClassNotFoundException {
        c.insertUser(u);
        u.setName("Bil Gates");
        c.alterarUsuario(u); 
       
        Usuario utemp = c.buscaUsuarioPorId(u);
        assertEquals("Bil Gates", utemp.getName()); 
    }
          
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        c.insertUser(u);
        assertEquals(1, c.contRows()); 
        
        c.excluirUsuario(u); 
        assertEquals(0, c.contRows()); 
    } 
}
