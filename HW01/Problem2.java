import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double v = 2;
        for(int i = 0; i<n; i++){
           // String inputtedWord = scanner.next();
            v *= Math.pow(2, -(scanner.next().charAt(1) - '='));
            //holy shit this was so hard to understand
        }

        System.out.println(v);

    }
}



