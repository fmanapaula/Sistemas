
import javax.swing.JOptionPane;

public class CCmetodos {
	ContasCorrentes[] cadastroContas(ContasCorrentes[] cadastro) {// first case

		for (int i = 0; i < cadastro.length; i++) {// limpeza de espaços;
			cadastro[i] = new ContasCorrentes();
		}

		for (int i = 0; i < cadastro.length; i++) {// alocaçao de dados
			cadastro[i].codigoConta = Integer
					.parseInt(JOptionPane.showInputDialog("insira o código da conta, por favor!"));
			cadastro[i].nomeCliente = JOptionPane.showInputDialog("insira o nome do cliente, por favor!");
			cadastro[i].saldoConta = 1 + (Math.random() * 10000);
			cadastro[i].limiteConta = 1 + (Math.random() * 10000);
			cadastro[i].tipoConta = 1 + (int) (Math.random() * 4);
		}
		return cadastro;
	}

	MovimentacaoContas[] cadastraMovimento(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta) {// seconde
																												// case

		for (int i = 0; i < movimentoConta.length; i++) {
			movimentoConta[i] = new MovimentacaoContas();
		}
		for (int i = 0; i < movimentoConta.length; i++) {
			movimentoConta[i].codigoContaM = cadastro[(1 + (int) (Math.random() * 5) - 1)].codigoConta;
			movimentoConta[i].statusMovimento = 1 + (int) (Math.random() * 2);// tipo de movimento seria esse
			movimentoConta[i].tipoMovimento = 1 + (int) (Math.random() * 4);// pra mim voce so pode creditar ou debitar,
																			// buseta
			movimentoConta[i].valorMovimento = 1 + (Math.random() * 10000);
		}
		return movimentoConta;
	}

	ContasAtualizadas[] geraContasAtualizadas(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta,
			ContasAtualizadas[] dadosAtualizados) {//third case

		for (int i = 0; i < dadosAtualizados.length; i++)
			dadosAtualizados[i] = new ContasAtualizadas();

		Sort fair = new Sort();// objeto

		cadastro = fair.justSort(cadastro);// ordenar
		movimentoConta = fair.justSortTwo(movimentoConta);// ordenar

		return dadosAtualizados = balanceLine(movimentoConta, cadastro, dadosAtualizados);

	}

	ContasAtualizadas[] balanceLine(MovimentacaoContas[] movimentoConta, ContasCorrentes[] cadastro,
			ContasAtualizadas[] dadosAt) {
		/*
		 * eu acredito que preciso dessa quantidade enorme de if statments por duas
		 * razões: a primeira é porque eu nao conheço hashMap, AINDA a segunda é porque
		 * eu nao quero gerar descritivo ou armazenar valores do mesmo genero, como
		 * andava fazendo; nessa ocasião eu preciso fazer uma operação com valores, e
		 * não armazenar valores do mesmo tipo: a manipulação de valores do mesmo tipo
		 * se da no while sempre que eu encontro códigos de contas semelhantes nas
		 * minhas duas structs.
		 */
		int i = 0;
		while (i < dadosAt.length) {

			int j = 0;
			boolean flag=false;
			while (j < movimentoConta.length) {
//Eu preciso arrumar as expressões desse código: elas estão horriveis
//Alem disso, acho SUPER VÁLIDO, tambem gravar esses dados num txt; farei isso também.				
				if (cadastro[i].codigoConta == movimentoConta[j].codigoContaM) {
					// dados genéricos: não precisam de uma condição para serem copiados pois não
					// serão alterados.
					flag=true;
					dadosAt[i].codigoContaA = movimentoConta[j].codigoContaM;
					dadosAt[i].nomeClienteA = cadastro[i].nomeCliente;
					dadosAt[i].tipoContaA = cadastro[i].tipoConta;
					dadosAt[i].statusA = movimentoConta[j].statusMovimento;

					if (dadosAt[i].statusA == 1) {
						//verifico se é crédito
						dadosAt[i].limiteContaA = cadastro[i].limiteConta;
						dadosAt[i].saldoContaA = cadastro[i].saldoConta + movimentoConta[j].valorMovimento;// porque é
																											// credito(?)
							j++;//não faz mais nada abaixo
					} else if (cadastro[i].saldoConta < movimentoConta[j].valorMovimento) {

						

						dadosAt[i].limiteContaA = verificaLimite(cadastro, movimentoConta, i, dadosAt, j);
						dadosAt[i].saldoContaA = 0.0;
						//
						j++;// nao faz mais nada abaixo
					} else {
						
						dadosAt[i].limiteContaA = verificaLimite(cadastro, movimentoConta, i, dadosAt, j);
						dadosAt[i].saldoContaA = verificaSaldo(cadastro, movimentoConta, i, dadosAt, j);
						j++;// nao faz mais nada abaixo

					}
				}else {
					j++;
				}
			}
			if(!flag) {
				dadosAt[i].codigoContaA=cadastro[i].codigoConta;
				dadosAt[i].limiteContaA=cadastro[i].limiteConta;
				dadosAt[i].nomeClienteA=cadastro[i].nomeCliente;
				dadosAt[i].saldoContaA= cadastro[i].saldoConta;
				dadosAt[i].tipoContaA= cadastro[i].tipoConta;
			}
			i++;
		}

		return dadosAt;

	}

	double verificaLimite(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta, int i,
			ContasAtualizadas[] dadosAt, int j) {

		if (movimentoConta[j].tipoMovimento == 1) {// aqui tbm nao ficou muito claro, mas é isso
			dadosAt[i].limiteContaA = 0.0;

		} else if (movimentoConta[j].tipoMovimento == 2) {
			dadosAt[i].limiteContaA=cadastro[i].limiteConta;

		} else if (movimentoConta[j].tipoMovimento == 3) {
			dadosAt[i].limiteContaA=cadastro[i].limiteConta + (0.5 * cadastro[i].saldoConta);

		} else {
			dadosAt[i].limiteContaA=cadastro[i].limiteConta + cadastro[i].saldoConta;
		}

		if (dadosAt[i].limiteContaA + cadastro[i].saldoConta < movimentoConta[j].valorMovimento) {
			
			dadosAt[i].limiteContaA=0.0;

		} else if (movimentoConta[j].valorMovimento > cadastro[i].saldoConta) {

			dadosAt[i].limiteContaA -= movimentoConta[j].valorMovimento - cadastro[i].saldoConta;

		} // se nao for nenhuma das duas, so retorno o limite mesmo, sem alterações.
		return dadosAt[i].limiteContaA;

	}

	double verificaSaldo(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta, int i,
			ContasAtualizadas[] dadosAt, int j) {

		return cadastro[i].saldoConta - movimentoConta[j].valorMovimento;
//não sei ainda o porquê desse módulo; acho que achei chique modularizar
	}
}
