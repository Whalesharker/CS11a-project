public class Piece{
  public String type = "e";
  public String color = "";
  //Color is initially nothing. It should be set later.
  public static void main(String[] args) {
    System.out.println("You aren't supposed to run the piece by itself.");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    //Takes the current x and y coordinates of the piece and the new x and y it wants to move too along with the board itself.
    //This should examine each tile inbetween the piece and the destination to see if there's anything blocking it.
    //it should also check if that's actually a valid move for that piece.
    //In the BASE piece class all moves should be invalid, each type of piece should have it's own function for movevalid
    return false;
    //honestly guys I don't know when to and not to use static variables.
    //I've just been erasing the static when I get an error.
  }
  public String getType(){
    return type;
    //returns a letter representing the piece. For the base piece it should be "e" to represent "empty"
  }
  public String getColor(){
    return color;
    //Returns the color of the string. Empty tiles shouldn't have a color.
  }
  public void setColor(String c){
    color = c;
    //a color is passed to this during the intial setup.
  }
}
