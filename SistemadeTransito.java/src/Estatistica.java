class Estatistica {

    int Cod_cid;
    String Nome_cid;
    int Qtd_Aci;
    int Tip_Veic;
    
 Estatistica()
 {
     this(0 ,"" ,0 ,0);
 }
 
 
 Estatistica(int Cod_cidade,String Nome_cidade,int Qtd_acidentes,int Tip_veiculos)
    {
        Cod_cid = Cod_cidade;
        Nome_cid = Nome_cidade;
        Qtd_Aci = Qtd_acidentes;
        Tip_Veic = Tip_veiculos;
    }
    
}
