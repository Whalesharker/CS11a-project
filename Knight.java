public class Knight extends Piece{
  //This is inherited so it should have all the functions of the base piece unless overwritten.
  public String type = "N";
  public boolean firstmove = true;
  public static void main(String[] args) {
    System.out.println("Knights can move in an L shape. They are also the only piece which can jump over other pieces.");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    if(Math.abs(x-newx) == 3 && Math.abs(y-newy) == 1 || Math.abs(x-newx) ==1 && Math.abs(y-newy) == 3){
      return true;
    }
    else{
      return false;
    }
  }
  public String getType(){
    return "N";
    //I wanted to change the type variable of the class but that wasn't working.
  }
}
