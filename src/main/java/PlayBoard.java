//public class PlayBoard {
//   // private BitBoard blackPieces;
//   // private BitBoard redPieces;
//
//
//
//    public PlayBoard(){
//        blackPieces = 0b0;
//        //for(int i = 0; i < (height*width-1);i++) blackPieces+=0;
//        redPieces = blackPieces;
//    }
//
//    public void printBoard(){
//        System.out.println();
//
//    }
//    //              Board [row]     [col]
//    public boolean addPiece(int team, int col){
//        if(team != 1 && team != -1) return false;
//        if(col > board.length || col < 0) return false;
//        if(board[0][col]!=0) return false;
//        int fallInc = 0;
//        while(fallInc < board.length - 1 && board[fallInc][col]==0) fallInc++;
//        board[fallInc][col] = team;
//        return true;
//    }
//}
