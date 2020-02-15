package beans;

public class Aluno extends Pessoa {
    private int idAluno;
    private String RA;
    private Turma turma;
    private Filhacao filhacao;
    
    public Aluno(int idPessoa, String nome, int idAluno, String RA) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.idAluno = idAluno;
        this.RA = RA;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", RA=" + RA + ", turma=" + turma + '}';
    }
    
    public int getId() {
        return idPessoa;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }  
}
