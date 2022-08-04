public class BitBoard {
    private long board;
    private int height;
    private int width;
    private int total;
    private long lastUpdate;
    public BitBoard(int h, int w){
        height = h;
        width = w;
        total = width * height;
        lastUpdate=0;
        reset();
    }
    public BitBoard(long b, int h, int w){
        height = h;
        width = w;
        total = width * height;
        board = b;
        lastUpdate =0;
    }
    public void reset(){
        board = 0;

    }
    public void setBoard(long b){
        board = b;
    }
    public long getLong(){
        return board;
    }
    public long getPos(int row, int col){
        if(row < 0 || col < 0 || row > total || col > total) return -1;
        return 1L << (row * width + col);
    }

    public boolean getPiece(int row, int col){
        long poss = getPos(row, col);
        return (board & poss) == 1;
    }
//    public void setPiece(int col){
//        int row = 0;
//        while(!getPiece(row++,col) && row < 6);
//        //row --;
//        board |= 1L << getPos(row, col);
//        //while(board >> width )
//    }


    public void setPos(int row, int col){
        lastUpdate = getPos(row,col);
        board |= lastUpdate;
    }
    public void setPos(long l){
        lastUpdate = l;
        board |= lastUpdate;
    }
    public long getLastUpdate() {
        return lastUpdate;
    }
    public void print(){
        System.out.println("----");
        for(int i = 0; i < total; i++){
            if(i % 7 == 0) System.out.println();

            if((board & (1L<<i)) != 0){
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }

        }

    }
}
