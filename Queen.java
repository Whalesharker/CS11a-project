public class Queen extends Piece{
  public String type ="Q";
  public static void main(String[] args){
    System.out.println("The Queen can move diagonally,backwards,forwards and sideways");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    boolean valid = true;
    if((Math.abs(newx - x) == 0||Math.abs(newy-y) == 0) == false){
      //if neither of them are 0, then it should say nope. Because then it's not a straight line.
      valid = false;
    }
    if((Math.abs(newx - x) == 0)&&Math.abs(newy-y) == 0){
      //If they're both 0 then the piece isn't moving and bleep you
      valid =false;
    }
    if(Math.abs(newx- x))
    else{
      if((Math.abs(newx - x) == 0)){
        for(int i = y; i<newy;i++){
          if(board[i][x].getType() !="e"){
            valid = false;
          //returns false if any of the tiles from the current location to the new location are occupied.
          }
        }
      }
      else if((Math.abs(newy - y) == 0)){
        for(int i = x; i<newx;i++){
          if(board[y][i].getType() !="e"){
            valid = false;
          }
        }
      }
    }
  return valid;
  }
}
