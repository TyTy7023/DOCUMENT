import java.util.Set;


public class States {
    int jug1,jug2;
    States parent; // Create a parent to store the parent state// Create a set to store the adjacent states of the (jug1,jug2) state

    States(){}
    States (int jug1, int jug2, States parent) {
        this.jug1 = jug1;
        this.jug2 = jug2;
        this.parent = parent;
    }
    States (States state) {
        this.jug1 = state.jug1;
        this.jug2 = state.jug2;
        this.parent = state.parent;
    }
    
    @Override // Display the state
    public String toString() {
        return "(" + jug1 + "," + jug2 + ")";
    }
    @Override // Compare the state
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (obj == this) return true;
        States s = (States) obj;
        return jug1 == s.jug1 && jug2 == s.jug2;
    }
    @Override // Hash the state to store in the set to support checking if the state is in the set
    public int hashCode() {
        return jug1 * 10 + jug2;
    }

    // Verify if the state is goal state
    public boolean isGoal(int target) {
        return jug1 == target || jug2 == target;
    }
    // Verify if the state is valid
    public boolean isValid(int maxJug1, int maxJug2) {
        return jug1 >= 0 && jug2 >= 0 && jug1 <= maxJug1 && jug2 <= maxJug2;
    }

    // Add the adjacent states to the adjacent set
    public void Action(int maxJug1, int maxJug2, Set<States> adjacent, States parent) {
        adjacent.add(new States(maxJug1, jug2, parent));// Fill jug1
        adjacent.add(new States(jug1, maxJug2, parent));// Fill jug2
        adjacent.add(new States(0, jug2, parent));// Empty jug1
        adjacent.add(new States(jug1, 0, parent));// Empty jug2
        int temp = Math.min(jug1, maxJug2 - jug2); // verify the amount of water that can be poured
        adjacent.add(new States(jug1 - temp, jug2 + temp,parent));// Pour jug1 to jug2
        temp = Math.min(jug2, maxJug1 - jug1); // verify the amount of water that can be poured
        adjacent.add(new States(jug1 + temp, jug2 - temp,parent));// Pour jug2 to jug1

    }
}
