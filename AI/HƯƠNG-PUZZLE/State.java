
// trang thai cua 8 puzzle
public class State {
    
        int[][] board;// The board configuration
        int cost;// The cost of the state - f(x)
        int moves;// so buoc di - so lan di chuyen - g(x)
        State parent;
        int name;
        
        //Constructor
        public State(int[][] board, int cost, int moves, State parent) {
            this.board = board;
            this.cost = cost;
            this.moves = moves;
            this.parent = parent;
        }

        public String toString() {
            return "S"+this.name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof State)) {
                return false;
            }
            State s = (State) obj;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != s.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            int shift = 0;
            for (int[] row : board) {
                for (int cell : row) {
                    hash ^= (cell << shift);
                    shift += 4;
                }
            }
            return hash;
        }

}
