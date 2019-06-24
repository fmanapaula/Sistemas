
public class MovimentacaoContas {
	int codigoContaM;
	double valorMovimento;
	int tipoMovimento;
	int statusMovimento;
	
	MovimentacaoContas(){
		this(0, 0.0, 0, 0);
		
	}
	MovimentacaoContas(int codigoContaM, double valorMovimento, int tipoMovimento, int statusMovimento){
		this.codigoContaM=codigoContaM;
		this.valorMovimento=valorMovimento;
		this.tipoMovimento=tipoMovimento;
		this.statusMovimento=statusMovimento;
	}
}