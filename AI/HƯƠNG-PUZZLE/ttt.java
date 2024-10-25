
import java.util.*;

public class ttt {

    public static Scanner sc = new Scanner(System.in);

    // ham swap- doi cho 2 o
    public static void swap(int[][] board, int i1, int j1, int i2, int j2) {
        int temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
        printBoard(board + "swapppppp");
    }

    // kiem tra trang thai hien tai co phai la trang thai dich hay khong
    public static boolean isGoalState(int[][] board, int[][] goal) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != goal[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // trang thai cua 8 puzzle
    // tim vi tri cua o trong
    public static void findEmptyTile(int[][] board, int[] pos) {
        // pos[0] = row, pos[1] = column
        // pos luu vi tri cua o trong
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                    return;
                }
            }
        }
    }

    // trang thai hien tai -> trang thai tiep theo
    public static ArrayList<State> generateMoves(State state) {
        ArrayList<State> possibleMoves = new ArrayList<>();
        int[] emptyPos = new int[2];
        findEmptyTile(state.board, emptyPos);
        int emptyRow = emptyPos[0];
        int emptyCol = emptyPos[1];
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // up, down, left, right

        for (int[] dir : directions) {
            int newRow = emptyRow + dir[0];
            int newCol = emptyCol + dir[1];
            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                int[][] newBoard = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    newBoard[i] = Arrays.copyOf(state.board[i], 3);
                }
                swap(newBoard, emptyRow, emptyCol, newRow, newCol);
                possibleMoves.add(new State(newBoard, 0, state.moves + 1, state));
            }
        }
        return possibleMoves;
    }

    // Solve the 8 puzzle using A* algorithm
    public static void solvePuzzle(int[][] initial, int[][] goal) {
        PriorityQueue<State> openList = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        
        Set<State> visited = new HashSet<>(); // Set to store the visited states
        int[] pos = new int[2];
        findEmptyTile(initial, pos);
        State initialState = new State(initial, 0, 0, null);
        initialState.name = 0;
        openList.add(initialState);
        int count = 1;
        System.out.printf("| %-15s| %-45s| %-65s|\n", "Current State", "OPEN", "CLOSED");

        while (!openList.isEmpty()) {
            State current = openList.poll();
            visited.add(current);

            // Check if the current state is the goal state
            if (isGoalState(current.board, goal)) {
                System.out.println("Goal state :"+"S"+current.name);
                System.out.println("Solution found in " + current.moves + " moves.");
                printSolution(current);
                //return;
                //printBoard(current.board);
                
                int stop = 0;
                
                while (stop == 0) {
                    System.out.print("Enter a number: ");
                    int input =sc.nextInt();
                    sc.nextLine();
                    for (State s : visited) {
                        if (s.name == input)
                        printBoard(s.board);
                    }
                    for (State s : openList) {
                        if (s.name == input)
                        printBoard(s.board);
                    }
                }
            }

            // Generate the next possible moves
            ArrayList<State> nextMoves = generateMoves(current);
            for (State nextState : nextMoves) {
                if (!visited.contains(nextState)) {
                    nextState.cost = nextState.moves + calculateManhattanDistance(nextState.board, goal);// f(x) = g(x) + h(x)
                    // Add the next state to the open list
                    if(!openList.contains(nextState) && !visited.contains(nextState)){
                        nextState.name = count++;
                       openList.add(nextState);
                    }
                }
            }

 

            // Print current state, open list, and visited list
            System.out.printf("| %-15s| %-45s| %-65s|\n", "S"+current.name, openList, visited);
        }

        System.out.println("No solution found.");
    }

    // function to calculate Manhattan distance heuristic - tinh khoang cach
    // Manhattan - h(x)
    public static int calculateManhattanDistance(int[][] board, int[][] goal) {
        /* int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != goal[i][j]) {
                    if (board[i][j] == 0)
                        continue;
                    h++;
                }
            }
        }
        return h; */
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] != goal[i][j])
                 h++;
                }
            }
        return h-1;
    }

    // function to print the solution path
    public static void printSolution(State state) {
        ArrayList<State> path = new ArrayList<>();
        while (state != null) {
            path.add(state);
            state = state.parent;
        }
       
        Collections.reverse(path);// reverse the path to get correct order
        StringJoiner sj = new StringJoiner(" -> ", "[", "]");
        for (State s : path) {
            sj.add("S" +s.name); // Assuming 'name' is the identifier for the state
            //sj.add("S" + s.name); // Assuming 'name' is the identifier for the state
           
        }
        // Print the complete path
        System.out.println(sj);
    }

    // function to print the board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        
        int[][] initial = {
                { 2, 8, 3 },
                { 1, 6, 4 },
                { 7, 0, 5 }
        };
        int[][] goal = {
                { 1, 2, 3 },
                { 8, 0, 4 },
                { 7, 6, 5 }
        };

        solvePuzzle(initial, goal);
        sc.close();
    }
}
