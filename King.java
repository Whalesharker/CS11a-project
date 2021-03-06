//I matched the style with the Bishop class
public class King extends Piece{
  public String type = "K";
  public static void main(String[] args){
    System.out.println("King can move one space in any direction");
  }
  public boolean moveValid(int x, int y, int newx, int newy, Piece[][] board){
    String Player = getColor();
    boolean valid = true;
    if (Math.abs(newx-x)>1 && Math.abs(newy-y)>1){
      valid = false;
      //Checks to make sure the king is moving within an acceptable range
    }
    if (board[newx][newy].getType() !="e"){
      valid = false;
    }
    if (Player == "W"){
      if (WhiteCheck(x,y,newx,newy,board,Player) == true){
        valid = false;
      }
    }
    else if (Player == "B"){
      if (BlackCheck(x,y,newx,newy,board,Player) == true){
        valid = false;
      }
    }
    return valid;
  }
  //makes sure black king cane move without putting itself into check
  public boolean WhiteCheck(int x, int y, int newx, int newy, Piece[][] board,String Player){
    boolean check = false;
    //checks for check from Rooks and Queens
    //could probably be separated into classes for each piece on the board
    for (int i = 0; i<8; i++){
      if (board[newx][i].getType()=="R" || board[newx][i].getType()=="Q"){
        if (board[newx][i].getColor()=="B"){
          for (int j = 1; j < 7; j++){
            if ((newx > j && j > i) || (i > j && j > newx)){
              if (board[newx][j].getType() !="e"){
                check = true;
                //checks for rook/queen in same column and for protecting piece
              }
            }
          }
        }
      }
      if (board[i][newy].getType()=="R" || board[i][newy].getType()=="Q"){
        if (board[i][newy].getColor()=="B"){
          for (int j = 1; j < i; j++){
            if ((newy > j && j > i) || (i > j && j > newy)){
              if (board[j][newy].getType() !="e"){
                check = true;
                //checks for rook/queen in same row and for protecting piece
              }
            }
          }
        }
      }
    }
    //check for bishops and queen that can check king
    for (int i = 0; i<8; i++){
      if(newx+i<8 && newy+i<8){
        if (board[newx+i][newy+i].getType()=="B" || board[newx+i][newy+i].getType()=="Q"){
          if (board[newx+i][newy+i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx+j][newy+j].getType()!="e"){
                check = true;
                //checks above and to the right
              }
            }
          }
        }
      }
      if (newx-i>0 && newy-i>0){
        if (board[newx-i][newy-i].getType()=="B" || board[newx-i][newy-i].getType()=="Q"){
          if (board[newx-i][newy-i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx-j][newy-j].getType()!="e"){
                check = true;
                //checks below and to the left
              }
            }
          }
        }
      }
      if (newx+i >0 && newy-i>0){
        if(board[newx+i][newy-i].getType()=="B"||board[newx+i][newy-i].getType()=="Q"){
          if (board[newx+i][newy-i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx+j][newy-j].getType()!="e"){
                check = true;
                //checks above and to the left
              }
            }
          }
        }
      }
      if (newx-i>0 && newy+i>0){
        if (board[newx-i][newy+i].getType()=="B" || board[newx-i][newy+i].getType()=="Q"){
          if (board[newx-i][newy+i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx-j][newy+j].getType()!="e"){
                check = true;
                //checks below and to the right
              }
            }
          }
        }
      }
    }
    //check for pawns
    if (board[newx+1][newy+1].getType()=="P"){
      if (board[newx+1][newy+1].getColor()=="B"){
        check = true;
      }
    }
    if (board[newx+1][newy-1].getType()=="P"){
      if (board[newx+1][newy-1].getColor()=="B"){
        check = true;
      }
    }
    //check for knights
    for (int i=1;i<3;i++){
      if (board[newx-i][newy-(3-i)].getType()=="N"){
        if (board[newx-i][newy-(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx+i][newy-(3-i)].getType()=="N"){
        if (board[newx+i][newy-(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx-i][newy+(3-i)].getType()=="N"){
        if (board[newx-i][newy+(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx+i][newy+(3-1)].getType()=="N"){
        if (board[newx+i][newy+(3-1)].getColor()=="B"){
          check = true;
        }
      }
    }
    //check for king
    for (int i = -1; i<2; i++){
      for (int j = -1; j<2; j++){
        if (board[newx+i][newy+j].getType()=="K"){
          if (board [newx+i][newy+j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx+i][newy-j].getType()=="K"){
          if (board [newx+i][newy-j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx-i][newy+j].getType()=="K"){
          if (board [newx-i][newy+j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx-i][newy-j].getType()=="K"){
          if (board [newx-i][newy-j].getColor()=="B"){
            check = true;
          }
        }
      }
    }
    return check;
  }
  public boolean BlackCheck(int x, int y, int newx, int newy, Piece[][] board,String Player){
    boolean check = false;
    //checks for check from Rooks and Queens
    //could probably be separated into classes for each piece on the board
    for (int i = 0; i<8; i++){
      if (board[newx][i].getType()=="R" || board[newx][i].getType()=="Q"){
        if (board[newx][i].getColor()=="B"){
          for (int j = 1; j < 7; j++){
            if ((newx > j && j > i) || (i > j && j > newx)){
              if (board[newx][j].getType() !="e"){
                check = true;
                //checks for rook/queen in same column and for protecting piece
              }
            }
          }
        }
      }
      if (board[i][newy].getType()=="R" || board[i][newy].getType()=="Q"){
        if (board[i][newy].getColor()=="B"){
          for (int j = 1; j < i; j++){
            if ((newy > j && j > i) || (i > j && j > newy)){
              if (board[j][newy].getType() !="e"){
                check = true;
                //checks for rook/queen in same row and for protecting piece
              }
            }
          }
        }
      }
    }
    //check for bishops and queen that can check king
    for (int i = 0; i<8; i++){
      if(newx+i<8 && newy+i<8){
        if (board[newx+i][newy+i].getType()=="B" || board[newx+i][newy+i].getType()=="Q"){
          if (board[newx+i][newy+i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx+j][newy+j].getType()!="e"){
                check = true;
                //checks above and to the right
              }
            }
          }
        }
      }
      if (newx-i>0 && newy-i>0){
        if (board[newx-i][newy-i].getType()=="B" || board[newx-i][newy-i].getType()=="Q"){
          if (board[newx-i][newy-i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx-j][newy-j].getType()!="e"){
                check = true;
                //checks below and to the left
              }
            }
          }
        }
      }
      if (newx+i >0 && newy-i>0){
        if(board[newx+i][newy-i].getType()=="B"||board[newx+i][newy-i].getType()=="Q"){
          if (board[newx+i][newy-i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx+j][newy-j].getType()!="e"){
                check = true;
                //checks above and to the left
              }
            }
          }
        }
      }
      if (newx-i>0 && newy+i>0){
        if (board[newx-i][newy+i].getType()=="B" || board[newx-i][newy+i].getType()=="Q"){
          if (board[newx-i][newy+i].getColor()=="B"){
            for (int j = 1; j<i; j++){
              if(board[newx-j][newy+j].getType()!="e"){
                check = true;
                //checks below and to the right
              }
            }
          }
        }
      }
    }
    //check for pawns
    if (board[newx+1][newy+1].getType()=="P"){
      if (board[newx+1][newy+1].getColor()=="B"){
        check = true;
      }
    }
    if (board[newx+1][newy-1].getType()=="P"){
      if (board[newx+1][newy-1].getColor()=="B"){
        check = true;
      }
    }
    //check for knights
    for (int i=1;i<3;i++){
      if (board[newx-i][newy-(3-i)].getType()=="N"){
        if (board[newx-i][newy-(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx+i][newy-(3-i)].getType()=="N"){
        if (board[newx+i][newy-(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx-i][newy+(3-i)].getType()=="N"){
        if (board[newx-i][newy+(3-1)].getColor()=="B"){
          check = true;
        }
      }
      if (board[newx+i][newy+(3-1)].getType()=="N"){
        if (board[newx+i][newy+(3-1)].getColor()=="B"){
          check = true;
        }
      }
    }
    //check for king
    for (int i = -1; i<2; i++){
      for (int j = -1; j<2; j++){
        if (board[newx+i][newy+j].getType()=="K"){
          if (board [newx+i][newy+j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx+i][newy-j].getType()=="K"){
          if (board [newx+i][newy-j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx-i][newy+j].getType()=="K"){
          if (board [newx-i][newy+j].getColor()=="B"){
            check = true;
          }
        }
        if (board[newx-i][newy-j].getType()=="K"){
          if (board [newx-i][newy-j].getColor()=="B"){
            check = true;
          }
        }
      }
    }
  return check;
  }
  public String getType(){
    return "K";
    //I wanted to change the type variable of the class but that wasn't working.
  }
}
