
public class ContasCorrentes {
	int codigoConta;
	String nomeCliente;
	double saldoConta;
	double limiteConta;
	int tipoConta;
	
	ContasCorrentes(){
		this(0, " ", 0.0, 0.0, 0);
	}
	ContasCorrentes(int codigoConta, String nomeCliente, double saldoConta, double limiteConta, int tipoConta){
		this.codigoConta=codigoConta;
		this.nomeCliente=nomeCliente;
		this.saldoConta=saldoConta;
		this.limiteConta=limiteConta;
		this.tipoConta=tipoConta;
	}
}
