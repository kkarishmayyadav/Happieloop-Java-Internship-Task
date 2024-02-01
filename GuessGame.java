
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        
        Random random=new Random();
        int number=random.nextInt(100);
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Guess the Number by Entering  Integer value : ");
        int input=sc.nextInt();

        while(number != input){
            if(number < input){
                System.out.println("Your guessed number is higher than actual 'Please enter small number!' ");
                input=sc.nextInt();
            }else if(number > input){
                System.out.println("Your guessed number is smaller than actual 'Please enter large number!' ");
                input=sc.nextInt();
            }
        }

        System.out.println("*****Congratulations!!!*****");
        System.out.println("You Guess the correct ");

        sc.close();

    }
    
}
