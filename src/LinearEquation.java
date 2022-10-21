public class LinearEquation {
    int xCoord;
    int yCoord;

    public void LinearEquation(String coord){
        coord = coord.substring(1, coord.length() -1);  //Gets rid of paranthesis

        this.xCoord = Integer.parseInt(coord.substring(0, coord.indexOf(","))); //gets x coordinate from string

        this.yCoord = Integer.parseInt(coord.substring(coord.indexOf(",") + 2, coord.length())); //gets y value **remember the space after the comma
    }


}
