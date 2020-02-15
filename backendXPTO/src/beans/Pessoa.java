package beans;

public abstract class Pessoa {
    protected int idPessoa;
    protected String nome;
    
    public void setIdPessoa(int id) {
        this.idPessoa = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }  
}
