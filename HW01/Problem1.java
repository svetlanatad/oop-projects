import java.util.Scanner;
public class Problem1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int sum = 0;
        for(int i = 0; i<2*k; i++){

            sum += scanner.nextInt();

        }
        sum *= sum;
        System.out.println(sum);
    }

}

