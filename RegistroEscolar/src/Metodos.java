
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Metodos{
 public Aluno[] CadastraAluno(Aluno[]aluno) throws IOException{
  int i;	
  String fileName = "ArquivoAluno.txt";	
  
  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName ));
  
  for (i = 0 ; i < 3 ; i++)	
   aluno[i] = new Aluno();
	
  for (i = 0 ; i < 3 ; i++)
   {	
   aluno[i].pnome = JOptionPane.showInputDialog("Entre com o nome do aluno:");	
   writer.write( aluno[i].pnome );  	
   writer.newLine();	
   aluno[i].unome = JOptionPane.showInputDialog("Entre com o sobrenome do aluno:");	
   writer.write( aluno[i].unome );  	
   writer.newLine();	
   aluno[i].pontos = Integer.parseInt(JOptionPane.showInputDialog("Pontos de Graduação do aluno:"));	
   writer.write(Integer.toString(aluno[i].pontos));   	
   writer.newLine();	

   }	
  	
  for (i = 0 ; i < 3; i++) {	
   System.out.println(aluno[i].pnome + " " + aluno[i].unome + " pontos: " + aluno[i].pontos);	
  }
  writer.close();	
  return aluno;
    }

public void LerAluno(Aluno[]aluno)throws IOException{
    int i,ptos;	
  String fileName = "ArquivoAluno.txt";	
	
  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	

  for (i = 0 ; i < 3 ; i++)	
   aluno[i] = new Aluno();
	
  for (i = 0 ; i < 3 ; i++)
   {	
    aluno[i].pnome = ler.readLine();  	
    aluno[i].unome = ler.readLine();	
    aluno[i].pontos = Integer.parseInt(ler.readLine());	
   }	
  	
  for (i = 0 ; i < 3; i++) {	
   System.out.println(aluno[i].pnome + " " + aluno[i].unome + " pontos: " + aluno[i].pontos);	
  }
  ler.close();	

}

}
        
        
        
    
    