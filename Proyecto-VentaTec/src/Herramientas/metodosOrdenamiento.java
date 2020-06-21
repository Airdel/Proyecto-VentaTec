/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

/**
 *
 * @author Luis Fernando Medina Gutierrez & Darien Rafael Márquez Vázquez & Angélica Edith Reyna Rivas, Pump it Team!
 */

import static javax.swing.JOptionPane.*;
public class metodosOrdenamiento {
    public static int[] bubbleSort(int A[]) {
        int n = A.length;
        for(int p = 1; p< n; p++) {
            for(int i = 0; i < n-p; i++) {
                if(A[i] > A[i + 1]){int aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }//bubbleSort
    
    public static int[] bubbleSortDes(int A[]) {
        int n = A.length;
        for(int p = 1; p< n; p++) {
            for(int i = 0; i < n-p; i++) {
                if(A[i] < A[i + 1]){int aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }
    
    public static String[] bubbleSort(String A[]) {
        int n = A.length;
        for(int p = 1; p < n; p++) {
            for(int i = 0; i < n - p; i++) {
                if(A[i].compareToIgnoreCase(A[i + 1]) > 0){String aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }
    
    public static String[] bubbleSortDes(String A[]) {
        int n = A.length;
        for(int p = 1; p < n; p++) {
            for(int i = 0; i < n - p; i++) {
                if(A[i].compareToIgnoreCase(A[i + 1]) < 0){String aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }
    
    public static double[] bubbleSortDouble(double A[]) {
        int n = A.length;
        for(int p = 1; p< n; p++) {
            for(int i = 0; i < n-p; i++) {
                if(A[i] > A[i + 1]){double aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }//bubbleSort
    
    public static double[] bubbleSortDoubleDes(double A[]) {
        int n = A.length;
        for(int p = 1; p< n; p++) {
            for(int i = 0; i < n-p; i++) {
                if(A[i] < A[i + 1]){double aux; aux = A[i]; A[i] = A[i + 1]; A[i + 1] = aux;}
            }
        }
        return A;
    }
    
    public static void quickSort(int[] A, int izq, int der) {
        int piv = A[izq], i = izq, j = der, aux;
        while(i < j) {
            while(A[i] <= piv && i < j) i++;
            while(A[j] > piv) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSort(A, izq, j - 1);
        if(j + 1 < der)quickSort(A, j + 1, der);
    }
    
    public static void quickSortDes(int[] A, int izq, int der) {
        int piv = A[izq], i = izq, j = der, aux;
        while(i < j) {
            while(A[i] >= piv && i < j) i++;
            while(A[j] < piv) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSortDes(A, izq, j - 1);
        if(j + 1 < der)quickSortDes(A, j + 1, der);
    }
    
    public static void quickSortDouble(double[] A, int izq, int der) {
        double piv = A[izq], aux; int i = izq, j = der;
        while(i < j) {
            while(A[i] <= piv && i < j) i++;
            while(A[j] > piv) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSortDouble(A, izq, j - 1);
        if(j + 1 < der)quickSortDouble(A, j + 1, der);
    }
    
    public static void quickSortDoubleDes(double[] A, int izq, int der) {
        double piv = A[izq], aux; int i = izq, j = der;
        while(i < j) {
            while(A[i] >= piv && i < j) i++;
            while(A[j] < piv) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSortDoubleDes(A, izq, j - 1);
        if(j + 1 < der)quickSortDoubleDes(A, j + 1, der);
    }
    
    public static void quickSortString(String[] A, int izq, int der) {
        String piv = A[izq], aux; int i = izq, j = der;
        while(i < j) {
            while(A[i].compareToIgnoreCase(piv) <= 0 && i < j) i++;
            while(A[j].compareToIgnoreCase(piv) > 0) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSortString(A, izq, j - 1);
        if(j + 1 < der)quickSortString(A, j + 1, der);
    }
    
    public static void quickSortStringDes(String[] A, int izq, int der) {
        String piv = A[izq], aux; int i = izq, j = der;
        while(i < j) {
            while(A[i].compareToIgnoreCase(piv) >= 0 && i < j) i++;
            while(A[j].compareToIgnoreCase(piv) < 0) j--;
            if(i < j){aux = A[i]; A[i] = A[j]; A[j] = aux;}
        }//while
        A[izq] = A[j]; A[j] = piv;
        if(izq < j - 1)quickSortStringDes(A, izq, j - 1);
        if(j + 1 < der)quickSortStringDes(A, j + 1, der);
    }
    
    public static void shell(int A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i] > A[i + salto]) {
                        int aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
    public static void shellDes(int A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i] < A[i + salto]) {
                        int aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
    public static void shellDes(double A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i] < A[i + salto]) {
                        double aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
     public static void shell(double A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i] > A[i + salto]) {
                        double aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
    public static void shell(String A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i].compareToIgnoreCase(A[i + salto]) > 0) {
                        String aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
    public static void shellDes(String A[]) {
        int n = A.length;
        boolean cambios;
        for (int salto = n; salto > 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (A[i].compareToIgnoreCase(A[i + salto]) < 0) {
                        String aux = A[i];
                        A[i] = A[i + salto];
                        A[i + salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }
    
    public static void radix(int[] A) {
        int m = A[0], n = A.length;
        for(int a : A)if(a>m)m=a;
        int d = (m+"").length();
        ListaSimple L[] = new ListaSimple[10];
        for(int i = 0; i < 10; i++)L[i] = new ListaSimple();
            for(int i = 0; i < n; i++)L[A[i] % 10].push(A[i]);
        for(int i = 0; i < 10; i++)L[i].verLista();
        int lista = 0;
        for(int i = 0; i < n; ){
                for(NodoInt e = L[lista].getIni(); e != null; e = e.getSig()){A[i] = e.getInfo();}
        }
    }
    
    public static int[] sort(int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
        return a;
    }  
    
    public static int[] sortDes(int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[((a[i]) / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[((a[i]) / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
        return voltear(b);
    } 
    
    public static int[] voltear(int[] A) {
        int[] B = new int [A.length];
        int cont = 0;
        for(int i = A.length-1; i > 0; i--) {
             B[cont++] = A[i];
        }
        return B;
    }
    
    public static void mezclaDirecta(int A[]) {
        int n = A.length; int t = n % 2 == 0 ? n/2 : (n+1)/2;
        int F1[] = new int [t]; int F2[] = new int [t];
        int sg = 1; 
        for(int i = 0; i < n; ) {
            //F1[] = A[i++];
            //F2[] = A[i++];
           
        }
    }
    
    public static int buscaSec(int A[], int e) {
        for(int i : A)
            if(A[i] == e)return i;
        return -1;
    }
    
    public static int buscaSec(String A[], String e) {
        for(int i = 0; i < A.length; i++) {
            if(A[i].equalsIgnoreCase(e))return i;
        }
        return -1;
    }
    
    public static int buscaSec(double A[], double e) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == e)return i;
        }
        return -1;
    }
    
    public static int buscaBin(int A[], int e) {
        int min = 0, may = A.length-1, c;
        while(min <= may) {
            c = (min + may)/2;
            if(e == A[c])return c;
            else if(e < A[c])may = c - 1;
            else min = c + 1;
        }
        return -1;
    }

    public static int buscaBin(String A[], String e) {
        int min = 0, may = A.length-1, c;
        while(min <= may) {
            c = (min + may)/2;
            if(e.equalsIgnoreCase(A[c]))return c;
            else if(e.compareToIgnoreCase(A[c]) < 0)may = c - 1;
            else min = c + 1;
        }
        return -1;
    }
    
    public static int buscaBin(double A[], double e) {
        int min = 0, may = A.length-1, c;
        while(min <= may) {
            c = (min + may)/2;
            if(e == A[c])return c;
            else if(e < A[c])may = c - 1;
            else min = c + 1;
        }
        return -1;
    }
    
    public static int[] intercalacionInt(int A[], int B[]) {
        int C[] = new int [A.length + B.length];
        int a = 0, b = 0, c = 0;
        for( ; c < C.length && a < A.length && b < B.length; c++) {
            if(A[a] <= B[b]){C[c] = A[a++];} 
            else{C[c] = B[b++];}
        }
        if(a == A.length)while(b < B.length)C[c++] = B[b++];
        else while(a < A.length)C[c++] = A[a++];
        return C;
    }
    
    public static String[] intercalacionString(String A[], String B[]) {
        String C[] = new String[A.length + B.length];
        int a = 0, b = 0, c = 0;
        for(; c < C.length && a < A.length && b < B.length; c++) {
            if(A[a].compareTo(B[b]) <= 0){C[c] = A[a++];}
            else{C[c] = B[b++];}
        }
        if(a == A.length)while(b < B.length)C[c++] = B[b++];
        else while(a < A.length)C[c++] = A[a++];
        return C;
    }
    
    public static double[] intercalacionDouble(double A[], double B[]) {
        double C[] = new double [A.length + B.length];
        int a = 0, b = 0, c = 0;
        for( ; c < C.length && a < A.length && b < B.length; c++) {
            if(A[a] <= B[b]){C[c] = A[a++];} 
            else{C[c] = B[b++];}
        }
        if(a == A.length)while(b < B.length)C[c++] = B[b++];
        else while(a < A.length)C[c++] = A[a++];
        return C;
    }
    
    
    
    public static int hash(String cad) {
        return Integer.parseInt(cad.substring(cad.length()-2));
    }
    
    public static String hashS(String cad) {
        return cad.substring(cad.length()-2);
    }
    
    public static double hashD(String cad) {
        return Double.parseDouble(cad.substring(cad.length()-2));
    }
    
    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 8, 9, 11};
        int B[] = {1, 3, 6, 10, 12, 14};
        int C[] = intercalacionInt(A, B);
        for(int a : C)System.out.println(a);
    }
}
