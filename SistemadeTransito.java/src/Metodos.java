import javax.swing.JOptionPane;
class Metodos{
public Estatistica[] CadastraEstatistica(Estatistica[]estatistica){
    for(int i=0; i<estatistica.length; i++)
        estatistica[i]= new Estatistica();
    
    
    for(int i = 0;i<estatistica.length;i++){
        estatistica[i].Cod_cid = 1+(int)(Math.random()* 4);
        estatistica[i].Nome_cid = JOptionPane.showInputDialog("insira o nome da cidade");
        estatistica[i].Qtd_Aci = (int)(Math.random()* 500);
        estatistica[i].Tip_Veic = 1+(int)(Math.random()* 4);
}
    return estatistica;
}

public void ConsultaVeiculo(Estatistica[]estatistica){
    int r;
    JOptionPane.showMessageDialog(null,"1 - Automovel \n2 - Transporte Coletivo \n3 - Moto \n4 - Veiculo de Carga");
    r = Integer.parseInt(JOptionPane.showInputDialog("Escolha o Tipo de veiculo"));
    for (int i = 0;i < estatistica.length;i++){
        if(estatistica[i].Tip_Veic == r){
            JOptionPane.showMessageDialog(null,"" + estatistica[i].Tip_Veic +" "+estatistica[i].Cod_cid +" "+estatistica[i].Nome_cid);
        }    
    }    
}
public void QuantidadeAcidentes(Estatistica[]estatistica){
    //int r;
    //r = (int)(Math.random()*500);
    for (int i = 0; i < estatistica.length;i++){
        if (estatistica[i].Qtd_Aci > 100 && estatistica[i].Qtd_Aci < 500){
            JOptionPane.showMessageDialog(null,"A Quantidade de Acidentes é:"+estatistica[i].Qtd_Aci+ " "+estatistica[i].Nome_cid);
        }
    }
    
}
public void ConsultaCidades(Estatistica[]estatistica){
 for (int i = 0; i < estatistica.length;i++){
     JOptionPane.showMessageDialog(null,estatistica[i].Cod_cid +""+estatistica[i].Nome_cid+""+estatistica[i].Qtd_Aci);
    
}
}
public void ConsultaMedia(Estatistica[]estatistica){
    int j=0,i,k=0;
    Estatistica[] auxiliar = new Estatistica[15];
    Estatistica [] r = new Estatistica [1];
    for (i = 0;i < estatistica.length;i++){
        for(j = i+1 ;j < auxiliar.length;j++){
                if (estatistica[i].Qtd_Aci > auxiliar[j].Qtd_Aci){
                    r[k] = auxiliar[j];
                    auxiliar[j] = estatistica[i];
                    estatistica[i]= r[k];
                }    
        }
    }
    JOptionPane.showMessageDialog(null,"O Maior Valor é: "+estatistica[j].Qtd_Aci +"/n O menor valor é: "+auxiliar[0].Qtd_Aci);
}    

}


