import java.util.Scanner;
//Runner Class

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //  Ex; (0,1) & (2,4)

        System.out.println("Enter coordinate: ");

        String strCoord = scan.nextLine();


        LinearEquation coordinate = new LinearEquation("(0,3)");

        System.out.println(coordinate.xCoord);
        System.out.println(coordinate.yCoord);




        //Remove the paranthesis so you can use parseInt() . if (.contains) a parantehsis, To find the next number use substring so you can do number and then substring indexOf
         //Removes the Paranthwesis



        //You this file to ask for inputs and then use the methods that you make in the other file to computate the values and then it will all be printed here.

    }
}
