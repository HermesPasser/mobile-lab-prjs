package br.com.sourcecodeplataform.bean;

public class Usuario {
    private int id;
    private String name;
    private String email;
    private String password;
    private String type;

    public Usuario(int id) {
        this.id = id;
    }
    
    public Usuario(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.password = pass;
    }

    public Usuario(int id, String name, String email, String pass, String tipo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = pass;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", type=" + type + '}';
    }
}
