import javax.swing.JOptionPane;
import java.io.*;
public class Menu {

    public static void main(String args[]) throws IOException {
        Estatistica[] estatistica = new Estatistica[15];
        Metodos m = new Metodos();
       // String[] text = {"São Paulo", "Rio de Janeiro", "Santa Catarina", "Bahia"};
         
        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("----------------------------------------------------------------\n"
                    + "|	MENU ESTATÍSTICA			|\n"
                    + "| Estatísticas de acidentes em 2015		|\n"
                    + "| 1 - Cadastro Estatística			|\n"
                    + "| 2 - Consulta por tipo de veículo		|\n"
                    + "| 3 - Consulta por quantidade de acidentes	|\n"
                    + "| 4 - Consulta todas as cidades                   |\n"
                    + "| 5 - Consulta maior e menor média de acidentes	|\n"
                    + "| 9 - Finaliza.					|\n"
                    + "----------------------------------------------------------------"));
            switch (opc) {

                case 1:
                    estatistica = m.CadastraEstatistica(estatistica);
                    break;

                case 2:
                    m.ConsultaVeiculo(estatistica);
                    break;

                case 3:
                    m.QuantidadeAcidentes(estatistica);
                    break;

                case 4:
                    m.ConsultaCidades(estatistica);
                    break;

                case 5:
                    m.ConsultaMedia(estatistica);
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