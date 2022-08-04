import java.util.Scanner;

public class Connect4Engine {
    private final BitBoard player1;
    private final BitBoard player2;
    private final BitBoard board;
    private final Scanner s;

    private final int height = 6;
    private final int width = 7;
    private final int total = width * height;

    public Connect4Engine(){
        player1 = new BitBoard(height, width);
        player2 = new BitBoard(height, width);
        board = new BitBoard(player1.getLong() | player2.getLong(), height, width);
        s = new Scanner(System.in);
    }

    public boolean dropPiece(BitBoard team, int col){
        long temp = (1L << col);
        if((board.getLong() & temp) != 0 || col > width || col < 0) return false;
//        int row = 0;
//        while(board.getPos(row+1,col) == 0 && row < height){
//            row++;
//        }

        while((temp << (width) & board.getLong()) == 0 && temp <= (1L << (total-width)) ) temp = temp << (width);
        team.setPos(temp);
        board.setPos(temp);
        System.out.println("Dropped at: -  "+col);
        return true;
    }

    public BitBoard getPlayer1() { return player1; }
    public BitBoard getPlayer2() { return player2; }
    public boolean checkWin(BitBoard player){
        boolean hasWon = false;
        long tPos = player.getLastUpdate();
        int count = 1;
        for(int i = 1; i <= 3; i++){
            if((player.getLong() & (tPos >> i)) == 0) break;
            count++;
        }
        for(int i = 1; i <= 3; i++){
            if((player.getLong() & (tPos << i)) == 0) break;
            count++;
        }
        if(count>=4) return true;
        count =1;
        for(int i = 1; i <= 3; i++){
            if((player.getLong() & (tPos << (i*7))) == 0) break;
            count++;
        }
        for(int i = 1; i <= 3; i++){
            if((player.getLong() & (tPos >> (i*7))) == 0) break;
            count++;
        }
        if(count>=4) return true;
        count =1;
        for(int i = 1; i <= 3; i++){
            if((player.getLong() & (tPos << (i*6))) == 0) break;
            count++;
        }
        for(int i = 1; i <= 3; i++){
            if((player1.getLong() & (tPos >> (i*6))) == 0) break;
            count++;
        }
        if(count>=4) return true;
        count =1;
        for(int i = 1; i <= 3; i++){
            if((player1.getLong() & (tPos << (i*8))) == 0) break;
            count++;
        }

        for(int i = 1; i <= 3; i++){
            if((player1.getLong() & (tPos >> (i*8))) == 0) break;
            count++;
        }
        return count>=4;
    }
    public void printGame(){
        System.out.println("-------------------");
        for(int i = 0; i < total; i++){
            if(i%7==0) System.out.println();
            if((player1.getLong() & (1L<<i)) != 0){
                System.out.print("X  ");
            } else if((player2.getLong() & (1L<<i)) != 0){
                System.out.print("O  ");
            } else System.out.print(".  ");

        }
        System.out.println();
        System.out.println("___________________");
        System.out.println("0  1  2  3  4  5  6");
        System.out.println("-------------------");
        System.out.println(Long.toBinaryString(board.getLong()));
        int c = 0;
        for(int i=0;i<64;i++) System.out.print(i%10);

    }
    public void move(BitBoard player){
        System.out.print("Choose Column: ");
        int input = s.nextInt();
        if(!dropPiece(player,input)) {
            move(player);
        }

    }
    public static void main(String[] args){
        Connect4Engine e = new Connect4Engine();
        e.dropPiece(e.getPlayer1(),3);
        while(true){
            e.printGame();
            System.out.println("Player 1 Goes");
            e.move(e.getPlayer1());
            if(e.checkWin(e.getPlayer1())) {
                e.printGame();
                System.out.println("PLAYER 1 WINS");
                break;
            }
            e.printGame();
            System.out.println("Player 2 Goes");
            e.move(e.getPlayer2());
            if(e.checkWin(e.getPlayer2())) {
                e.printGame();
                System.out.println("PLAYER 2 WINS");
                break;
            }
        }
    }
}
