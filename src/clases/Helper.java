/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gcoronad2
 */
public class Helper {

    public static void mensaje(Component ventana, String mensaje, int tipo_mensaje) {
        switch (tipo_mensaje) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "INFO", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void limpiadoTabla(JTable tabla1) {
        int nf, nc;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);
            }
        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setRowCount(0);
        tm.setColumnCount(0);
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);
        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    public static int[][] pasoDeDatos(JTable tabla1){
        int nf, nc;
        int m[][];
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        m = new int [nf][nc];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int)tabla1.getValueAt(i, j);
            }
        }
        return m;
    }
    
    public static String recorridoHaciaDerecha(int [][] m, int i, int in, int fin){
        String aux = "";
        for (int j = in; j <= fin; j++) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaIzquierda(int [][] m, int i, int in, int fin){
        String aux = "";
        for (int j = in; j >= fin; j--) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaArriba(int [][] m, int j, int in, int fin){
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaAbajo(int [][] m, int j, int in, int fin){
        String aux = "";
        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoDiagonalPrincipalAbajo(int[][] m, int j, int in, int fin) {
        String aux = "";
        for (int i = in; i <= fin; i++) {
            aux += m[i][i]+ ", ";
        }
        return aux;
    }
    
    public static String recorridoDiagonalSecundariaArriba(int[][] m, int j, int in, int fin) {
        int nc =m[0].length;
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux += m[i][nc-1-i]+ ", ";
        }
        return aux;
    }
    
    public static String recorridoDiagonalSecundariaAbajo(int[][] m, int j, int in, int fin) {
        String aux = "";
        int nc = m[0].length;
        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][nc-1-i]+", ";
        }
        return aux;
    }
    
    public static String recorridoUno(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        aux += Helper.recorridoHaciaDerecha(m, 0, 0, nc-1);
        aux += Helper.recorridoHaciaAbajo(m, nc-1, 1, nf/2);
        aux += Helper.recorridoHaciaIzquierda(m, nf/2, nc-2, 0);
        aux += Helper.recorridoHaciaAbajo(m, 0, nf/2+1, nf-1);
        aux += Helper.recorridoHaciaDerecha(m, nf-1, 1, nc-1);
        
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoDos(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        aux += Helper.recorridoHaciaArriba(m, 0, nf-1, 0);
        aux += Helper.recorridoHaciaDerecha(m, 0, 1, nc/2);
        aux += Helper.recorridoHaciaAbajo(m, nc/2, 1, nf-1);
        aux += Helper.recorridoHaciaDerecha(m, nf-1, nc/2+1, nc-1);
        aux += Helper.recorridoHaciaArriba(m, nc-1, nf-2, 0);
                
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoTres(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        int auxF, auxC;
        auxF = (nf-1)/2;
        auxC = (nc-1)/2;
        String aux = "";
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
            aux += Helper.recorridoHaciaDerecha(m, auxF, auxF-i, auxC-j);
            }
        }
        /*aux += Helper.recorridoHaciaAbajo(m, nc-1, 1, nf-1);
        aux += Helper.recorridoHaciaIzquierda(m, nf-1, nc-2, 0);
        aux += Helper.recorridoHaciaArriba(m, 0, nf-2, 1);*/
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoCuatro(JTable tabla1){
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        aux += Helper.recorridoHaciaDerecha(m, 0, 0, nc-1);
        aux += Helper.recorridoDiagonalSecundariaAbajo(m, nc-2, 1, nf-1);
        aux += Helper.recorridoHaciaDerecha(m, nf-1, 1, nc-1);
        
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoCinco(JTable tabla1){
        int [][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        aux += Helper.recorridoHaciaArriba(m, 0, nf-1, 0);
        aux += Helper.recorridoDiagonalPrincipalAbajo(m, 1, 1, nf/2);
        aux += Helper.recorridoDiagonalSecundariaArriba(m, (nf/2)-1, (nf/2)-1, 0);
        aux += Helper.recorridoHaciaAbajo(m, nc-1, 1, nf-1);
        
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
}