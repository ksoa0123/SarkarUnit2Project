import java.util.Scanner;
//Runner Class

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //  Ex sample inputs; (0, 1) & (2, 4)
        int x1, y1, x2, y2; //Initialize coordinate point value variables

        System.out.println("Hi user! Welcome to Linear Equation finder!"); //Greeting, as per rubric in doc

        System.out.println("Enter coordinate in format (x, y) **including space: ");
        String Coord1 = scan.nextLine(); //Gets user input of first coordinate in format (x, y)
        Coord1 = Coord1.substring(1, Coord1.length()-1);  //Gets rid of paranthesis so we can use parseInt. Format returned: x, y
        x1 = Integer.parseInt(Coord1.substring(0, Coord1.indexOf(","))); //gets x coordinate from string. Picks from index 0 to where comma apears **Recall 2nd parameter in substring is not inclusive so we get only x value
        y1 = Integer.parseInt(Coord1.substring(Coord1.indexOf(",") + 2)); //gets y value **remember the space after the comma that's why we did +2

        //Repeating same logic for 2nd coordinate
        System.out.println("Enter 2nd coordinate in format (x, y) **including space: ");
        String Coord2 = scan.nextLine();
        Coord2 = Coord2.substring(1, Coord2.length()-1);
        x2 = Integer.parseInt(Coord2.substring(0, Coord2.indexOf(",")));
        y2 = Integer.parseInt(Coord2.substring(Coord2.indexOf(",") + 2));


        //Giving points into class LinearEquation for operations
        LinearEquation obj = new LinearEquation(x1, y1, x2, y2);

        System.out.println(obj.lineInfo());

        System.out.println("Enter a value for x");
        double coordinateX = scan.nextDouble();

        System.out.println("The point on the line is " + obj.coordinateForX(coordinateX));


    }
}
