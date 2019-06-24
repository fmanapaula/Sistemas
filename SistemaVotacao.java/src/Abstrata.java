public class Abstrata {
    int num_candidato;
    int num_secao;
	
    Abstrata(){
	this(0, 0);		
    }
    Abstrata(int num_candidato, int num_secao){
	this.num_candidato=num_candidato;
	this.num_secao=num_secao;
    }
}