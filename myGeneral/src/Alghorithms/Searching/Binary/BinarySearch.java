package Alghorithms.Searching.Binary;

/*
O(log N)
mid=low+(high-low)/2

right wing = high=mid-1

left wing = low mid+1
 */
public class BinarySearch {

    double binarySearch(double[] a, double key) {
        int A_Low = 0;
        int B_High = a.length - 1;
        int mid;
        while (A_Low <= B_High) {
            mid = (A_Low + B_High) / 2;
            if (a[mid] > key) {
                B_High = mid - 1;
            } else if (a[mid] < key) {
                A_Low = mid + 1;
            } else {
                return a[mid];
            }
        }
        return -101;//NOT_FOUND;
    }

    void binarySearchV2(double[] a, double key) {
        int A_Low = 0;
        int B_High = a.length - 1;
        int mid = 0;
        boolean isFound = false;
        while (!isFound) {

            mid = A_Low + (A_Low - B_High) / 2;
            if (a[mid] == key) {
                System.out.println("Number Found");
            }

            if (a[mid] < key) {
                A_Low = mid + 1;
            }
            if (a[mid] > key) {
                B_High = mid - 1;
            }
            if (A_Low > B_High) {
                System.out.println("NotFound");
                break;
            }
        }

    }

}
