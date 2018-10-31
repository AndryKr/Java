/**
 * Java. Level 1. Lesson 2. Home work
 *
 * @author Andry Krasikov
 * @version Aug 16, 2018
 */

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        revers();
        progres();
        gemination();
        squareArr();
        minmaxarr();
        System.out.println(isDivideByLevel(new int[]{4, 0, 7, 3, 1, 7}));
        cycleArr(new int[]{1,2,3,4,5}, 2);
    }

    public static void revers() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i<arr.length; i++) {
            switch (arr[i]){
                case 0:
                    arr[i]=1;
                    break;
                case 1:
                    arr[i]=0;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr) + "\n");
    }

    public static void progres(){
        int[] arry = new int[8];
        int x = 3;
        for (int i=0, j=0;  i<arry.length; i++, j+=x){
            arry[i]=j;
        }
        System.out.println(Arrays.toString(arry)+ "\n");
    }

    public static void gemination(){
        int[] arriva = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<arriva.length; i++) {
            if (arriva[i]<6){
                arriva[i]*=2;
            }
        }
        System.out.println(Arrays.toString(arriva)+ "\n");
    }

    public static void squareArr() {
        int[][] sqrarr = new int[5][5];
        for ( int i = 0 ; i < 5 ; i ++) {
            for ( int j = 0 ; j < 5 ; j ++) {
                if (i==j||i+j==4) {
                    sqrarr[i][j] = 1;
                }
                System.out.print(sqrarr[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void minmaxarr(){
        int [] intarrs = {9,6,7,30,5,40,8,11};
        int max=intarrs[0], min=intarrs[0];
        for (int i=0; i<intarrs.length; i++){
            if (max<=intarrs[i]){
                max=intarrs[i];
            }
            if (min>=intarrs[i]){
                min=intarrs[i];
            }
        }
        System.out.println("максимум = " + max + "\n" + "минимум = " + min + "\n");
    }

    public static boolean isDivideByLevel(int [] massive){
        int sum=0;
        int sum1=0;
        boolean bool = false;
        for (int i=0; i<massive.length; i++){
            sum+=massive[i];
        }
        for(int i=0; i<massive.length; i++){
            sum1+=massive[i];
            if(sum1==sum/2){
                System.out.println("Граница расположена после элемента с индексом " + i);
                bool = true;
                break;
            }
        } return bool;
    }

    public static void cycleArr(int [] arr, int n) {
        if (n >= 0){
        for (int j = 0; j < n; j++) {
            int x = arr[arr.length - 1];
            for (int i = arr.length - 1; i > -1; i--) {
                if (i < 1) {
                    arr[i] = x;
                } else {
                    arr[i] = arr[i - 1];
                }
            }
        }
    }else {
            for (int j = 0; j > n; j--) {
                int x = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    if (i > arr.length-2) {
                        arr[arr.length-1] = x;
                    } else {
                        arr[i] = arr[i+1];
                    }
                }
            }
        }
        System.out.println("\n" + Arrays.toString(arr));
    }
}