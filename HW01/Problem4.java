

import java.util.Scanner;


public class Problem4 {

        public static void main(String[] args){

            Scanner scanner = new Scanner(System.in);

            String inputtedWord = scanner.nextLine();

            if(inputtedWord.length() < 13){
                System.out.println(inputtedWord);
            }else if (inputtedWord.length() >=13){

                char firstCharacter = inputtedWord.charAt(0);
                char LastCharacter = inputtedWord.charAt(inputtedWord.length() - 1);
                //String inputtedWordSameString = LastCharacter + inputtedWord.substring(1, inputtedWord.length() - 1) + firstCharacter;

                // System.out.println(inputtedWord.length());

                int ternarynumber = inputtedWord.length() - 2;
                String ternary = ternaryConversion(ternarynumber);
                String inputtedWordSameString = LastCharacter + ternary + firstCharacter;



System.out.println(inputtedWordSameString);

            }
        }


    public static String ternaryConversion(int x) {
       String resultingString = "";
        while (x > 0) {
            int reminder = x % 3;
            resultingString = reminder + resultingString;
            x = x / 3;
        }
        return resultingString;
    }
}

//I'm sorry my identifier names are too complicated, but the idea is understandable I believe.