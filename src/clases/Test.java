/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;

/**
 *
 * @author GABRIEL
 */
public class Test {
    /** 
     * @param args the command line arguments 
     */ 
    public static void main(String[] args) { 
        // TODO code application logic here 
        int mat[][] = new int[10][10]; 
        int dim = 5, centro, i, iz, der, vuelta = 0; 
        //float redondo; 
        Random rnd = new Random(); 
        String dimenTotals = new String(); 
        for (i = 0; i <= (dim - 1); i++) { 
            for (iz = 0; iz <= (dim - 1); iz++) { 
                mat[i][iz] = rnd.nextInt(50); 
            } 
        } 
        for (i = 0; i <= (dim - 1); i++) { 
            for (iz = 0; iz <= (dim - 1); iz++) { 
                if (iz == (dim - 1)) { 
                    System.out.println(mat[i][iz]); 
                } else { 
                    System.out.print(mat[i][iz] + " "); 
                } 
            } 
        } 
        centro = (int) (dim / 2); 

        while (vuelta <= centro) { 
            if (vuelta == 0) { 
                System.out.println("Inicio: " + mat[centro][centro]); 
                vuelta++; 
            } else { 
                while (vuelta <= centro) {//izquierda 
                    for (iz = (centro + vuelta - 1); iz >= (centro - vuelta + 1); iz--) { 
                        System.out.println(mat[iz][centro - vuelta] + " corresponde a: " + iz + "," + (centro - vuelta)); 
                    } 
                    for (i = (-vuelta); i <= (vuelta); i++) {// fila superior 
                        System.out.println(mat[centro - vuelta][centro + i] + " corresponde a : " + (centro - vuelta) + "," + (centro + i)); 
                    } 
                    for (der = (centro - vuelta + 1); der <= (centro + vuelta - 1); der++) {// derecha
                        System.out.println(mat[der][centro + vuelta] + " corresponde a : " + der + "," + (centro + vuelta)); 
                    } 
                    for (i = (centro + vuelta); i >= (centro - vuelta); i--) {// fila inferior 
                        System.out.println(mat[centro + vuelta][i] + " corresponde a: " + (centro + vuelta) + "," + (i)); 
                    } 
                    vuelta++; 
                } 
            } 
        } 
    } 
} 
