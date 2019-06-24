
import java.io.*;

public class TiredMetodos {
	

	void showContasCorrentes(ContasCorrentes[] cadastro) throws IOException {
		String fileName = "Extrato.txt";
		BufferedWriter writeThis = new BufferedWriter(new FileWriter(fileName));
		String[] text = { "Física", "Conjunta", "Jurídica", "Especial" };
		
		for (int i = 0; i < cadastro.length; i++) {
			System.out.println("Código da Conta Correntes: " + cadastro[i].codigoConta + "\nNome do cliente: "
					+ cadastro[i].nomeCliente);
			
			writeThis.write("Código da Conta Correntes: " + (Integer.toString(cadastro[i].codigoConta)));
			writeThis.newLine();
			writeThis.write("Nome do Cliente: " + cadastro[i].nomeCliente);
			writeThis.newLine();
			
			System.out.println("Tipo da conta: " + text[cadastro[i].tipoConta - 1] + "\nSaldo inicial: "
					+ cadastro[i].saldoConta + "\nLimite de crédito: " + cadastro[i].limiteConta);
			
			
			writeThis.write("Tipo da conta: " + text[cadastro[i].tipoConta - 1]);
			writeThis.newLine();
			writeThis.write("Saldo inicial: " + (Double.toString(cadastro[i].saldoConta)));
			writeThis.newLine();
			writeThis.write("Limite de crédito: " + (Double.toString(cadastro[i].limiteConta)));
			writeThis.newLine();
			writeThis.newLine();
			writeThis.newLine();
			
			System.out.println();
			System.out.println();
		}
		
		writeThis.close();
	}

	void showMovimentacao(MovimentacaoContas[] movimentoConta)throws IOException {
		String fileName="Extrato 1.1.txt";
		String[] text = { "Crédito", "Débito" };
		BufferedWriter writeThis = new BufferedWriter(new FileWriter(fileName));
		
		for (int i = 0; i < movimentoConta.length; i++) {
			
			System.out.println("Código da conta em que houve movimento: " + movimentoConta[i].codigoContaM
					+ "\nTipo da Operação: " + text[movimentoConta[i].statusMovimento - 1]
					+ "\nValor da operação/movimento: " + movimentoConta[i].valorMovimento);
			
			writeThis.write("Código da conta em que houve movimento: " + (Integer.toString(movimentoConta[i].codigoContaM)));
			writeThis.newLine();
			writeThis.write("Tipo da Operação: " + text[movimentoConta[i].statusMovimento - 1]);
			writeThis.newLine();
			writeThis.write("Valor da operação/movimento: " + (Double.toString(movimentoConta[i].valorMovimento)));
			writeThis.newLine();
			writeThis.newLine();
			writeThis.newLine();
			
			System.out.println();
			System.out.println();
		}
		
		writeThis.close();
	}

	void showAtualizacao(ContasAtualizadas[] dadosAt)throws IOException {
		String fileName="Extrato 1.2.txt";
		String[] text = { "Física", "Conjunta", "Jurídica", "Especial" };
		BufferedWriter writeThis = new BufferedWriter(new FileWriter(fileName));
		
		for (int i = 0; i < dadosAt.length; i++) {
			
			System.out.println(
					"Código da Conta: " + dadosAt[i].codigoContaA + "\nNome do cliente: " + dadosAt[i].nomeClienteA);
			
			writeThis.write("Código da Conta: " + (Integer.toString(dadosAt[i].codigoContaA )));
			writeThis.newLine();
			writeThis.write("Nome do cliente: " + dadosAt[i].nomeClienteA);
			writeThis.newLine();
			
			System.out.println("Tipo da conta: " + text[dadosAt[i].tipoContaA - 1] + "\nNovo Saldo: "
					+ dadosAt[i].saldoContaA + "\nNovo limite de crédito: " + dadosAt[i].limiteContaA);
			
			writeThis.write("Tipo da conta: " + text[dadosAt[i].tipoContaA - 1] );
			writeThis.newLine();
			writeThis.write("Novo Saldo: "+ (Double.toString(dadosAt[i].saldoContaA )));
			writeThis.newLine();
			writeThis.write("Novo limite de crédito: " + (Double.toString(dadosAt[i].limiteContaA)));
			writeThis.newLine();
			writeThis.newLine();
			writeThis.newLine();
			
			System.out.println();
			System.out.println();
						
		}
		
		writeThis.close();
	}
}
