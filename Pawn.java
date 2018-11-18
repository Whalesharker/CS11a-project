public class Pawn extends Piece{
  //This is inherited so it should have all the functions of the base piece unless overwritten.
  public String type = "P";
  public boolean firstmove = true;
  public static void main(String[] args) {
    System.out.println("Pawns can move 1 space forward or 2 spaces on their first move. However they can only capture pieces by moving 1 space diagnoally");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    boolean good = true;
    if (Math.abs(x - newx) > 1){
      good = false;
      //Pawns will never be able to move more than 1 space across.
    }
    else if((Math.abs(y - newy) > 2) || (Math.abs(y-newy) <=0)){
      //moving the pawn more than 2 spaces or less than 1 space verticly.
      //TODO: make it so that black pawns can only move down and white pawns can only move up.
      good = false;
    }
    else if(Math.abs(y-newy) == 2 && firstmove == false){
      good = false;
    }
    else if(Math.abs(x - newx) == 1 && Math.abs(y-newy) >= 2){
      good = false;
      //Moving the pawn 2 spaces up and also diagnoally isn't allowed..
    }

    //if it clears all the instant nopes it should run this:
    else if (x - newx == 0){
      //this is the scenario for the pawn just moving straight.
      for(int i = y; i<=newy;i++){
        if(board[y][x].getType() !="e"){
          good = false;
          //returns false if any of the tiles from the current location to the new location are occupied.
        }
      }
    }
    else if(Math.abs(x - newx) == 1 && board[newy][newx].getType()== "e"){
      //scenario for the pawn capturing something by moving diagnoally.
      //checks to make sure that it's moving one across and that there's a piece where it's trying to capture.
      //This probably could just be an else statement, but I wanted to do one final check just in case I missed something.
      good = false;
    }
    if(good == true){
      firstmove = false;
      //notes that the pawn has made the first move if it successfully moves.
    }
    return good;
  }//End of movevalid
  public String getType(){
    return "P";
    //I wanted to change the type variable of the class but that wasn't working.
  }
}
