import java.util.Scanner;
public class Problem5 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();

        //word = conversion(word);

        String updatedWord;

         updatedWord = word.replaceAll("[AIUEO]", "&" );
         String newUpdatedWord = updatedWord;

        //newUpdatedWord = updatedWord.replaceAll("(?<=[BCDFGHJKLMNPQRSTVWXYZ])", "!" );




        System.out.println(conversion(newUpdatedWord));
       // System.out.println(conversion(word));


        }


    public static String conversion(String a){

        for(int i = 0; i<a.length(); i++){

                if(a.charAt(i) != '&'){
                    a = a.substring(0, i+1) + '!' + a.substring(i+1);
                    i++;
                    //System.out.println(a);
                }




        }

        return a;





    }

}



