import javax.swing.JOptionPane;

public class CCmetodos {
	ContasCorrentes[] cadastroContas(ContasCorrentes[] cadastro) {

		for (int i = 0; i < cadastro.length; i++) {
			cadastro[i] = new ContasCorrentes();
		}
		for (int i = 0; i < cadastro.length; i++) {
			cadastro[i].codigoConta = Integer.parseInt(JOptionPane.showInputDialog("insira o código da conta, por favor!"));
			cadastro[i].nomeCliente = JOptionPane.showInputDialog("insira o nome do cliente, por favor!");
			cadastro[i].saldoConta = 1 + (Math.random() * 10000);
			cadastro[i].limiteConta = 1 + (Math.random() * 10000);
			cadastro[i].tipoConta = 1 + (int) (Math.random() * 4);
		}
	return cadastro;
	}
	MovimentacaoContas[] cadastraMovimento(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta) {
            for (int i = 0; i < movimentoConta.length; i++) {
		movimentoConta[i] = new MovimentacaoContas();
		}
		for (int i = 0; i < movimentoConta.length; i++) {
			movimentoConta[i].codigoContaM = cadastro[(1 + (int) (Math.random() * 5) - 1)].codigoConta;
			movimentoConta[i].statusMovimento = 1 + (int) (Math.random() * 2);
			movimentoConta[i].tipoMovimento = 1 + (int) (Math.random() * 4);
																
			movimentoConta[i].valorMovimento = 1 + (Math.random() * 10000);
		}
	return movimentoConta;
	}

	ContasAtualizadas[] geraContasAtualizadas(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta,
			ContasAtualizadas[] dadosAtualizados) {
		for (int i = 0; i < dadosAtualizados.length; i++)
			dadosAtualizados[i] = new ContasAtualizadas();
		Sort fair = new Sort();
		cadastro = fair.justSort(cadastro);
		movimentoConta = fair.justSortTwo(movimentoConta);
		return dadosAtualizados = balanceLine(movimentoConta, cadastro, dadosAtualizados);
	}
	ContasAtualizadas[] balanceLine(MovimentacaoContas[] movimentoConta, ContasCorrentes[] cadastro,
            ContasAtualizadas[] dadosAt) {
		int i = 0;
                while (i < dadosAt.length) {
                int j = 0;
		boolean flag=false;
		while (j < movimentoConta.length) {
                    if (cadastro[i].codigoConta == movimentoConta[j].codigoContaM) {
			flag=true;
			dadosAt[i].codigoContaA = movimentoConta[j].codigoContaM;
			dadosAt[i].nomeClienteA = cadastro[i].nomeCliente;
			dadosAt[i].tipoContaA = cadastro[i].tipoConta;
			dadosAt[i].statusA = movimentoConta[j].statusMovimento;
                            if (dadosAt[i].statusA == 1) {
				dadosAt[i].limiteContaA = cadastro[i].limiteConta;
				dadosAt[i].saldoContaA = cadastro[i].saldoConta + movimentoConta[j].valorMovimento;
				j++;
                            } else if (cadastro[i].saldoConta < movimentoConta[j].valorMovimento) {
                               dadosAt[i].limiteContaA = verificaLimite(cadastro, movimentoConta, i, dadosAt, j);
                               dadosAt[i].saldoContaA = 0.0;
                		j++;
                            } else {
                                dadosAt[i].limiteContaA = verificaLimite(cadastro, movimentoConta, i, dadosAt, j);
				dadosAt[i].saldoContaA = verificaSaldo(cadastro, movimentoConta, i, dadosAt, j);
				j++;
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
		if (movimentoConta[j].tipoMovimento == 1) {
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
		}
		return dadosAt[i].limiteContaA;
	}
	double verificaSaldo(ContasCorrentes[] cadastro, MovimentacaoContas[] movimentoConta, int i,
			ContasAtualizadas[] dadosAt, int j) {
		return cadastro[i].saldoConta - movimentoConta[j].valorMovimento;
	}
}