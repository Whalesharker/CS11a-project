public class Chess{
  public static void main(String[] args) {
    Piece[][] board = initialize();
    //System.out.println(board);
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
}
