import javax.swing.JOptionPane;
public class Menu {

public void op(int vetor[], int vt[]) {
        int opc = 0;
        Metodos m= new Metodos();
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("-----------------------------------------------------------------------\r\n"
                            + "|	    Mostrar Indicadores			           |\r\n"
                            + "|        Estatísticas de Votação em 2018		           |\r\n"
                            + "|  1 – Quantidade Eleitores por Seção	                         |\r\n"
                            + "|  2 –Seção com Maior e Menor número de Eleitores  |\r\n"
                            + "|  3 – Quantidade de votos por candidato                       |\r\n"
                            + "|  4 – 10 primeiros colocadas (nro  cand. e qtd votos )  |\r\n"
                            + "|  9 – Finaliza consulta	                		            |\r\n"
                            + "------------------------------------------------------------------------\r\n" + ""));
            switch (opc) {
                case (1):
                    m.quantidadeEleitor(vetor);
                    break;
                case (2):
                    m.maiorMenor(vetor);
                    break;
                case (3):
                    m.quantidadeVotos(vt);
                    break;
                case (4):
                    m.maisVotados(vt);
                    break;
                case (9):
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opção inválida!");
            }
        }
    }
}