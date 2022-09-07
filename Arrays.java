import java.util.*;

public class Arrays {

  public static int linier_search(int numbers[], int key) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == key) {
        return i;
      }

    }
    return -1;
  }

  public static int binary_search(int numbers[], int key) {
    int start = 0;
    int end = numbers.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;

      if (numbers[mid] == key) {
        return mid;
      }
      if (numbers[mid] < key) {
        start = mid + 1;

      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static int largest_number(int numbers[]) {
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > largest) {
        largest = numbers[i];
      }

    }
    return largest;
  }

  public static int smallest_number(int numbers[]) {
    int smallest = Integer.MAX_VALUE;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < smallest) {
        smallest = numbers[i];
      }
    }
    return smallest;
  }

  public static void reverse(int rnumbers[]) {
    int first = 0, last = rnumbers.length - 1;

    while (first < last) {
      // swaping the numbers in the index of first with last till its all reversed
      int temp = rnumbers[last];
      rnumbers[last] = rnumbers[first];
      rnumbers[first] = temp;
      first++;
      last--;
    }
  }

  public static void printPairs(int numbers[]) {
    int tp = 0; // total pair count

    for (int i = 0; i < numbers.length; i++) {
      int curr = numbers[i]; // current numbers with which pairs will be made and it will keep update with
                             // increase of i


      for (int j = i + 1; j < numbers.length; j++) {
        System.out.print("(" + curr + "," + numbers[j] + ")");
        tp++;
      }
      System.out.println();

    }
    System.out.println("total pairs number is : " + tp);
  }

  public static void subArrays(int numbers[]) {
    int ts = 0; // total subarrays count
    for (int i = 0; i < numbers.length; i++) {
      int start = i;
      for (int j = i; j < numbers.length; j++) {
        int end = j;
        for (int k = start; k <= end; k++) {

          System.out.print(numbers[k] + "");
        }
        ts++;
        System.out.println();
      }
      System.out.println();
    }
    System.out.print("Number of total subarrays is :" + ts);
  }

  
  // Printing MAXSum of Subarrays ( Brute Froce I)
  
  public static void maxSubarraySum(int numbers[]){
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    
    for(int i = 0; i<numbers.length;i++){
      int start = i;
      for(int j = i; j<numbers.length; j++){
        int end = j;
        currSum = 0;
        //Print SubArray Sum
        for(int k = start ; k<= end;k++){
          currSum = currSum+numbers[k];
        }
        System.out.println(currSum);
        if(maxSum<currSum){
            maxSum = currSum;
        }
      }
    }
    System.out.println("Max sum of the subarrays :" + maxSum );
  }


  // MAX sum of subarrays using prefix Way II

  public static void maxSubArraySumPrefixWay(int numbers[]){
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int prefix[] =new int [numbers.length];
    prefix[0] = numbers[0];
    //calculate the prefix array
    for(int i = 1; i<numbers.length; i++){
      prefix[i] = prefix[i-1] + numbers[i];
    }

    for(int  i = 0; i<numbers.length; i++){
      int start = i;
      for(int j = i; j< numbers.length; j++){
        int end = j;
        //ternary Oprtator using
        currSum = start ==0? prefix[end] : prefix[end] - prefix[start - 1];
        if(maxSum < currSum){
          maxSum = currSum;
        }
      }
    }
    System.out.println("MAX sum of subarrays using PREFIX WAY:" + maxSum);
  }

  // MAX SUBARRAYS SUM USING kadanes Way III
  public static void maxArraySumKadanes(int numbers[]){
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i = 0; i<numbers.length; i++){
      currSum = currSum + numbers[i];
      if(currSum<0){
        currSum =0;
      }
      maxSum = Math.max(currSum, maxSum);
    }
    System.out.println("MAX SUM KADANES WAY :" + maxSum);
  }

  public static void main(String args[]) {

    // int numbers[] = {2,4,6,8,10,12,14,16};
    // int key = 10;

    // System.out.println( "your number is in index : " + linier_search(
    // numbers,key));

    // System.out.println("your number is in index : " + binary_search(numbers,
    // key));

    // System.out.println("largest number of the array is : " +
    // largest_number(numbers));

    // System.out.println("Smallest number of the array is : " +
    // smallest_number(numbers));

    // String names[] = {"rick", "rocky", "jack", "mike"};

    // for(int i = 0; i< names.length; i++){
    // System.out.println(names[i]);
    // }

    // int rnumbers[] = {2,4,6,8,10};
    // for(int i = 0; i<rnumbers.length; i++){
    // System.out.print( rnumbers[i] + " ");
    // }

    // System.out.println();

    // reverse(rnumbers);

    // for(int i = 0; i< rnumbers.length; i++){
    // System.out.print(rnumbers[i] + " ");
    // }

    // System.out.println();

    // int numbers[] = { 2, 4, 6, 8, 10 };

    // printPairs(numbers);
    // subArrays(numbers);

    }
  }

    