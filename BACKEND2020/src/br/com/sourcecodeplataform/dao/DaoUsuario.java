package br.com.sourcecodeplataform.dao;

import br.com.sourcecodeplataform.util.ConexaoDB;
import br.com.sourcecodeplataform.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    // peguei do outro, arrumar para funfar
    public List<Usuario> lista(Usuario usuEnt) throws SQLException{
        List<Usuario> usus = new ArrayList<>();
        String sql = "select * from usuarios where email like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + usuEnt.getEmail() + "%");
        
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
    
    public Usuario validateUser(Usuario usu) throws SQLException{
        String sql = "select * from usuarios WHERE email = ? AND password = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, usu.getEmail());
        stmt.setString(2, usu.getPassword());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            usu.setId(rs.getInt(1));
            usu.setName(rs.getString(2));
            usu.setEmail(rs.getString(3));
            usu.setPassword(rs.getString(4));
            usu.setType(rs.getString(5));
        }
        
        rs.close();
        stmt.close();
        return usu;
    }
    
}
