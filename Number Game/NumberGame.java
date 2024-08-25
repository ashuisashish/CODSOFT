import java.util.Scanner;
public class NumberGame {

    public  static void numberGame(){
       int myRandomNum = (int) (Math.random() * 100) + 1;

       Scanner sc = new Scanner(System.in);
       int attemps = 10;
       int number, i=0;

       System.out.println("Guess the number between 1 to 100! \nYou have maximum '10' attemps!");

       System.out.println("\nEnter the number: ");
       for(i=1; i<=attemps; i++){
            number = sc.nextInt();
            if (i==attemps) {
                System.out.println("Sorry! You have no attemps left");
                System.out.println("The number was " + myRandomNum);
            }
            else{
                
                if (number == myRandomNum) {
                    System.out.println("Congratulation! You guess the number in " + i + " attemps");
                    break;
                }
                else if (number < myRandomNum) {
                    System.out.println("You number is too low! " );
                }
                else if (number > myRandomNum) {
                    System.out.println("Your number is too high!");
                }  
            }
       }
       
       System.out.println("Do you want to play again if yes enter-> 1 if no enter-> 0 " );
       number = sc.nextInt();
       if(number == 1) {
            numberGame();
        }
        else{
            System.out.println("Thank you for playing!");
        }
    }
    public static void main(String[] args) {
       numberGame();
    }
}