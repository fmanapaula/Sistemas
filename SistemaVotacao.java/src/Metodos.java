import java.util.Arrays;

public class Metodos {
   public void maiorMenor(int vetor[]) {

		int max = vetor[0], min = vetor[0];
		int index = 1, index2 = 1;
		for (int i = 0; i < vetor.length; i++) {
                    if (vetor[i] > max) {
			max = vetor[i];
			index = (i + 1);
                    } else if (vetor[i] < min) {
			min = vetor[i];
			index2 = (i + 1);
                    }
		}
		System.out.println("A sessão com a maior quantidade de votos foi a de número: " + index + "\nE a que teve a menor quantidade de votos foi a: " + index2);
	}
	public void quantidadeEleitor(int vetor[]) {
		System.out.println("Quantidade de eleitores por sessão:\n" + Arrays.toString(vetor));
	}

	public void quantidadeVotos(int anotherVetor[]) {
		System.out.println("Quantidade de votos por candidato:\n" + Arrays.toString(anotherVetor));
	}

	void maisVotados(int vt[]) {
		int auxvetor[] = vt.clone();
		vt = auxiliar(vt);
		System.out.println("teste"+Arrays.toString(vt));
		
		int index = 0;
		int m = 1;
		int j = vt.length - 1;
		int verify = 0;
		while (m <= 10) {

	for (int i = 0; i < auxvetor.length; i++) {
	if (auxvetor[i] == vt[j]) {
            if (verify != auxvetor[i]) {
		verify = auxvetor[i];
                index = i;
		break;
            } else if (verify == auxvetor[i] && i > index) {
                index = i;
		break;
            }
	}		
    }
        System.out.println("numero do candidato= " + (index + 1) + "\nquantidade de votos= " + vt[j]);
	j--;
	m++;
		}
	}

	int[] auxiliar(int vetor[]) {
		for (int i = 0; i < vetor.length - 1; i++) {
                    for (int j = 0; j < vetor.length - 1 - i; j++) {
                        if (vetor[j] > vetor[j + 1]) {
                            int temp = vetor[j];
				vetor[j] = vetor[j + 1];
				vetor[j + 1] = temp;
                        }
                    }
		}
		return vetor;
	}
}