package beans;

public class Filhacao {
    protected String mae;
    protected String pai;

    public Filhacao(String mae, String pai) {
        this.mae = mae;
        this.pai = pai;
    }

    @Override
    public String toString() {
        return "Filhacao{" + "mae=" + mae + ", pai=" + pai + '}';
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }
}
