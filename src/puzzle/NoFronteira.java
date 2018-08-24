/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

/**
 *
 * @author root
 */
public class NoFronteira {
    
    int posicao00;
    int posicao01;
    int posicao02;
    int posicao10;
    int posicao11;
    int posicao12;
    int posicao20;
    int posicao21;
    int posicao22; 
    int Custo;
    int Heuristica;
    int indice;
    
    public void CarregaVariaveisPrimeiraLinha(int posicao00, int posicao01, int posicao02)
    { 
        this.posicao00 = posicao00;
        this.posicao01 = posicao01;
        this.posicao02 = posicao02;
    }
    
    public void CarregaVariaveisSegundaLinha(int posicao10, int posicao11, int posicao12)
    { 
        this.posicao10 = posicao10;
        this.posicao11 = posicao11;
        this.posicao12 = posicao12;
    }
    
    public void CarregaVariaveisTerceiraLinha(int posicao20, int posicao21, int posicao22)
    { 
        this.posicao20 = posicao20;
        this.posicao21 = posicao21;
        this.posicao22 = posicao22;
    }
    
    public void CarregaCustoHeuristica(int Custo, int Heuristica){
        this.Custo = Custo;
        this.Heuristica = Heuristica;
    }
    
    public void CarregaIr(int indice){
        this.indice = indice;
    }
    
    public int[] RetornaNo(){
        int [] No = new int[12];
        No[0] = this.posicao00;
        No[1] = this.posicao01;
        No[2] = this.posicao02;
        No[3] = this.posicao10;       
        No[4] = this.posicao11;
        No[5] = this.posicao12;
        No[6] = this.posicao20;
        No[7] = this.posicao21;
        No[8] = this.posicao22;
        No[9] = this.Custo;
        No[10] = this.Heuristica;
        No[11] = this.indice;
        
        return No;
   }    

}
