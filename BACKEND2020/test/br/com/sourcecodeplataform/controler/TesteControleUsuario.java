package br.com.sourcecodeplataform.controler;

import br.com.sourcecodeplataform.bean.Usuario;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControleUsuario {
    
    public TesteControleUsuario() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Usuario u = new Usuario(0, "bil", "gates@mail.com");
          ControleUsuario c = new ControleUsuario();
          u = c.buscaUsuarioPorId(u);
          assertEquals("linux", u.getName());
    }
}
