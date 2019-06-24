
public class Sort {
	ContasCorrentes[] justSort(ContasCorrentes[] cadastro) {
		ContasCorrentes[] temp = new ContasCorrentes[1];
		temp[0] = new ContasCorrentes();

		for (int i = 0; i < cadastro.length - 1; i++) {

			for (int j = 0; j < cadastro.length - 1 - i; j++) {

				if (cadastro[j].codigoConta > cadastro[j + 1].codigoConta) {
					temp[0] = cadastro[j];
					cadastro[j] = cadastro[j + 1];
					cadastro[j + 1] = temp[0];
				}
			}

		}
		return cadastro;
	}

	MovimentacaoContas[] justSortTwo(MovimentacaoContas[] movimentoConta) {
		MovimentacaoContas[] temp = new MovimentacaoContas[1];
		temp[0] = new MovimentacaoContas();

		for (int i = 0; i < movimentoConta.length - 1; i++) {

			for (int j = 0; j < movimentoConta.length - 1 - i; j++) {

				if (movimentoConta[j].codigoContaM > movimentoConta[j + 1].codigoContaM) {
					temp[0] = movimentoConta[j];
					movimentoConta[j] = movimentoConta[j + 1];
					movimentoConta[j + 1] = temp[0];
				}
			}

		}
		return movimentoConta;
	}
}
