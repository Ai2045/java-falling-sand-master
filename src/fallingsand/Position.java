package fallingsand;

public class Position {
    protected int row;
    protected int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void moveDown() {
        row = row + 1;
    }

    public Position getDownPos() {
        return new Position(row+1,col);
    }

    public Position getLeftDownPos() {
        return new Position(row+1,col-1);
    }
    public Position getRightDownPos() {
        return new Position(row+1,col+1);
    }

    public void moveLeftDown() {
        row +=1;
        col -=1;
    }
    public void moveRightDown() {
        row +=1;
        col +=1;
    }
}
