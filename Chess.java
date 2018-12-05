public class Chess{
  public static String Player ="W";
  public static void main(String[] args) {
    Piece[][] board = initialize();
    boolean c = true;
    do{
      System.out.println(Player +"'s turn");
      System.out.println("Tile Indexes:");
      //extra whitespace to sepperate things.
      printIndex(board);
      System.out.println("");
      //printIndex so the player knows what piece is what index.
      printBoard(board);
      System.out.println("");
      boolean entered = false;
      //This will test if a valid move has been entered.
      while (entered == false){
        int y = TextIO.getInt();
        int x = TextIO.getInt();
        int newy = TextIO.getInt();
        int newx = TextIO.getInt();
        //System.out.printf("%s%s at %d,%d selected to go to %d,%d which is occupied by %s%s.",board[y][x].getColor(),board[y][x].getType(),y,x,newy,newx,board[newy][newx].getColor(),board[newy][newx].getType());
        //just getInt so it can just take all the inputs on one line.
        if((y < 0 || y>7 || x < 0 || x>7 || newy < 0 || newx>7 || newx < 0 || newy>7) == false){
          //this if statement checks to make sure the points are actually on the board. Otherwise an error would happen.
          if  (board[y][x].getColor()== Player){
            //checks to make that it's the right player
            entered = board[y][x].moveValid(x,y,newx,newy,board);
          }
        }
        if(entered == false){
          if(board[y][x].getColor()!= Player){
            if(board[y][x].getColor() == ""){
              System.out.println("There's nothing there...");
            }
            else{
              System.out.println("That's not your piece. It's "+ Player +"'s turn");
            }
          }
          System.out.println("Invalid Move");
          System.out.println("Enter moves in format: y x new-y new-x");
        }
        else{
          move(x,y,newx,newy,board);
        }



      }
      Player = ColorChange(Player);
    }while (c == true);
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
        else if(i == 0 || i == 7){
          if(j == 0 || j ==7){
            board[i][j] = new Rook();
          }
          else if(j == 1 || j ==6){
            board[i][j] = new Knight();
          }
          else if(j == 2 || j ==5){
            board[i][j] = new Bishop();
          }
          else if(j == 3){
            board[i][j] = new Queen();
          }
          else if(j == 4){
            board[i][j] = new King();
          }
          //Puts all the pieces in the right place.
        }
        else{
          board[i][j] = new Piece();
        }
        //sets the colors after all the pieces have been placed.
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
  public static String ColorChange(String Player){
    if (Player =="W"){
      return "B";
    }
    if (Player == "B"){
      return "W";
    }
    else{
      return "W";
    }
  }

  /*public static Piece[][] Priority(Piece[][] board){
    //The purpose of this method is to decide which move it should make of all its possible movements
    //we should leave this in place, but turn all of it into a comment
    for(int i = 0; i < board.length;i++){
      for(int j = 0; j < board.length;j++){
        if(PossibleMove==true){
          if(DangerousMove==true){
            if(Piece is king){
              priority[i][j]=priority[i][j]-100
            }
            if(Piece is queen){
              priority[i][j]=priority[i][j]-5;
            }
            if(Piece is Rook||Knight||Bishop){
              priority[i][j]=priority[i][j]-3
            }
            else{
              priority[i][j]=priority[i][j]-1
            }
          }
          if(Trade==true){
            if(kill==King){
              priority[i][j]= priority[i][j]+100;
            }
            else if(kill==Queen){
              priority[i][j]= priority[i][i]+5;
            }
            else if(kill==Rook||kill==Knight||kill==Bishop){
              priority[i][j]= priority[i][j]+3;
            }
            else{
              priority[i][j]=1;
          }
        }
      }
    }
    return priority[i][j];
  }
  */
}
