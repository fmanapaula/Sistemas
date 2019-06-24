
import javax.swing.JOptionPane;
import java.io.*;
public class CadastroContas {
	public static void main(String args[])throws IOException {
		
		int op = 0;
		ContasCorrentes[] cadastro = new ContasCorrentes[5];		
		MovimentacaoContas[] movimentoConta = new MovimentacaoContas[10];
		ContasAtualizadas[] dadosAtualizados = new ContasAtualizadas[5];
		
		String s = makeString("");
		
		CCmetodos save = new CCmetodos();
		
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog(s));
			switch (op) {
			case (1):
				cadastro = save.cadastroContas(cadastro);
				break;
			case (2):
				movimentoConta=save.cadastraMovimento(cadastro, movimentoConta);
				break;
			case (3):
				dadosAtualizados=save.geraContasAtualizadas(cadastro, movimentoConta, dadosAtualizados);
				break;
			case (4):
				Tired done= new Tired();
				done.anotherCase(cadastro, movimentoConta, dadosAtualizados);
				break;
			case (9):
				JOptionPane.showMessageDialog(null, "fim da operação!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
	}

	static String makeString(String s) { // so pra despoluir o main
		s += "......................................................\r\n"
				+ ".                MENU PRINCIPAL           .\r\n"
				+ "......................................................\r\n"
				+ ". 1 - Cadastra Contas Correntes    . \r\n" + ". 2 - Cadastra movimento              .\r\n"
				+ ". 3 - Gera Contas Atualizadas       .\r\n" + ". 4 - Consulta cadastros                .\r\n"
				+ ". 9 - FIM                                           .\r\n"
				+ "....................................................\r\n" + "";
		return s;
	}

}
