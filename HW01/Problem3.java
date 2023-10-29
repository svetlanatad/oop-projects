import java.util.Scanner;
public class Problem3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("keep in mind the program counts everything from 0, also it only works for odd n matrices");

        int n = scanner.nextInt();


        int x = scanner.nextInt();
        int y = scanner.nextInt();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == x && j == y) {
                    System.out.print("r");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }

        System.out.println("Here's the matrix you inputted. Now, let's calculate the minimum number of ways to get the lonely rabbit r to its empty home cell");

        int homex = n / 2;
        int homey = n / 2;
        int count = Math.abs(x - homex) + Math.abs(y - homey);

        System.out.println(count);

    }
}