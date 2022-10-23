public class LinearEquation {
    int xCoord1, yCoord1, xCoord2, yCoord2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        //Check if fails vertical line test
        if (x1 == x2){
            if (y1 != y2){
                System.out.println("You have entered coordinates that result in a vertical line and provide an equation in the form x = __, e.g. x = 4 for points (4, 5) and (4, -6)");
                System.out.println("Line Equation: x = " + x1);
                System.exit(1); //Quits application
            }
        }

        this.xCoord1 = x1;
        this.yCoord1 = y1;
        this.xCoord2 = x2;
        this.yCoord2 = y2;
    }


    public double slope(){
        double yDiff = yCoord2 - yCoord1; //Casted to double to avoid integer division
        double xDiff = xCoord2 - xCoord1;

        double roundedSlope = Math.round((yDiff / xDiff) * 100.00) / 100.00; //Rounding to nearest hundrehts

        return roundedSlope;
    }

    public double yInt(){
        //Format: y1 - (slope * x1), derived from simplifying y = mx + b equation

        double yIntercept;
        yIntercept = yCoord1 - (this.slope() * xCoord1);
        yIntercept = Math.round(yIntercept * 100.00) / 100.00; //Round to nearest hundreths
        return yIntercept;

    }

    public String equation(){
        return String.format("y = %sx + %s", this.slope(), this.yInt());

        //TO DO:
        //READ FORMATING GUIDE IN DOCS AND THEN CODE ACCORDINGLY
    }

    //Methods: equation(), slope() , yInt(), distance(), lineInfo() , coordinateForX(double)
}
