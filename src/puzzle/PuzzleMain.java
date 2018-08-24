/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        
/**
 *
 * @author root
 */
public class PuzzleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	/**
	 * @param  args
	 */
        boolean setheuristica = false; //Se essa variável é false, a heuristica que vale é  pedras fora do lugar, se essa variável é true, a heurística que 
        //vale é a Manhatan. 
        int indice = 0;
        List<NoFronteira> ListaNoFronteira = new ArrayList<NoFronteira>(); List<NoSelecionado> ListaNoSelecionado = new ArrayList<NoSelecionado>();
        AEstrela aestrela = new AEstrela();
        int [] vetorTeste = {0, 1, 2, 3, 4, 5, 6, 7, 8}; int heuristica = 0; int custo = 0; int index = 0; int [] vec = new int[12];
        int [] soma; int ind = 0; int idproximo = 0; int [][] matrizNoSelecionados = new int[1][12]; int [][] matrizNoFronteira = new int[1][12];
        int [] vetorNoEmAnalise = new int[12]; int contador = 0; int indiceListaNoFronteira = 0; int tam = 0;
        int qtdnofronteira = 0; int qtdnoselecionado = 0; boolean existe = false; long tempoinicial = System.currentTimeMillis();
        Scanner ler = new Scanner(System.in);
        aestrela.CarregaPadrao(vetorTeste);
        NoSelecionado primeiroNo = new NoSelecionado();
        primeiroNo.CarregaVariaveisPrimeiraLinha(2, 3, 1);
        primeiroNo.CarregaVariaveisSegundaLinha(4, 5, 8);
        primeiroNo.CarregaVariaveisTerceiraLinha(6, 7, 0);
        primeiroNo.CarregaCustoHeuristica(0, 0);
        primeiroNo.CarregaIr(0);
        ListaNoSelecionado.add(primeiroNo);     
        System.out.println("SELECIONE A HEURÍSTICA - 1 : HEURÍSTICA FORA DO LUGAR, 2 : HEURÍSTICA MANHATTAN");
        int n = ler.nextInt();
        if(n == 1)
            setheuristica = false;
        if(n == 2)
            setheuristica = true;
        
        while(true) {
            System.out.println("%%%%%%%%%%% INTERAÇÃO NÚMERO:" + contador + " %%%%%%%%%%%%%%%%%%%%%%%");
            NoSelecionado noselecionado = new NoSelecionado();
            indice = (ListaNoSelecionado.size())-1;
            noselecionado = ListaNoSelecionado.get(indice);
            int[] no = noselecionado.RetornaNo();
            aestrela.VerificaZero(aestrela.CarregaVetor(no));
            aestrela.InstanciaCriancaNo();
            aestrela.DefineNosCriancas(); 
            if(aestrela.Teste(aestrela.ConvertMatrizVetor(no))){
                    System.out.println(" ");
                    System.out.println("SOLUÇÃO ENCONTRADA !!! :) :)");
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%% NÓS NA FRONTEIRA");
                    tam = ListaNoFronteira.size();
                    qtdnofronteira = tam;   
                     for(int i = 0; i < tam; i++){
                           NoFronteira nf = new NoFronteira();
                            System.out.print("IND:" + i + " %- ");
                            nf = ListaNoFronteira.get(i);
                            vec = nf.RetornaNo();
                            aestrela.ImprimeVetor(vec, false);
                            int s = vec[9]+vec[10];
                            System.out.print("SOMA C + H: "+ s);
                            System.out.println(" Função Ir(Esse Estado): " + vec[11]);
                     }            
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%% NÓS SELECIONADOS");
                    tam = ListaNoSelecionado.size();
                    qtdnoselecionado = tam; 
                    for(int i = 0; i < tam; i++){
                        NoSelecionado ne = new NoSelecionado();
                        System.out.print("IND:" + i + " %- ");
                        ne = ListaNoSelecionado.get(i);
                        vec = ne.RetornaNo();
                        aestrela.ImprimeVetor(vec, false);
                        int s = vec[9]+vec[10];
                        System.out.print("SOMA C + H: "+ s);
                        System.out.println(" Função Ir(Esse Estado): " + vec[11]);
                        ne = null;
                    }
                    
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%% SOLUÇÃO");
                    matrizNoSelecionados = null;
                    matrizNoSelecionados = new int[tam][13];
                    
                    for(int i = 0; i< tam; i++){
                        NoSelecionado ne = new NoSelecionado();
                        ne = ListaNoSelecionado.get(i);
                        vec = ne.RetornaNo();
                        for(int j = 0; j<13 ; j++){
                           if(j == 0)
                                matrizNoSelecionados[i][j] = i;
                           else if(j >= 1)
                               matrizNoSelecionados[i][j] = vec[j-1];
                        }
                        idproximo++;
                    }
                    idproximo = idproximo -1; 
                    int [] NoSequencia = new int [13];
                    while(true){
                        NoSequencia = aestrela.Ir(matrizNoSelecionados, idproximo, tam);
                        System.out.print("IND:" + idproximo + " %- ");
                        aestrela.ImprimeVetorCasoEspecifico(NoSequencia);
                        int s = NoSequencia[9]+NoSequencia[10];
                        System.out.print("SOMA C + H: "+ s);
                        System.out.println(" Função Ir(Esse Estado): " + NoSequencia[12]);
                        if(idproximo == 0){
                            break;
                        }
                        idproximo = NoSequencia[12];
                    }
                    
               
                    break;
            }
            //CRIANCA 01
            int [][] matriz = aestrela.retornaCriancano01();
            if(setheuristica == true)
                heuristica = aestrela.HeuristicaManh(matriz);
            if(setheuristica == false)
                heuristica = aestrela.HeuristicaForaPosicao(matriz);
            custo = aestrela.Custo(no[9]);
            index = ListaNoSelecionado.size();
            if(contador != 0 ){        
                vetorNoEmAnalise = aestrela.RetornaVetor(aestrela.retornaCriancano01());
                existe = aestrela.AvaliaSeTemNoSelecionados(vetorNoEmAnalise, matrizNoSelecionados, index); 
            }
            if((heuristica != 1000))
            {  
                if(existe != true){
                    NoFronteira nofronteira01 = new NoFronteira();
                    nofronteira01.CarregaVariaveisPrimeiraLinha(matriz[0][0], matriz[0][1], matriz[0][2]);
                    nofronteira01.CarregaVariaveisSegundaLinha(matriz[1][0], matriz[1][1], matriz[1][2]);
                    nofronteira01.CarregaVariaveisTerceiraLinha(matriz[2][0], matriz[2][1], matriz[2][2]);
                    nofronteira01.CarregaCustoHeuristica(custo, heuristica);
                    nofronteira01.CarregaIr(index-1);
                    ListaNoFronteira.add(nofronteira01);
                    nofronteira01 = null; 
                 }
            } 
            existe = false;
            //CRIANCA 02
            matriz = aestrela.retornaCriancano02();
            if(setheuristica == true)
                heuristica = aestrela.HeuristicaManh(matriz);
            if(setheuristica == false)
                heuristica = aestrela.HeuristicaForaPosicao(matriz);            
            custo = aestrela.Custo(no[9]);
            if(contador != 0 ){            
                vetorNoEmAnalise = aestrela.RetornaVetor(aestrela.retornaCriancano02());
                existe = aestrela.AvaliaSeTemNoSelecionados(vetorNoEmAnalise, matrizNoSelecionados, index);
            }
            if((heuristica != 1000) )
            {   
               if (existe != true)
               {    NoFronteira nofronteira02 = new NoFronteira();
                    nofronteira02.CarregaVariaveisPrimeiraLinha(matriz[0][0], matriz[0][1], matriz[0][2]);
                    nofronteira02.CarregaVariaveisSegundaLinha(matriz[1][0], matriz[1][1], matriz[1][2]);
                    nofronteira02.CarregaVariaveisTerceiraLinha(matriz[2][0], matriz[2][1], matriz[2][2]);
                    nofronteira02.CarregaCustoHeuristica(custo, heuristica);
                    nofronteira02.CarregaIr(index-1);
                    ListaNoFronteira.add(nofronteira02);
                    nofronteira02 = null;
                }
            } 
            existe = false;

            //CRIANÇA 03
            matriz = aestrela.retornaCriancano03();
            if(setheuristica == true)
                heuristica = aestrela.HeuristicaManh(matriz);
            if(setheuristica == false)
                heuristica = aestrela.HeuristicaForaPosicao(matriz); 
            custo = aestrela.Custo(no[9]);
            if(contador != 0 ){
                vetorNoEmAnalise = aestrela.RetornaVetor(aestrela.retornaCriancano03());
            }
            if((heuristica != 1000))
            {   
                if(existe != true)
                {
                    NoFronteira nofronteira03 = new NoFronteira();
                    nofronteira03.CarregaVariaveisPrimeiraLinha(matriz[0][0], matriz[0][1], matriz[0][2]);
                    nofronteira03.CarregaVariaveisSegundaLinha(matriz[1][0], matriz[1][1], matriz[1][2]);
                    nofronteira03.CarregaVariaveisTerceiraLinha(matriz[2][0], matriz[2][1], matriz[2][2]);
                    nofronteira03.CarregaCustoHeuristica(custo, heuristica);
                    nofronteira03.CarregaIr(index-1);
                    ListaNoFronteira.add(nofronteira03);
                    nofronteira03 = null;
                }
            } 
            existe = false;

            //CRIANÇA 04
            matriz = aestrela.retornaCriancano04();
            if(setheuristica == true)
                heuristica = aestrela.HeuristicaManh(matriz);
            if(setheuristica == false)
                heuristica = aestrela.HeuristicaForaPosicao(matriz);            
            custo = aestrela.Custo(no[9]);
            if(contador != 0 ){
                vetorNoEmAnalise = aestrela.RetornaVetor(aestrela.retornaCriancano04());
                existe = aestrela.AvaliaSeTemNoSelecionados(vetorNoEmAnalise, matrizNoSelecionados, index);
            }    
            if((heuristica != 1000))
            {   
                if((existe != true))
                {
                    NoFronteira nofronteira04 = new NoFronteira();
                    nofronteira04.CarregaVariaveisPrimeiraLinha(matriz[0][0], matriz[0][1], matriz[0][2]);
                    nofronteira04.CarregaVariaveisSegundaLinha(matriz[1][0], matriz[1][1], matriz[1][2]);
                    nofronteira04.CarregaVariaveisTerceiraLinha(matriz[2][0], matriz[2][1], matriz[2][2]);
                    nofronteira04.CarregaCustoHeuristica(custo, heuristica);
                    nofronteira04.CarregaIr(index-1);
                    ListaNoFronteira.add(nofronteira04);
                    nofronteira04 = null;
                 
                }
            }
            existe = false;
          
            NoFronteira nof;
            indiceListaNoFronteira = ListaNoFronteira.size();
            matrizNoFronteira = null;
            matrizNoFronteira = new int[indiceListaNoFronteira][12];
           
            for(int i = 0; i< indiceListaNoFronteira; i++){
               nof = ListaNoFronteira.get(i);
               vec = nof.RetornaNo();
               for(int j = 0; j<12; j++){
                   matrizNoFronteira[i][j] = vec[j];
               }
            }
       
            soma = new int[indiceListaNoFronteira];
            matrizNoSelecionados = null;         
            for(int i = 0; i < indiceListaNoFronteira ; i++){
               nof = ListaNoFronteira.get(i);
               vec = nof.RetornaNo();
               vec = aestrela.RetornaVetorIndiceFixo(matrizNoFronteira, i);
               soma[i] = aestrela.SomaHeuristicaCusto(vec[9], vec[10]);
            }
            ind = aestrela.VerificaMenor(soma, indiceListaNoFronteira);
            nof = null;
            ListaNoFronteira.clear();
            for(int i = 0; i< indiceListaNoFronteira; i++){
                nof = new NoFronteira();
                nof.CarregaVariaveisPrimeiraLinha(matrizNoFronteira[i][0], matrizNoFronteira[i][1], matrizNoFronteira[i][2]);
                nof.CarregaVariaveisSegundaLinha(matrizNoFronteira[i][3], matrizNoFronteira[i][4], matrizNoFronteira[i][5]);
                nof.CarregaVariaveisTerceiraLinha(matrizNoFronteira[i][6], matrizNoFronteira[i][7], matrizNoFronteira[i][8]);
                nof.CarregaCustoHeuristica(matrizNoFronteira[i][9], matrizNoFronteira[i][10]);
                nof.CarregaIr(matrizNoFronteira[i][11]);
                ListaNoFronteira.add(nof);
                nof=null;
            }
            nof = ListaNoFronteira.get(ind);
            vec = nof.RetornaNo();
            NoSelecionado noe = new NoSelecionado();
            noe.CarregaVariaveisPrimeiraLinha(vec[0], vec[1], vec[2]);
            noe.CarregaVariaveisSegundaLinha(vec[3], vec[4], vec[5]);
            noe.CarregaVariaveisTerceiraLinha(vec[6], vec[7], vec[8]);
            noe.CarregaCustoHeuristica(vec[9], vec[10]);
            noe.CarregaIr(vec[11]);
            ListaNoSelecionado.add(noe);
            nof = null;
            ListaNoFronteira.remove(ind);
            NoFronteira nof02 = new NoFronteira();          
            index = ListaNoSelecionado.size();
            matrizNoSelecionados = new int[index][12];
            for(int i = 0; i< index; i++){
                noe = ListaNoSelecionado.get(i);
                vec = noe.RetornaNo();
                for(int j = 0; j< 12; j++ ){
                    matrizNoSelecionados[i][j] = vec[j]; 
                }
            }
           contador++;
         
        }
        tam = ListaNoFronteira.size();
        qtdnofronteira = tam;          
        tam = ListaNoSelecionado.size();
        qtdnoselecionado = tam;
        int qtdtotal = qtdnofronteira+qtdnoselecionado; 
        long tempofinal = System.currentTimeMillis();
        long tempo = tempofinal - tempoinicial;
        System.out.println("QUANTIDADE TOTAL DE NÓS EM MEMÓRIA: "+qtdtotal);
        System.out.println("TEMPO TOTAL DE EXECUÇÃO DO ALGORITMO (mili-segundos): "+  tempo);
        System.out.println("QUANTIDADE DE NÓS NA FRONTEIRA: "+ qtdnofronteira);
        System.out.println("QUANTIDADE DE NÓS SELECIONADOS: "+ qtdnoselecionado);
        
     
    }
    
}
