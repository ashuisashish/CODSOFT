import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of your subjects!\n");

        System.out.print("1. Data Structure: ");
        double ds = sc.nextDouble();

        System.out.print("2. Operating System: ");
        double op = sc.nextDouble();

        System.out.print("3. Java: ");
        double java = sc.nextDouble();

        System.out.print("4. Computer Network: ");
        double cn = sc.nextDouble();

        System.out.print("5. Software Testing: ");
        double st = sc.nextDouble();

        double totalmarks = ds+op+java+cn+st;
        double percentage = totalmarks/5;
        System.out.println("\nYour total marks is: "+ totalmarks);
        System.out.println("\nYour percentage is: "+ percentage +"%");

        if (ds <33 || op<33 || java<33 || cn<33 || st<33) {
            System.out.println("You are fail");
        }
        else{

            if (percentage >= 90) {
                System.out.println("\nCongratulation! Your Grade is -> A");
            }
            else if (percentage >= 80 && percentage < 90 ) {
                System.out.println("\nCongratulation! Your Grade is -> B");
            }
            else if (percentage >= 70 && percentage < 80 ) {
                System.out.println("\nYour Grade is -> C");
            }
            else if (percentage >= 60 && percentage < 70 ) {
                System.out.println("\nYour Grade is -> D");
            }
            else if (percentage >= 50 && percentage < 60 ) {
                System.out.println("\nYour Grade is -> E");
            }
            else if (percentage >= 33 && percentage < 50 ) {
                System.out.println("\nPass");
            }
            else{
                System.out.println("\nSorry you are fail!");
            }
        }

    }
}
