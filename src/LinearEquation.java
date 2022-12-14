import java.util.Scanner;

public class LinearEquation {
    int xCoord1, yCoord1, xCoord2, yCoord2;

    Scanner scanHere = new Scanner(System.in); //input which will only be used for horizontail line to print coordinate with x value given by user

    public LinearEquation(int x1, int y1, int x2, int y2){
        //Check if fails vertical line test
        if (x1 == x2){
            if (y1 != y2){ //when y1 and y2 are different it means it is a vertical line, otherwise it would be a horizontial line
                System.out.println("You have entered coordinates that result in a vertical line and provide an equation in the form x = __, e.g. x = 4 for points (4, 5) and (4, -6)");
                System.out.println(String.format("The 2 points are: (%s, %s) and (%s, %s)", x1, y1, x2, y2));
                System.out.println("Line Equation: x = " + x1);
                System.out.println("The slope of this line is: Undefined"); //Slope will always be undefined in a vertical line
                System.out.println("The y intercept of this line is: Undefined");
                System.out.println("The distance between these 2 points are: " + Math.abs(y2-y1)); //Distance in a vertical line is just y2 - y1. We do absloute value to account for (-) values

                //There is no inputting x value for this to get a coordinate because only the value of x1 accepts infinite number of y values
                System.exit(1); //Quits application
            }
        }

        //Checks if horizontial line
        if (y2 - y1 == 0){ //When y2 and y1 are the same
            System.out.println("You have entered coordinates that result in a horizontial line and provide an equation in the form y = _, e.g. y = 12 for points (7, 12) and (3, 12)");
            System.out.println(String.format("The 2 points are: (%s, %s) and (%s, %s)", x1, y1, x2, y2));
            System.out.println("Line Equation: y = " + y1);
            System.out.println("The slope of this line is: 0.0"); //Slope will always be 0 in a horizontial line
            System.out.println("The y intercept of this line is: " + y1);
            System.out.println("The distance between these 2 points are: " + Math.abs(x1-x2)); //The distance is just y1 - y1 cuz its a horizontail line.

            System.out.println("Enter a value for x: "); //Coordinate for x when it is a horizontial line
            double xHorizontial = scanHere.nextDouble();
            System.out.println(String.format("The point on the line is (%s, %s)", xHorizontial, y1));

            System.exit(1); //Quits application
        }

        this.xCoord1 = x1;
        this.yCoord1 = y1;
        this.xCoord2 = x2;
        this.yCoord2 = y2;
    }

    public double roundedToHundredth(double toRound){
        return Math.round(toRound * 100.00) / 100.0; //Helper method which rounds to nearest hundreths ex: 4.543 -> 4.5
    }

    public double slope(){
        double yDiff = yCoord2 - yCoord1;
        double xDiff = xCoord2 - xCoord1;

        double roundedSlope = this.roundedToHundredth(yDiff / xDiff); //Rounding to nearest hundreths

        return roundedSlope;
    }

    public double yIntercept(){
        //Format: y1 - (slope * x1), derived from simplifying y = mx + b equation

        double yInterceptValue;
        yInterceptValue = yCoord1 - (this.slope() * xCoord1);
        yInterceptValue = this.roundedToHundredth(yInterceptValue); //Round to nearest hundreths
        return yInterceptValue;

    }

    public String simpleEquation(){
        return String.format("y = %sx + %s", this.slope(), this.yIntercept());
    } //Equation without any fraction formatting **For debugging purposes

    public String equation(){
        //Hours wasted here: 2 :'(

        int num = yCoord2 - yCoord1;
        int denom = xCoord2 - xCoord1;

        String stringSlope = num + "/" + denom; //Original fraction, will be replaced by rules, otherwhise normal fraction prints

        if (denom % num == 0){ //If 0 then it means it can be simplifed further, denom is divisable by num
            denom = denom / num;
            num = num / num;
            stringSlope = num + "/" + denom;
        }


        //if whole number as a fraction

        if (num % denom == 0 ){ // if can be simplfied as a whole number
            stringSlope = Integer.toString(num / denom);
        }

        if (stringSlope.equals("1")){ //if it is coefficent 1 -> has to be x
            stringSlope = ""; //no coefficent, x already in final string return statement so we just make coefficent empty
        }

        if (stringSlope.equals("-1")){ //Coefficent of -1
            stringSlope = "-";
        }


        if ((double) num / denom < 0){ //if divided is negative (one of them has to be negative) so we move the negative sign to the numerator as per rubric for formatting
            denom = Math.abs(denom); //turn the denominator into a positive, if it is in front of numerator it still will be a (-) fraction

            if (num > 0){ //if num is positive then make it negative so we can format it, otherwise it will already be the one that is negative, thus entacting our desired format
                num = num * -1;
                if (num % denom != 0){ //If it can't be a whole number. As we don't need to format into negative as it will be a standalone negative whole number from above.
                    stringSlope = num + "/" + denom;
                }
            }
        }


        if (num < 0 && denom < 0){ ///when both numerator and denominator are negative and it cannot be simpliufied further ex: -8/ -3  or -4/ -17 it should format correctly
            if (num % denom != 0) {
                num = Math.abs(num);
                denom = Math.abs(denom);
                stringSlope = num + "/" + denom;
            }
        }


        //Format Y Intercept
        String yIntEnd = ""; //If y int is 0 none of the values will be reassigned so it will still be empty on par with the rules of not printing x- int when 0
        if (this.yIntercept() > 0){ //if y intercept is positive
            yIntEnd = " + " + this.yIntercept();
        }

        if (this.yIntercept() < 0){ //if y intercept is negative
            yIntEnd = " - " + Math.abs(this.yIntercept()); //formatting cuz ocd
        }

        return "y = " + stringSlope + "x" + yIntEnd;
    }


    public String coordinateForX(double xValue){
        //Make sure to round both (x,y) to nearest hundreths
        double yForSlope = (this.slope()* xValue) + this.yIntercept(); //Y coordinate
        yForSlope = this.roundedToHundredth(yForSlope); //Rounding to nearest hundreths

        String coordinateXY = String.format("(%s, %s)", xValue, yForSlope);
        return coordinateXY;
    }

    public double distance(){
        //Returns distance of 2 points
        double distanceXY = Math.sqrt(Math.pow(xCoord2-xCoord1, 2) + Math.pow(yCoord2- yCoord1, 2));
        distanceXY = this.roundedToHundredth(distanceXY); //Rounds to nearest hundreths

        return distanceXY;
    }

    public String lineInfo(){
        String lineInfoString = String.format("The two points are: (%s, %s) and (%s, %s) \n The equation of the line between these points is: %s \n The slope of this line is %s \n The y-intercept of this line is %s \n The distance between the two points is %s ", xCoord1, yCoord1, xCoord2, yCoord2, this.equation(), this.slope(), this.yIntercept(), this.distance());

        return lineInfoString;
    }

    //Methods: equation(), slope() , yIntercept(), distance(), lineInfo() , coordinateForX(double)
}
