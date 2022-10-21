import java.util.Scanner;
//Runner Class

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //  Ex; (0, 1) & (2, 4)

        System.out.println("Enter coordinate: ");

        String strCoord = scan.nextLine();

        LinearEquation coordinate = new LinearEquation(strCoord);

        System.out.println(coordinate.xCoord);


        System.out.println(coordinate.yCoord);


    }
}
