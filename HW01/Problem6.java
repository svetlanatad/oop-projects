import java.util.Scanner;
public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        l+=1;


        for(int i = 1; i <= 2*l - 1; i++){
            for( int j = 1; j <= 2*l - 1; j++){
                if(j==i || j==2*l - i){
                    System.out.print("X");
                }else{
                    System.out.print(" ");
                }


            }
            System.out.println();
        }
    }
}



