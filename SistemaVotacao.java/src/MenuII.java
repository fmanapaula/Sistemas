import java.io.*;
import javax.swing.JOptionPane;

public class MenuII {
    public static void main(String args[]) throws IOException {

        Abstrata[] obj = new Abstrata[100];
        int vetor[] = new int[10];
        int vt[] = new int[300];
        int opc = 0;
        Met pegar= new Met();
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("----------------------------------------------------------------\r\n"
                    + "|	SISTEMA DE VOTAÇÃO			|\r\n"
                    + "|      1 – Carregar Seção/Número Eleitor  	|\r\n"
                    + "|      2 – Classificar por Seção      		|\r\n"
                    + "|      3 – Gravar Registros                                	|\r\n"
                    + "|      4 – Mostrar Indicadores                                   |\r\n"
                    + "|      9 – Finalizar                                           	|\r\n"
                    + "----------------------------------------------------------------\r\n"
                    + ""));
            switch (opc) {
                case (1):
                    obj = pegar.cadastroGeral(obj);
                    break;
                case (2):
                    vetor = pegar.classificaSecao(obj, vetor);
                    vt = pegar.classificaCandidatos(obj, vt);
                    JOptionPane.showMessageDialog(null, "Dados Classificados!");
                    break;
                case (3):
                    obj = pegar.gravarDados(obj);
                    break;
                case (4):
                    Menu ob = new Menu();
                    ob.op(vetor, vt);
                    break;
                case (9):
                    JOptionPane.showMessageDialog(null, "Fim da Operação");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
            }
        }
    }

}