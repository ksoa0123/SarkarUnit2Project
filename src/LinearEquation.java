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

    public String simpleEquation(){
        return String.format("y = %sx + %s", this.slope(), this.yInt());
    }
    public String equation(){
        //Hours wasted here: 2
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
            stringSlope = "x";
        }

        if (num < 0 && denom < 0){ //if both numerator and denominator are negative, and it cannot be simpliufied further
            num = Math.abs(num);
            denom = Math.abs(denom);
            stringSlope = num + "/" + denom;
        }

        if ((double) num / denom < 0){ //if divided is negative (one of them has to be negative) so we move the negative sign to the numerator as per rubric for formatting
            denom = Math.abs(denom); //turn the denominator into a positive, if it is in front of numerator it still will be a (-) fraction

            if (num > 0){ //if num is positive then make it negative so we can format it, otherwise it will already be the one that is negative, thus entacting our desired format
                num = num * -1;
                stringSlope = num + "/" + denom;
            }

        }

        return stringSlope;
    }

    //Methods: equation(), slope() , yInt(), distance(), lineInfo() , coordinateForX(double)
}
