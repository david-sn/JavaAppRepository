package Alghorithms.Searching.Interpolation;

/*
if array conssit of 0011,0022,0033,1122,1155,2266,277,....
used to search number Phone start with sequence
mid=low+((high-low)/arr[hight]-arr[low])*(SearchingVal-arr[low])
 */
public class InterpolationSearch {

    static double search(int[] a, int key) {
        int A_Low = 0;
        int B_High = a.length - 1;
        int mid;
        int c = 0;
        while (A_Low <= B_High) {
            mid = A_Low + ((B_High - A_Low) / (a[B_High] - a[A_Low])) * (key - a[A_Low]);
            if (a[mid] > key) {
                B_High = mid - 1;
            } else if (a[mid] < key) {
                A_Low = mid + 1;
            } else {
                System.out.println(c);

                return a[mid];
            }
            c++;
        }
        return -101;//NOT_FOUND;}
    }
}
