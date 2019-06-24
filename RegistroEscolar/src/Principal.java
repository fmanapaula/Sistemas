import java.io.*;
import javax.swing.JOptionPane;
public class Principal {
    public static void main (String args[])throws IOException{
        Aluno[] aluno = new Aluno[3];
        Metodos m = new Metodos();
        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("----------------------------------------------------------------\n"
                    + "|	MENU ESTATÍSTICA			|\n"
                    + "| 1 - Cadastra Aluno           			|\n"
                    + "| 2 - Ler Aluno                  		|\n"
                    + "| 9 - Finaliza.					|\n"
                    + "----------------------------------------------------------------"));
            switch (opc) {

                case 1:
                    aluno = m.CadastraAluno(aluno);
                    break;

                case 2:
                    m.LerAluno(aluno);
                    break;

                case 9:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }
        }
        
    }
    
}
