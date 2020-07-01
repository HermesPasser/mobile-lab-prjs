package com.sourcecodeplataform.modelos;
import java.io.Serializable;

public class UsuarioProjeto implements Serializable {
    private int id;
    private int usuarioId;
    private int projetoId;
    private boolean isOwner;

    private Usuario u;
    private Projeto p;

    public UsuarioProjeto( ) { }

    public UsuarioProjeto(int id) {
        this.id = id;
    }

    public UsuarioProjeto(int id, int usuarioId, int projetoId, boolean isOwner) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.projetoId = projetoId;
        this.isOwner = isOwner;
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

    public boolean itIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    @Override
    public String toString() {
        return "UsuarioProjeto{" + "id=" + id + ", usuarioId=" + usuarioId + ", projetoId=" + projetoId + ", isOwner=" + isOwner + '}';
    }
}
