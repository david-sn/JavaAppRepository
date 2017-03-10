/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghorithms.Searching;

/**
 *
 * @author David Shire
 */
public class BinarySearch {
    
    int binarySearch(double[] a, double key) {
    int A_Low = 0;
    int B_High = a.length -1;
    int mid;
    while (A_Low<=B_High) {
        mid = (A_Low+B_High) /2;
        if (mid > key) 
            B_High = mid -1;
        else if (mid < key) 
            A_Low = mid +1;
        else 
            return mid;
    }
    return -101;//NOT_FOUND;
}
}
