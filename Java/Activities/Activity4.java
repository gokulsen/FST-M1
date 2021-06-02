package activities;

import java.util.Arrays;

class Activity4 {
    static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    public static void main(String args[]) {
        int[] data = { 4,3,2,10,12,1,5,6 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}