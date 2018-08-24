/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.Random;

/**
 *
 * @author root
 */
public class AEstrela {
    private int[][] padrao = new int[3][3];
    private int[][] no = new int[3][3];
    private int [][] criancano01 = new int[3][3];
    private int [][] criancano02 = new int[3][3];
    private int [][] criancano03 = new int[3][3];
    private int [][] criancano04 = new int[3][3];    
    int [] menores_valores;
    
    public void ImprimeMatriz(int[][]matriz){
        for (int i = 0; i<3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public void ImprimeMatrizIndicesVariaveis(int[][]matriz, int x, int y){
        for (int i = 0; i<x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public void ImprimeVetor(int [] vet, boolean setln){
        if(setln == false){
            for(int i = 0; i<11;i++){
                System.out.print(vet[i]+" ");
            }
        }
        if(setln == true){
            for(int i = 0; i<11;i++){
                System.out.print(vet[i]+" ");
            }
            System.out.println(" ");
        }
    }
    public void ImprimeVetorCasoEspecifico(int [] vet){
           for(int i = 1; i<11;i++){
                if(i != 10)
                    System.out.print(vet[i]+" ");
                if(i == 10){
                    int var = vet[i]+1;
                    System.out.print( "passo >"+var+ " ");
                }
            }
    }
    public void ImprimeVetorIndice(int [] vet, boolean setln, int indice){
        if(setln == false){
            for(int i = 1; i<indice;i++){
                System.out.print(vet[i]+" ");
            }
        }
        if(setln == true){
            for(int i = 0; i<indice;i++){
                System.out.print(vet[i]+" ");
            }
            System.out.println(" ");
        }
    }
    public void RecebePadrao(int[][] padrao){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                this.padrao[i][j] = padrao[i][j];
            }
        }
    }
    public boolean VerificaZero (int[][] matriz){
        int cont = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(matriz[i][j] == 0){
                  cont++;  
                }
            }
        }
        
        if(cont == 9 ){
            return true;
        }
        return false;
    }
    public int [][] CarregaVetor(int [] vet){
         int index=0;
         for(int i = 0; i<3; i++){
             for(int j = 0; j<3; j++){
                 this.no[i][j] = vet[index];
                 index++;
             }
         }
         return this.no;
    }
    public void CarregaPadrao (int [] vet){
         int index=0;
         for(int i = 0; i<3; i++){
             for(int j = 0; j<3; j++){
                 this.padrao[i][j] = vet[index];
                 index++;
             }
         }
     }
    public void InstanciaCriancaNo(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++){
                this.criancano01[i][j] = 0;
                this.criancano02[i][j] = 0;
                this.criancano03[i][j] = 0;
                this.criancano04[i][j] = 0;
                
            }
        }
    } 
    public void DefineNosCriancas(){
        int [][] no = new int[3][3];
        int [][] criancano01 = new int[3][3];
        int [][] criancano02 = new int[3][3];
        int [][] criancano03 = new int[3][3];
        int [][] criancano04 = new int[3][3];
        
        for(int i = 0; i< 3; i++ ){
            for(int j = 0; j< 3; j++){
                no[i][j] = this.no[i][j];
            }
        }
        
        if(no[0][0] == 0){
            criancano01[0][0] = no[0][1];
            criancano01[0][1] = no[0][0];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[1][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[0][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
//            criancano03 = null; 
            
  //          criancano04 = null;
        }
        if(no[0][1] == 0){
            criancano01[0][0] = no[0][1];
            criancano01[0][1] = no[0][0];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][2];
            criancano02[0][2] = no[0][1];
            criancano02[1][0] = no[1][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
            criancano03[0][0] = no[0][0];
            criancano03[0][1] = no[1][1];
            criancano03[0][2] = no[0][2];
            criancano03[1][0] = no[1][0];
            criancano03[1][1] = no[0][1];
            criancano03[1][2] = no[1][2];
            criancano03[2][0] = no[2][0];
            criancano03[2][1] = no[2][1];
            criancano03[2][2] = no[2][2];

            
           // criancano04 = null;
        }
        if(no[0][2] == 0){
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[1][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[0][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][2];
            criancano02[0][2] = no[0][1];
            criancano02[1][0] = no[1][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
    //        criancano03 = null;
      //      criancano04 = null;
        }
        if(no[1][0] == 0){

            criancano01[0][0] = no[1][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[0][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[1][1];
            criancano02[1][1] = no[1][0];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
            criancano03[0][0] = no[0][0];
            criancano03[0][1] = no[0][1];
            criancano03[0][2] = no[0][2];
            criancano03[1][0] = no[2][0];
            criancano03[1][1] = no[1][1];
            criancano03[1][2] = no[1][2];
            criancano03[2][0] = no[1][0];
            criancano03[2][1] = no[2][1];
            criancano03[2][2] = no[2][2];

            
        //    criancano04 = null;
        }
        if(no[1][1] == 0){
            
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[1][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[0][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[1][1];
            criancano02[1][1] = no[1][0];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
            criancano03[0][0] = no[0][0];
            criancano03[0][1] = no[0][1];
            criancano03[0][2] = no[0][2];
            criancano03[1][0] = no[1][0];
            criancano03[1][1] = no[1][2];
            criancano03[1][2] = no[1][1];
            criancano03[2][0] = no[2][0];
            criancano03[2][1] = no[2][1];
            criancano03[2][2] = no[2][2];

            
            criancano04[0][0] = no[0][0];
            criancano04[0][1] = no[0][1];
            criancano04[0][2] = no[0][2];
            criancano04[1][0] = no[1][0];
            criancano04[1][1] = no[2][1];
            criancano04[1][2] = no[1][2];
            criancano04[2][0] = no[2][0];
            criancano04[2][1] = no[1][1];
            criancano04[2][2] = no[2][2];
        
        }
        if(no[1][2] == 0){
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][2];
            criancano01[1][2] = no[1][1];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[1][2];
            criancano02[1][0] = no[1][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[0][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
            criancano03[0][0] = no[0][0];
            criancano03[0][1] = no[0][1];
            criancano03[0][2] = no[0][2];
            criancano03[1][0] = no[1][0];
            criancano03[1][1] = no[1][1];
            criancano03[1][2] = no[2][2];
            criancano03[2][0] = no[2][0];
            criancano03[2][1] = no[2][1];
            criancano03[2][2] = no[1][2];

            
          //  criancano04 = null;
        }
        if(no[2][0] == 0){
            
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][1];
            criancano01[2][1] = no[2][0];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[2][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[1][0];
            criancano02[2][1] = no[2][1];
            criancano02[2][2] = no[2][2];
            
           // criancano03 = null;
            
          //  criancano04 = null;
        }
        if(no[2][1] == 0){
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[1][2];
            criancano01[2][0] = no[2][1];
            criancano01[2][1] = no[2][0];
            criancano01[2][2] = no[2][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[1][0];
            criancano02[1][1] = no[2][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[1][1];
            criancano02[2][2] = no[2][2];
            
            criancano03[0][0] = no[0][0];
            criancano03[0][1] = no[0][1];
            criancano03[0][2] = no[0][2];
            criancano03[1][0] = no[1][0];
            criancano03[1][1] = no[1][1];
            criancano03[1][2] = no[1][2];
            criancano03[2][0] = no[2][0];
            criancano03[2][1] = no[2][2];
            criancano03[2][2] = no[2][1];

            
           // criancano04 = null;

        }
        if(no[2][2] == 0){
            criancano01[0][0] = no[0][0];
            criancano01[0][1] = no[0][1];
            criancano01[0][2] = no[0][2];
            criancano01[1][0] = no[1][0];
            criancano01[1][1] = no[1][1];
            criancano01[1][2] = no[2][2];
            criancano01[2][0] = no[2][0];
            criancano01[2][1] = no[2][1];
            criancano01[2][2] = no[1][2];

            criancano02[0][0] = no[0][0];
            criancano02[0][1] = no[0][1];
            criancano02[0][2] = no[0][2];
            criancano02[1][0] = no[1][0];
            criancano02[1][1] = no[1][1];
            criancano02[1][2] = no[1][2];
            criancano02[2][0] = no[2][0];
            criancano02[2][1] = no[2][2];
            criancano02[2][2] = no[2][1];
            
          //  criancano03 = null;
         //   criancano04 = null;
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++ ){
                if(criancano01 != null){
                    this.criancano01[i][j] = criancano01[i][j]; 
                }
                else{
                    this.criancano01 = criancano01;
                }
                
                if(criancano02 != null){
                    this.criancano02[i][j] = criancano02[i][j];     
                }
                else{
                    this.criancano02 = criancano02;
                }
                
                if(criancano03 != null){
                    this.criancano03[i][j] = criancano03[i][j];     
                }
                else{
                    this.criancano03 = criancano03;
                }
                
                if(criancano04 != null){
                    this.criancano04[i][j] = criancano04[i][j];     
                } 
                else{
                    this.criancano04 = criancano04;
                }
            }
        }
    }
    public int[][] retornaCriancano01(){
        return this.criancano01;
    }
    public int[][] retornaCriancano02(){
        return this.criancano02;
    }
    public int[][] retornaCriancano03(){
        return this.criancano03;
    }
    public int[][] retornaCriancano04(){
        return this.criancano04;
    }
    public int Heuristica(int[][]matriz){
        boolean flag = false;
        int heuristica = 0;
        int cont = 0;
        int k = 0, l = 0;
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 3; j++){
                if(matriz[i][j] == 0){
                    cont++;
                }
            }
        }
        if(cont == 9 ){
            return 1000;
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(matriz[i][j]!= 0){
                    for(k = 0; k<3; k++){
                        for(l = 0; l<3; l++){
                            if(matriz[i][j] == this.padrao[i][k])
                            {
                                flag = true;
                            }
                            if(flag == true){
                                break;
                            }
                         }
                        if(flag == true){
                            break;
                        }
                    } 
                }
                flag = false;
                heuristica+=(mod(i-k)+mod(j-l));  
            }
        }
        return heuristica;
    }
    public int AnalisaDiferenca(int heuristica, int[][]matriz, int posicao_x, int posicao_y){
        int x = 0 ; 
        int y = 0;
        boolean flag = false;
        for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(matriz[i][j] == this.padrao[posicao_x][posicao_y]){
                        x = i;
                        y = j;
                        flag = true;
                        break;
                    }
                    if(flag == true){
                        break;
                    }
                }
                if(flag == true){
                        break;
                }
            }
        heuristica = mod(posicao_x - x) + mod(posicao_y - y) + heuristica;
        return heuristica;
         
    }
    public int HeuristicaManh(int[][]matriz){
        int heuristica = 0;
        int cont = 0;
        for(int i = 0; i< 3; i++){
            for(int j = 0; j < 3; j++){
                if(matriz[i][j] == 0){
                    cont++;
                }
            }
        }
        if(cont != 9 )
        {
            if(matriz[0][0] != this.padrao[0][0]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 0, 0);
            }
            if(matriz[0][1] != this.padrao[0][1]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 0, 1);
            }
            if(matriz[0][2] != this.padrao[0][2]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 0, 2);
            }
            if(matriz[1][0] != this.padrao[1][0]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 1, 0);
            }
            if(matriz[1][1] != this.padrao[1][1]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 1, 1);
            }
            if(matriz[1][2] != this.padrao[1][2]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 1, 2);
            }
            if(matriz[2][0] != this.padrao[2][0]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 2, 0);
            }
            if(matriz[2][1] != this.padrao[2][1]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 2, 1);
            }
            if(matriz[2][2] != this.padrao[2][2]){
                heuristica = AnalisaDiferenca(heuristica, matriz, 2, 2);
            }
        }
        else{
            heuristica = 1000;
        }
        return heuristica;
    }
    public int HeuristicaForaPosicao(int[][] matriz){
        int heuristica = 0;
        if(matriz[0][0] != 0){
            heuristica = heuristica + 1;
        }
        if(matriz[0][1] != 1){
            heuristica = heuristica+1;
        }
        if(matriz[0][2] != 2){
            heuristica = heuristica+1;
        }
        if(matriz[1][0] != 3){
            heuristica = heuristica + 1;
        }
        if(matriz[1][1] != 4){
            heuristica = heuristica+1;
        }
        if(matriz[1][2] != 5){
            heuristica = heuristica+1;
        }
        if(matriz[2][0] != 6){
            heuristica = heuristica + 1;
        }
        if(matriz[2][1] != 7){
            heuristica = heuristica+1;
        }
        if(matriz[2][2] != 8){
            heuristica = heuristica+1;
        }
        return heuristica;
    }
    public int mod(int a){
        if(a >= 0){
            return a;
        }
        else{
            return -1*a;
        }
    }
    public int Custo(int custo){
        return custo+1;
    }
    public int SomaHeuristicaCusto(int heuristica, int custo){
        return (custo + heuristica);
    }
    public int VerificaMenor(int[] soma, int indice){
        int menor = soma[0];
        int resp = 0;
        int contaigual = 0;
        int [] armazenaindice = new int[indice];
        for(int k = 0; k<indice; k++){
                    armazenaindice[k] = 0;
        }
        for(int i = 0; i < indice ;i++){
            if(soma[i] < menor){
                menor = soma[i];
                resp = i;
                for(int k = 0; k<indice; k++){
                    armazenaindice[k] = 0;
                }
                contaigual = 0;
            }
            if(soma[i] == menor){
                    armazenaindice[contaigual] = i;
                    contaigual++;
            }
          
        }
       // System.out.println(" VETOR INDICES REPITIDOS E MENORES");
       // ImprimeVetorIndice(armazenaindice, true, indice);
        if(contaigual > 1){
            Random rdm = new Random();
            while(true){
                resp = armazenaindice[rdm.nextInt(contaigual)];
              //  System.out.println(" ");
              //  System.out.println(resp);
                if(resp != 0){
                    break;
                }
            }
        }
        return resp;
    }
    public boolean Teste(int [][] matriz1){
        int c = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++){
                if(matriz1[i][j] == this.padrao[i][j]){
                    c++;
                }
            }
        }
        if(c == 9){
            return true;
        }
        else {
            return false;
        }
    }   
    public int[] RetornaVetor(int [][]Matriz){
        int vet[] = new int[11];
        int cont = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                vet[cont] = Matriz[i][j];
                cont++;
            }
        }
        return vet;
    }
    public int[] RetornaVetorIndiceFixo(int [][]Matriz, int indice){
        int [] vec = new int[11];
        for(int i = 0; i<11; i++){
            vec[i] = Matriz[indice][i];
        }
        return vec;
    }
    public boolean AvaliaSeTemNoSelecionados(int []vetor, int [][]matriz, int indice){
        boolean retorno = false;
        for(int i = 0; i<indice;i++){
            if(vetor[0] == matriz[i][0]){
                 if(vetor[1] == matriz[i][1]){
                      if(vetor[2] == matriz[i][2]){
                         if(vetor[3] == matriz[i][3]){
                             if(vetor[4] == matriz[i][4]){
                                 if(vetor[5] == matriz[i][5]){
                                     if(vetor[6] == matriz[i][6]){
                                         if(vetor[7] == matriz[i][7]){
                                             if(vetor[8] == matriz[i][8]){   
                                                         retorno = true;
                                             }
                                         }
                                     }
                                 }
                             }
                         }
                      }
                  }
              }

        }
        return retorno;
    }
    public int[][] ConvertMatrizVetor(int []vetor){
        int [][] matriz = new int[3][3];
        int cont = 0;
        int i = 0;
        int j = 0;
        for(i = 0; i<3; i++){
            for(j = 0; j<3; j++){
                matriz[i][j] = vetor[cont];     
                cont++;
            }
        }
        return matriz;
    }
    public int[] Ir(int[][] matriz, int indice, int tam){
        int[] no = new int[13];
        for(int i = 0; i<tam; i++){
            if(indice == matriz[i][0]){
                for(int j = 0; j <13; j++){
                    no[j] = matriz[i][j];
                }
            }
        }
        return no;
    }
 
        
}
