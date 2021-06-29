package com.eomcs.lang.book;

public class p267Ex6_12 {

  public static void main(String[] args) {
    int [] arr = new int [] { 3,2,1,6,5,4 };

    sumArr(arr);

  }

  static int sumArr(int [] arr) {
    int sum = 0;
    for (int i = 0; i<arr.length; i++) 
      sum += arr[i];

    System.out.println(sum);
    return sum;
  }

}
