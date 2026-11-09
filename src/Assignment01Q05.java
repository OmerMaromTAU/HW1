import java.util.Arrays;

public class Assignment01Q05 {
    public static int findShortestPath(int[][] graph, int src, int dest) {
        if (src == dest) {
            return 0;
        }

        int[] shortestPathTo = new int[graph.length];
        Arrays.fill(shortestPathTo, -1);
        shortestPathTo[src] = 0;

        // Array-based queue:
        int[] verticesToTry = new int[graph.length];
        verticesToTry[0] = src;
        int head = 0;
        int tail = 1;

        while (head < tail) {
            int curr = verticesToTry[head++];

            for (int other = 0; other < graph.length; other++) {
                if (graph[curr][other] == 1 && shortestPathTo[other] == -1) {
                    int shortestPathsToOther = shortestPathTo[curr] + 1;
                    shortestPathTo[other] = shortestPathsToOther;

                    if (other == dest) {
                        return shortestPathsToOther;
                    }

                    verticesToTry[tail++] = other;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}