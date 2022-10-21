public class LinearEquation {
    int xCoord;
    int yCoord;

    String debug;

    //(0, 3) --> 0,
    public LinearEquation(String coord){
        String newCoord = coord.substring(1, coord.length()-1);  //Gets rid of paranthesis so we can use parseInt

        this.xCoord = Integer.parseInt(newCoord.substring(0, newCoord.indexOf(","))); //gets x coordinate from string

        this.yCoord = Integer.parseInt(newCoord.substring(newCoord.indexOf(",") + 2)); //gets y value **remember the space after the comma
    }


}
