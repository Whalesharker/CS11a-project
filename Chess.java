public class Chess{
  public static void main(String[] args) {
    Piece[][] board = initialize();
    printBoard(board);
    System.out.println("");
    printIndex(board);
    System.out.println(board[6][6].moveValid(6,6,6,4,board));
    System.out.println(board[6][6].moveValid(6,6,6,5,board));
    if(board[6][6].moveValid(6,6,6,5,board)){
      board = move(6,6,6,5,board);
    }
    else{
      System.out.println("Orca");
    }
    printBoard(board);
    //Alright, thing to note: the first index is y and the 2nd one is x. Yup. That's confusing.

  }
  public static Piece[][] initialize(){
    //This should set up a board with the initial placement
    Piece[][] board = new Piece[8][8];
    for(int i = 0; i < board.length;i++){
      for(int j = 0;j < board[i].length;j++){
        if(i == 1|| i == 6){
          board[i][j] = new Pawn();
        }
        else{
          board[i][j] = new Piece();
        }
        if(i<2 && board[i][j].getType() != "e"){
          board[i][j].setColor("B");
          //This will set the color to black for every piece on the top 2 rows that isn't empty.
        }
        else if(i>=6 && board[i][j].getType() != "e"){
          board[i][j].setColor("W");
          //This will set the color to white for every piece on the bottom 2 rows that isn't empty.
        }
      }
    }
    return board;
  }
  public static void printBoard(Piece[][] board){
    for(int i = 0; i < board.length;i++){
      for(int j = 0;j < board[i].length;j++){
        System.out.printf("%3s",board[i][j].getColor() + board[i][j].getType());
      }
      System.out.printf("%n");
      //prints what is at each tile.
    }
    //board no longer looks like a word.
  }
  public static void printIndex(Piece[][] board){
    for(int i = 0; i < board.length;i++){
      for(int j = 0;j < board[i].length;j++){
        System.out.printf(" %d,%d ",i,j);
      }
      System.out.printf("%n");
      //prints the Index of each tile.
    }
    //board no longer looks like a word.
  }
  public static Piece[][] move(int x, int y, int newx, int newy, Piece[][] board){
    board[newy][newx] = board[y][x];
    board[y][x] = new Piece();
    //After the move is confirmed as valid then it moves the piece to that position.
    //and removes it from the old position.
    //because of the way chess works then it can safely overwrite the thing that's already there.
    //(Unless it's a king or an allied piece.)
    return board;
  }
}
