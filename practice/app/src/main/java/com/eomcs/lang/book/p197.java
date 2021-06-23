package com.eomcs.lang.book;

public class p197 {

  public static void main(String[] args) {

    //    int [] score = new int [] {79, 88, 91, 33, 100, 55,95};
    //    int [] score = new int [6];
    //    score[0] = 79;
    //    socre[1] = 88;
    //    score[2] = 91;

    int [] score = {79, 88, 91, 33, 100, 55,95};

    int max = score[0];
    int min = score[0];

    for (int i = 0; i < score.length; i++) {
      if (score[i] > max) {
        max = score[i];
      } else if (score[i] < min) {
        min = score[i];
      }

    }
    System.out.println("최대값 : " + max);
    System.out.println("최소값 : " + min);

  }

}
