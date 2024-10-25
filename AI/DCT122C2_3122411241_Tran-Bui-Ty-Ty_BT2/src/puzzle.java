import java.util.*;

public class puzzle {
    List<States> open = new LinkedList<>(); // Create a queue to store the states is going to be visited
    Queue<States> closed = new LinkedList<>(); // Create a queue to store the visited states
    Set<States> adjacent = new LinkedHashSet<>(); // Create a set to store the adjacent states of the current state
    int step = 1; // Create a variable to store the step number
    
    int[][] target = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}}; // Create a 2D array to store the target state
    int[][] initial = {{2, 8, 3}, {1, 6, 4}, {7, 0, 5}}; // Create a 2D array to store the initial state
    States initialState = new States(initial, 0, 0, null, target); // Create a new state to store the initial state
    int count = 1; // Create a variable to store the name of the state

    Object[] title = {"STEP", "CURRENT ", "OPENED", "CLOSED"}; // Create a string array to store the title of the table

    public void solve8Puzzle() {
        open.add(initialState); // Add the initial state to the open queue
        while (!open.isEmpty()) {
            States current = open.remove(0); // Get the first state from the open queue
            closed.add(current); // Add the current state to the closed queue
            
            if (current.isGoal(target)) {
                System.out.println("\nGOAL STATE FOUND " + current);
                Stack<States> path = new Stack<>();
                // Add the path to the stack
                while (!current.equals(initialState)) {
                    path.push(new States(current));
                    current = current.parent; 
                    // Get the parent of the current state to add to the path from the goal state to the initial state
                }
                path.push(initialState);
                System.out.print("PATH: \n");
                while (!path.isEmpty()) {
                    System.out.println("S"+path.peek().name);
                    path.pop().Display();
                }
                return;
            }
            
            current.actions(target, adjacent); // Get the adjacent states of the current state
            for (States state : adjacent) {
                if (!closed.contains(state) && !open.contains(state)) {
                    if (open.isEmpty()) {
                        for(States adj : adjacent) {
                            if (!closed.contains(adj)){
                                adj.name = count++;
                                open.add(adj); // Add the state to the open queue
                            }
                        }
                    }
                    else{
                        for (int i = 0; i < open.size(); i++) {
                            if (state.f < open.get(i).f) {
                                state.name = count++;
                                open.add(i, state);  
                                break;
                            }
                            else if (i == open.size() - 1 ) {
                                state.name = count++;
                                open.add(state); // Add the state to the open queue
                                break;
                            }
                        }
                    }
                }
            }
            // // // Display the A* process
            if(step==1) System.out.printf("| %-5s| %-10s| %-75s| %-50s |", title);    
            System.out.printf("\n| %-5s| %-10s| %-75s| %-50s |",step++,current, open,closed);
            adjacent.clear();
        }
        
        System.out.println("\nNO STATES FOUND");
    }
}
