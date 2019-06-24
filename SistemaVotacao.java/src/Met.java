import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class Met {

    Abstrata[] cadastroGeral(Abstrata[] obj) {
        for (int j = 0; j < obj.length; j++) {
            obj[j] = new Abstrata();
        }
        for (int i = 0; i < obj.length; i++) {
            obj[i].num_candidato = 1 + (int) (Math.random() * 300);
            obj[i].num_secao = 1 + (int) (Math.random() * 10);
        }
        return obj;
    }

    int[] classificaSecao(Abstrata[] obj, int vetor[]) {
        for (int i = 0; i < obj.length; i++) {
            vetor[obj[i].num_secao - 1]++;
        }
        return vetor;
    }

    int[] classificaCandidatos(Abstrata[] obj, int vetor[]) {
        for (int i = 0; i < obj.length; i++) {
            vetor[obj[i].num_candidato - 1]++;
        }
        return vetor;
    }

    Abstrata[] gravarDados(Abstrata[] obj) throws IOException {
        String filename = "ArquivoVotacao2018.txt";
        BufferedWriter escreva = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < obj.length; i++) {
            escreva.write(Integer.toString(obj[i].num_candidato));
            escreva.newLine();
            escreva.write(Integer.toString(obj[i].num_secao));
            escreva.newLine();
        }
        escreva.close();
        return obj;
    }

}