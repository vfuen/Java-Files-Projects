/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergsorttest;
   import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author vfuen
 */
public class MergSortTest {


public class MergeSortTest {
   // calls recursive sortArray method to begin merge sorting
   public static <T> void mergeSort(T[] data) {
      sortArray((T[]) data, 0, data.length - 1); // sort entire array
   }

   // splits array, sorts subarrays and merges subarrays into sorted array
   private static <T extends Comparable<T>> void sortArray(T[] data, int low, int high) {
      // test base case; size of array equals 1
      if ((high - low) >= 1) { // if not base case
         int middle1 = (low + high) / 2; // calculate middle of array
         int middle2 = middle1 + 1; // calculate next element over

         // output split step
         System.out.printf("split:   %s%n",
               subarrayString(data, low, high));
         System.out.printf("         %s%n",
               subarrayString(data, low, middle1));
         System.out.printf("         %s%n%n",
               subarrayString(data, middle2, high));

         // split array in half; sort each half (recursive calls)
         sortArray(data, low, middle1); // first half of array
         sortArray(data, middle2, high); // second half of array

         // merge two sorted arrays after split calls return
         merge(data, low, middle1, middle2, high);
      }
   }

   private static <T> Object subarrayString(T[] data, int low, int high) {
      return null;
   }

   // merge two sorted subarrays into one sorted subarray
   public static <T extends Comparable<T>> void merge(T[] data, int left, int middle1,
         int middle2, int right) {

      int leftIndex = left; // index into left subarray
      int rightIndex = middle2; // index into right subarray
      int combinedIndex = left; // index into temporary working array
       T[] combined = new T[data.length]; // working array

      // output two subarrays before merging
      System.out.printf("merge:   %s%n",
            subarrayString(data, left, middle1));
      System.out.printf("         %s%n",
            subarrayString(data, middle2, right));

      // merge arrays until reaching end of either
      while (leftIndex <= middle1 && rightIndex <= right) {
         // place smaller of two current elements into result
         // and move to next space in arrays
         if (data[leftIndex].compareTo(data[rightIndex])<= 0) {
            combined[combinedIndex++] = () data[leftIndex++];
         } else {
            combined[combinedIndex++] = () data[rightIndex++];
         }
      }

      // if left array is empty
      if (leftIndex == middle2) {
         // copy in rest of right array
         while (rightIndex <= right) {
            combined[combinedIndex++] = (T) data[rightIndex++];
         }
      } else { // right array is empty
         // copy in rest of left array
         while (leftIndex <= middle1) {
            combined[combinedIndex++] = (T) data[leftIndex++];
         }
      }

      // copy values back into original array
      for (int i = left; i <= right; i++) {
         data[i] = combined[i];
      }

      // output merged array
      System.out.printf("         %s%n%n",
            subarrayString(data, left, right));
   }

   // method to output certain values in array
   private static <T> String subarrayString(T[] data, int low, int high) {
      StringBuilder temporary = new StringBuilder();

      // output spaces for alignment
      for (int i = 0; i < low; i++) {
         temporary.append("   ");
      }

      // output elements left in array
      for (int i = low; i <= high; i++) {
         temporary.append(" " + data[i]);
      }

      return temporary.toString();
   }

   public static <T> void main(String[] args) {
      SecureRandom generator = new SecureRandom();
      int[] data = generator.ints(10, 10, 91).toArray();

      // create unordered array of 10 random ints
      Integer[] dataInt = { 63, 19, 65, 38, 26, 74, 27, 25, 70, 38 };
      Double[] dataDouble = { 102.5, 1.98, -3.12, 45.23, 4.5, -56.78, 38.24, 12.34, -105.23, 77.39 };
      String[] dataString = { "zebra", "wolf", "panda", "octopus", "monkey", "fox", "elephant", "dog", "cat",
            "allegator" };

      System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
      mergeSort(dataInt); // sort array
      System.out.printf("Sorted array: %s%n", Arrays.toString(data));
   }

        private static <T> void sortArray(T[] name, int i, int i0) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }}
