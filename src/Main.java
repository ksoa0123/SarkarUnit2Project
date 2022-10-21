import java.util.Scanner;
//Runner Class

//Testing Intelijj Github Integration.

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //  Ex; (0,1) & (2,4)

        String testCoord = "(0, 3)";


        //Remove the paranthesis so you can use parseInt() . if (.contains) a parantehsis, To find the next number use substring so you can do number and then substring indexOf
        String cleanCoord = testCoord.substring((1, testCoord.length() -1 )); //Removes the Paranthwesis

        int xCoord = cleanCoord.substring(0, cleanCoord.indexOf(","))

        //You this file to ask for inputs and then use the methods that you make in the other file to computate the values and then it will all be printed here.

    }
}
