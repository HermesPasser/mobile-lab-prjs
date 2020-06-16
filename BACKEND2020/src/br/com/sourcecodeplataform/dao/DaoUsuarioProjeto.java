package br.com.sourcecodeplataform.dao;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.bean.Usuario;
import br.com.sourcecodeplataform.util.ConexaoDB;
import br.com.sourcecodeplataform.bean.UsuarioProjeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuarioProjeto {
    
    private final Connection c;
    
    public DaoUsuarioProjeto() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public UsuarioProjeto altera(UsuarioProjeto up) throws SQLException{
        String sql = "UPDATE usuarios_projetos SET idUsuario = ?, idProjeto = ?, isOwner = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, up.getUsuarioId());
        stmt.setInt(2, up.getProjetoId());
        stmt.setBoolean(3, up.itIsOwner());
        stmt.setInt(4, up.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return up;
    }

    public UsuarioProjeto exclui(UsuarioProjeto up) throws SQLException{
        String sql = "delete from usuarios_projetos WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,up.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return up;
    }

    public UsuarioProjeto inseri(UsuarioProjeto up) throws SQLException{
        String sql = "insert into usuarios_projetos (idUsuario, idProjeto, isOwner) values (?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, up.getUsuarioId());
        stmt.setInt(2, up.getProjetoId());
        stmt.setBoolean(3, up.itIsOwner());
        stmt.execute();
        stmt.close();
        c.close();
        return up;
    }
    
    public UsuarioProjeto busca(UsuarioProjeto up) throws SQLException{
        String sql = "select * from usuarios_projetos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, up.getId());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            up.setId(rs.getInt(1));
            up.setUsuarioId(rs.getInt(2));
            up.setProjetoId(rs.getInt(3));
            up.setIsOwner(rs.getBoolean(4));
        }
        rs.close();
        stmt.close();
        c.close();
        return up;
    }
    
    public List<UsuarioProjeto> lista(UsuarioProjeto up) throws SQLException{
        List<UsuarioProjeto> ups = new ArrayList<>();  
        String sql = "select * from usuarios_projetos where isOwner like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setBoolean(1, up.itIsOwner());
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            UsuarioProjeto usu = new UsuarioProjeto(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getBoolean(4)
            );
            ups.add(usu);
        }
        
        rs.close();
        stmt.close();
        c.close();
        return ups;
    }

    public boolean usuarioHasNoProjetos(Usuario usu) throws SQLException{
        String sql = "SELECT us.name 'NAME' FROM usuarios us, usuarios_projetos up "
                + "WHERE up.idUsuario = us.id AND us.id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, usu.getId());
        ResultSet rs = stmt.executeQuery();
        
        boolean hasProjetos = !rs.isBeforeFirst();
        
        rs.close();
        stmt.close();
        c.close();
        return hasProjetos;
    }
    
    
    public boolean projetoIsOwnedByNoUsuarios(Projeto p) throws SQLException{
        String sql = "SELECT p.name 'NAME' FROM projetos p,  usuarios_projetos up "
                + "WHERE up.idProjeto = p.id AND p.id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        ResultSet rs = stmt.executeQuery();
        
        boolean hasProjetos = !rs.isBeforeFirst();
        
        rs.close();
        stmt.close();
        c.close();
        return hasProjetos;
    }
    
    public void deleteAll () throws SQLException{
        String sql = "delete from usuarios_projetos";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        c.close();
    }

    public int countRows() throws SQLException{
        String sql = "select * from usuarios_projetos ";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int i = 0;
        while (rs.next()) i++;
        
        rs.close();
        stmt.close();
        c.close();
        return i;
    } 
    
}
