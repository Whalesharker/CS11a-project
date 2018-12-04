public class Bishop extends Piece{
  //This is inherited so it should have all the functions of the base piece unless overwritten.
  public String type = "B";
  public static void main(String[] args) {
    System.out.println("Bishops can move to any space diagnoally as long as nothing is in the way.");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    boolean valid = true;
    if(Math.abs(newx-x) != Math.abs(newy-y)){
      valid = false;
      //checks to make sure an equal number of spaces are being moved verticly and horizontally.
      //(AKA diagnoally);
    }
    else{
      int j = x;
      for(int i = y; i<newy;i++){
        if(x < newx){
          j = j+1;
        }
        else{
          j = j-1;
        }
        //I think this should sync up the x and y coordinates so it actually checks the things from a diagnoally route.
        //Also checks if it's moving up or down in x.
        if(board[i][j].getType() !="e"){
          valid = false;
          //returns false if any of the tiles from the current location to the new location are occupied.
        }
      }
    }
  return valid;
  }
  public String getType(){
    return "B";
    //I wanted to change the type variable of the class but that wasn't working.
  }
}
