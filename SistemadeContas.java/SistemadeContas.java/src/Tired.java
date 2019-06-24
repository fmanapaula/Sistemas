
import javax.swing.JOptionPane;
import java.io.*;
public class Tired {

	void anotherCase(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta, ContasAtualizadas[] dadosAtualizados)throws IOException {
		int op = 0;
		String s = makeMenu("");
		while (op != 9) {
			TiredMetodos yep= new TiredMetodos();
			op = Integer.parseInt(JOptionPane.showInputDialog(s));
			switch(op){
			case(1):
				yep.showContasCorrentes(cadastro);
				break;
			case(2):
				yep.showMovimentacao(movimentoConta);
				break;
			case(3):
				yep.showAtualizacao(dadosAtualizados);
				break;
			case(9):
				JOptionPane.showMessageDialog(null, "Fim do processo!");
				break;
			default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					
			}
		}
	}

	String makeMenu(String s) {
	s+="............................................\r\n" + 
			".    Consulta Cadastros        .\r\n" + 
			"..........................................\r\n" + 
			". 1 - Contas Correntes       .\r\n" + 
			". 2 - Movimento                 .\r\n" + 
			". 3 - Atualizado                   .\r\n" + 
			". 9 - FIM                               .\r\n" + 
			"..........................................\r\n" + 
			"";
		return s;
	}
}