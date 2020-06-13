package br.com.sourcecodeplataform.dao;

import br.com.sourcecodeplataform.bean.Projeto;
import br.com.sourcecodeplataform.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProjeto {
    
    private final Connection c;
    
    public DaoProjeto() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public List<Projeto> listaTodos() throws SQLException{
        List<Projeto> prs = new ArrayList<>();    
        String sql = "select * from projetos";  
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Projeto pr = new Projeto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            prs.add(pr);
        }
        
        rs.close();
        stmt.close();
        return prs;
    }
    
    public List<Projeto> lista(Projeto pr) throws SQLException{
        List<Projeto> prs = new ArrayList<>();
        String sql = "select * from projetos where name like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + pr.getName() + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Projeto p = new Projeto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            prs.add(p);
        }
        
        rs.close();
        stmt.close();
        return prs;    
    }
    
    public Projeto busca(Projeto proj) throws SQLException{
        String sql = "select * from projetos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, proj.getId());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            proj.setId(rs.getInt(1));
            proj.setName(rs.getString(2));
            proj.setDescription(rs.getString(3));
            proj.setArchiveFilename(rs.getString(4));
            proj.setScmType(rs.getString(5));
        }
        rs.close();
        stmt.close();
        c.close();
        return proj;
    }
    
    public Projeto altera(Projeto proj) throws SQLException{
        String sql = "UPDATE projetos SET name = ?, description = ?, filepath = ?, scmType = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1, proj.getName());
        stmt.setString(2, proj.getDescription());
        stmt.setString(3, proj.getArchiveFilename());
        stmt.setString(4, proj.getArchiveFilename());
        stmt.setInt(5, proj.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return proj;
    }

    public Projeto exclui(Projeto proj) throws SQLException{
        String sql = "delete from projetos WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, proj.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return proj;
    }
    
    
    public Projeto inseri(Projeto proj) throws SQLException{
        String sql = "insert into projetos (name, description, filepath, scmType) values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, proj.getName());
        stmt.setString(2, proj.getDescription());
        stmt.setString(3, proj.getArchiveFilename());
        stmt.setString(4, proj.getScmType());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            proj.setId(id);
        }
        stmt.close();
        rs.close();
        c.close();
        return proj;
    }
}
