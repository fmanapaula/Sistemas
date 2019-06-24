
public class ContasAtualizadas {
	int codigoContaA;
	String nomeClienteA;
	double limiteContaA;
	int tipoContaA;
	int statusA;
	double saldoContaA;
	
	ContasAtualizadas(){
		this(0, "", 0.0, 0, 0, 0.0);
	}
	
	ContasAtualizadas(int codigoContaA, String nomeClienteA, double limiteContaA, int tipoContaA, int statusA, double saldoContaA){
		this.codigoContaA=codigoContaA;
		this.nomeClienteA=nomeClienteA;
		this.limiteContaA=limiteContaA;
		this.tipoContaA=tipoContaA;
		this.statusA=statusA;
		this.saldoContaA= saldoContaA;
		
	}
	
}

