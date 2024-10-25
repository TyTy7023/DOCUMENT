import java.util.Arrays;
import java.util.Set;

public class States {
    int[][] board = new int[3][3];
    int name, depth=0, cost, f, x, y;
    States parent;
    Linked
    //constructor
    public States() {};
    public States(int[][] board, int name, int depth, States parent, int[][] target) {
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = board[i][j];
                //find the empty cell position
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        this.board = board;
        this.name = name;
        this.depth = depth;
        this.cost = calculateCost(target);
        this.f = this.cost + this.depth;
        this.parent = parent;
    }
    public States(States Board) {
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                this.board[i][j] = Board.board[i][j];
        this.name = Board.name;
        this.depth = Board.depth;
        this.cost = Board.cost;
        this.f = Board.f;
        this.parent = Board.parent;
    }

    //check if the board is goal state
    public boolean isGoal(int[][] target) {
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                if (board[i][j] != target[i][j]) return false;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        States state = (States) o;
        return Arrays.deepEquals(board, state.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    //print the board
    @Override
    public String toString() {
        return "S"+ name + " " + "f=" + f ;
    }

    //calculate the cost of the board
    public int calculateCost(int[][] target) {
        if (board.equals(target)) 
            return 0;
        cost = 0;
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                if (board[i][j] != 0) 
                    if (board[i][j] != target[i][j]) cost++;
        return cost;
    }

    //actions
    public States moveUp(int[][] target) {
        if (x == 0) return this;
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                newBoard[i][j] = board[i][j];
        newBoard[x][y] = newBoard[x - 1][y];
        newBoard[x - 1][y] = 0;
        return new States(newBoard, name, depth + 1, this, target);
    }

    public States moveDown(int[][] target) {
        if (x == 2) return this;
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                newBoard[i][j] = board[i][j];
        newBoard[x][y] = newBoard[x + 1][y];
        newBoard[x + 1][y] = 0;
        return new States(newBoard, name, depth + 1, this, target);
    }

    public States moveLeft(int[][] target) {
        if (y == 0) return this;
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                newBoard[i][j] = board[i][j];
        newBoard[x][y] = newBoard[x][y - 1];
        newBoard[x][y - 1] = 0;
        return new States(newBoard, name, depth + 1, this, target);
        
    }

    public States moveRight(int[][] target) {
        if (y == 2) return this;
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                newBoard[i][j] = board[i][j];
        newBoard[x][y] = newBoard[x][y + 1];
        newBoard[x][y + 1] = 0;
        return new States(newBoard, name, depth + 1, this, target);
    }

    public void actions(int[][] target, Set<States> adjacent) {
        adjacent.add(moveDown(target));
        adjacent.add(moveUp(target));
        adjacent.add(moveLeft(target));
        adjacent.add(moveRight(target));  
    }

    //display the board
    public void Display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) 
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println("f = " + depth + " + " + cost + " = " + f );
        System.out.println("----------------");
    }
}