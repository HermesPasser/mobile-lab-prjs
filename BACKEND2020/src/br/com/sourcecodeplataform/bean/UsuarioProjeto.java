package br.com.sourcecodeplataform.bean;

public class UsuarioProjeto {
    private int id;
    private int usuarioId;
    private int projetoId;
    
    private Usuario u;
    private Projeto p;
    
    public UsuarioProjeto( ) { }
    
    public UsuarioProjeto(int id) {
        this.id = id;
    }

    public UsuarioProjeto(int id, int usuarioId, int projetoId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.projetoId = projetoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public Usuario getUsuario() {
        return u;
    }

    public void setUsuario(Usuario u) {
        this.u = u;
    }

    public Projeto getProjeto() {
        return p;
    }

    public void setProjeto(Projeto p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "UsuarioProjeto{" + "id=" + id + ", usuarioId=" + usuarioId + ", projetoId=" + projetoId + '}';
    } 
}
