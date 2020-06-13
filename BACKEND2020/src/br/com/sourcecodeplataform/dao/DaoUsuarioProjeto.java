package br.com.sourcecodeplataform.dao;

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
        String sql = "UPDATE usuarios_projetos SET idUsuario = ?, idProjeto = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, up.getUsuarioId());
        stmt.setInt(2, up.getProjetoId());
        stmt.setInt(3, up.getId());
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
        String sql = "insert into usuarios_projetos (idUsuario, idProjeto) values (?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, up.getUsuarioId());
        stmt.setInt(2, up.getProjetoId());
        stmt.execute();
        stmt.close();
        c.close();
        return up;
    }
    
    public UsuarioProjeto busca(UsuarioProjeto up) throws SQLException{
        String sql = "select * from usuarios_projetos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1,up.getId());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            up.setId(rs.getInt(1));
            up.setUsuarioId(rs.getInt(2));
            up.setProjetoId(rs.getInt(3));
        }
        rs.close();
        stmt.close();
        c.close();
        return up;
    }
    
    public List<UsuarioProjeto> lista(UsuarioProjeto usuPes) throws SQLException{
        List<UsuarioProjeto> usuPess = new ArrayList<>();  
        String sql = "select * from usuarios_projetos where idProjeto like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + usuPes.getProjetoId()+ "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            UsuarioProjeto usu = new UsuarioProjeto(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3)
            );
            usuPess.add(usu);
        }
        
        rs.close();
        stmt.close();
        c.close();
        return usuPess;
    }
}
