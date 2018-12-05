public class Queen extends Piece{
  public String type ="Q";
  public static void main(String[] args){
    System.out.println("The Queen can move diagonally,backwards,forwards and sideways");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    boolean valid = true;
    if(Math.abs(newy-y)>0&&Math.abs(newx-x)>0){
      //if both the x and y movement are greater than 0 it checks for diagnoal.
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
    }//end of diagnoal check.
    else{
      if((Math.abs(newx - x) == 0||Math.abs(newy-y) == 0) == false){
        //if neither of them are 0, then it should say nope. Because then it's not a straight line.
        valid = false;
      }
      if((Math.abs(newx - x) == 0)&&Math.abs(newy-y) == 0){
        //If they're both 0 then the piece isn't moving and bleep you
        valid =false;
      }
      else{
        if((Math.abs(newx - x) == 0)){
          if(y < newy){
            for(int i = y; i<newy;i++){
              if(board[i][x].getType() !="e"){
                valid = false;
              //returns false if any of the tiles from the current location to the new location are occupied.
              }
            }
          }
          else{
            for(int i = y; i>newy;i--){
              if(board[i][x].getType() !="e"){
                valid = false;
                //have to go the other direction.
              }
            }
          }
        }
        else if((Math.abs(newy - y) == 0)){
          if(x < newx){
            for(int i = x; i<newx;i++){
              if(board[y][i].getType() !="e"){
                valid = false;
              }
            }
          }
          else{
            for(int i = x; i>newx;i--){
              if(board[y][i].getType() !="e"){
                valid = false;
                //Checking the opposite direction.
              }
            }
          }
        }
      }
    }
  return valid;
  }
  public String getType(){
    return "Q";
    //I wanted to change the type variable of the class but that wasn't working.
  }
}
