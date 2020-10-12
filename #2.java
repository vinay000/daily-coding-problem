import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter total count of numbers : ");
        int n = input.nextInt();
        int[] list = new int[n];
        System.out.println("Enter " + n + " numbers");
        for (int index = 0; index < n; index++) {
            list[index] = input.nextInt();
        }
        input.close();
        System.out.print("List : ");
        for (int value : list) {
            System.out.print(value + " ");
        }

        int right[] = new int[n];
        int rightTotal = 1;
        int rightIndex = n-1;
        while  (rightIndex >=0){
            rightTotal *= list[rightIndex];
            right[rightIndex] = rightTotal;
            rightIndex--;
        }

        int left[] = new int[n];
        int leftTotal = 1;
        int leftIndex = 0;
        while (leftIndex < n) {
            leftTotal *= list[leftIndex];
            left[leftIndex] = leftTotal;
            leftIndex++;
        }

        System.out.print("\nRight : ");
        for (int value : right) {
            System.out.print(value + " ");
        }

        System.out.print("\nLeft : ");
        for (int value : left) {
            System.out.print(value + " ");
        }

        int finalIndex = 1;
        int finalList[] = new int[n];
        finalList[0] = right[1];
        finalList[n - 1] = left[n - 2];
        while(finalIndex < n-1){
            finalList[finalIndex] = left[finalIndex - 1] * right[finalIndex + 1];
            finalIndex++;
        }

        System.out.print("\nFinal : ");
        for (int value : finalList) {
            System.out.print(value + " ");
        }
    }
}