package backendxpto;
import beans.Aluno;
import view.AfilhacaoGUI;

public class BackendXPTO {

    public static void main(String[] args) {
        Aluno al = new Aluno(1, null, 1, null);
        System.out.println(al);
        
        new AfilhacaoGUI().setVisible(true);
    }
}
