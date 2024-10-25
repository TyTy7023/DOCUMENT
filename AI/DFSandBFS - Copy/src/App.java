public class App {
    public static void main(String[] args) throws Exception {
        SearchAlgorithm search = new SearchAlgorithm();
        System.out.println("\nTHE TABLE OF BFS PROCESS:");
        for(int i=0; i<170; i++) System.out.print("-");
        System.out.println();
        search.BFS(4, 3, 2);
        System.out.println("\nTHE TABLE OF DFS PROCESS:");
        for(int i=0; i<170; i++) System.out.print("-");
        System.out.println();
        search.DFS(4, 3, 2);
    }
}
