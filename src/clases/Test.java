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
        int m[][] = new int[5][5]; 
        int n = m.length, centro, i, iz, der, vuelta = 0; 
        m[0][0]=3;
        m[0][1]=4;
        m[0][2]=5;
        m[0][3]=8;
        m[0][4]=2;
        m[1][0]=7;
        m[1][1]=8;
        m[1][2]=9;
        m[1][3]=5;
        m[1][4]=6;
        m[2][0]=2;
        m[2][1]=3;
        m[2][2]=1;
        m[2][3]=8;
        m[2][4]=9;
        m[3][0]=0;
        m[3][1]=2;
        m[3][2]=9;
        m[3][3]=7;
        m[3][4]=8;
        m[4][0]=5;
        m[4][1]=6;
        m[4][2]=9;
        m[4][3]=2;
        m[4][4]=4;
        for (i = 0; i < n; i++) { 
            for (iz = 0; iz < n; iz++) { 
                if (iz==n-1) { 
                    System.out.println(m[i][iz]); 
                } else { 
                    System.out.print(m[i][iz] + " "); 
                } 
            } 
        } 
        centro = (int)(n/2); 

        while (vuelta <= centro) { 
            if (vuelta == 0) { 
                System.out.println("Recorrido:");
                System.out.print(m[centro][centro]+ ", "); 
                vuelta++; 
            } else { 
                while (vuelta <= centro) {//izquierda 
                    for (iz = (centro + vuelta - 1); iz >= (centro - vuelta + 1); iz--) { 
                        System.out.print(m[iz][centro - vuelta] + ", "); 
                    } 
                    for (i = (-vuelta); i <= (vuelta); i++) {// fila superior 
                        System.out.print(m[centro - vuelta][centro + i]+ ", "); 
                    } 
                    for (der = (centro - vuelta + 1); der <= (centro + vuelta - 1); der++) {// derecha
                        System.out.print(m[der][centro + vuelta]+ ", "); 
                    } 
                    for (i = (centro + vuelta); i >= (centro - vuelta); i--) {// fila inferior 
                        System.out.print(m[centro + vuelta][i]+ ", "); 
                    } 
                    vuelta++; 
                } 
            } 
        } 
    } 
} 
