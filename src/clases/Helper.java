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
        int nc = m[0].length;
        String aux = "";
        for (int j = in; j < fin; j++) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaAbajo(int [][] m, int j, int in, int fin){
        int nf = m.length;
        String aux = "";
        for (int i = in; i < fin; i++) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaIzquierda(int [][] m, int i, int in, int fin){
        int nc = m[0].length;
        String aux = "";
        for (int j = in; j > fin; j--) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoHaciaArriba(int [][] m, int j, int in, int fin){
        String aux = "";
        for (int i = in; i > fin; i--) {
            aux = aux + m[i][j]+", ";
        }
        return aux;
    }
    
    public static String recorridoUno(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        for (int i = 0; i < nf; i++) {
            if (i==0) {
                aux += Helper.recorridoHaciaDerecha(m, i, 0, nc-1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==nc-1) {
                aux += Helper.recorridoHaciaAbajo(m, j, 0, nf/2);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i==nf/2) {
                aux += Helper.recorridoHaciaIzquierda(m, i, nc-1, 0);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==0) {
                aux += Helper.recorridoHaciaAbajo(m, j, nf/2, nf-1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i==nf-1) {
                aux += Helper.recorridoHaciaDerecha(m, i, 0, nc);
            }
        }
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }
    
    public static String recorridoDos(JTable tabla1) {
        int[][] m = pasoDeDatos(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";
        for (int j = 0; j < nc; j++) {
            if (j==0) {
                aux += Helper.recorridoHaciaArriba(m, j, nf-1, 0);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i==0) {
                aux += Helper.recorridoHaciaDerecha(m, i, 0, nc/2);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==nc/2) {
                aux += Helper.recorridoHaciaAbajo(m, j, 0, nf-1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i==nf-1) {
                aux += Helper.recorridoHaciaDerecha(m, i, nc/2, nc-1);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==nc-1) {
                aux += Helper.recorridoHaciaArriba(m, j, nf-1, -1);
            }
        }
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
            if (i==auxF) {
                aux += Helper.recorridoHaciaDerecha(m, i, auxC, i+2);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==(auxC)+1) {
                aux += Helper.recorridoHaciaAbajo(m, j, (auxF)+1, j+1);
            }
        }
        for (int i = 0; i < nf; i++) {
            if (i==(auxF)+1) {
                aux += Helper.recorridoHaciaIzquierda(m, i, auxC, i-3);
            }
        }
        for (int j = 0; j < nc; j++) {
            if (j==(auxC)-1) {
                aux += Helper.recorridoHaciaArriba(m, j, auxF-1, auxF-2);
            }
        }
        aux = aux.substring(0, aux.length()-2)+".";
        return aux;
    }

}