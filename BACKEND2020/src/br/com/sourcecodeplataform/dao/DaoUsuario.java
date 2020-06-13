package br.com.sourcecodeplataform.dao;

import br.com.sourcecodeplataform.util.ConexaoDB;
import br.com.sourcecodeplataform.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class DaoUsuario {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public List<Usuario> listaTodos() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Usuario u = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            usuarios.add(u);
        }
        
        rs.close();
        stmt.close();
        return usuarios;     
    }
    
    public Usuario exclui(Usuario usu) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, usu.getId());
        stmt.execute();
        stmt.close();
        return usu;
    }
    
    public List<Usuario> lista(Usuario usuEnt) throws SQLException{
        List<Usuario> usus = new ArrayList<>();
        String sql = "select * from usuarios where name like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + usuEnt.getName() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;     
    }
    
    public Usuario altera(Usuario usu) throws SQLException{
        String sql = "UPDATE usuarios SET "
                + "name = ?, email = ?, password = ?, type = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1, usu.getName());
        stmt.setString(2, usu.getEmail());
        stmt.setString(3, usu.getPassword());
        stmt.setString(4, usu.getType());
        stmt.setInt(5, usu.getId());

        stmt.execute();
        stmt.close();
        return usu;
    }
    
    public Usuario inseri(Usuario usu) throws SQLException{
        String sql = "insert into usuarios (name, email, password, type)  values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, usu.getName());
        stmt.setString(2, usu.getEmail());
        stmt.setString(3, usu.getPassword());
        stmt.setString(4, usu.getType());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            usu.setId(id);
        }
        
        rs.close();
        stmt.close();
        return usu;
    }
    
    public Usuario busca(Usuario user) throws SQLException{
        String sql = "select * from usuarios WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, user.getId());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPassword(rs.getString(4));
            user.setType(rs.getString(5));
        }
        rs.close();
        stmt.close();
        return user;
    } 
    
    public Pair<Usuario, Boolean> validateUser(Usuario usu) throws SQLException{
        String sql = "select * from usuarios WHERE email = ? AND password = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, usu.getEmail());
        stmt.setString(2, usu.getPassword());
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        
        if (rs.isBeforeFirst()) {
            while (rs.next()) {      
                usu.setId(rs.getInt(1));
                usu.setName(rs.getString(2));
                usu.setEmail(rs.getString(3));
                usu.setPassword(rs.getString(4));
                usu.setType(rs.getString(5));
            }
            found = true;
        } 
 
        rs.close();
        stmt.close();
        return new Pair<>(usu, found);
    }
    
}
