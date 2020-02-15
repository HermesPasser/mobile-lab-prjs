package beans;

public class Turma {
    protected int id;
    protected String sala;
    protected int ano;

    public Turma(int id, String sala, int ano) {
        this.id = id;
        this.sala = sala;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", sala=" + sala + ", ano=" + ano + '}';
    }
}
