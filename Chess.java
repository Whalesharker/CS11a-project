public class Chess{
  public static void main(String[] args) {
    Piece[][] board = initialize();
    printBoard(board);
  }
  public static Piece[][] initialize(){
    //This should set up a board with the initial placement
    Piece[][] board = new Piece[8][8];
    for(int i = 0; i < board.length;i++){
      for(int j = 0;j < board[i].length;j++){
        board[i][j] = new Piece();
      }
    }
    return board;
  }
  public static void printBoard(Piece[][] board){
    for(int i = 0; i < board.length;i++){
      for(int j = 0;j < board[i].length;j++){
        System.out.printf(" %s ",board[i][j].getColor() + board[i][j].getType());
      }
      System.out.printf("%n");
    }
    //board no longer looks like a word.
  }
}
