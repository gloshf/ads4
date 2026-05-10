import java.util.*;

public class GraphTraversal {

    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {

        graph.put("A", Arrays.asList("C", "B", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));

        System.out.println("DFS:");
        dfs("A", new HashSet<>());

        System.out.println("\n\nBFS:");
        bfs("A");
    }

    static void dfs(String node, Set<String> visited) {

        visited.add(node);
        System.out.print(node + " ");

        for (String neighbor : graph.get(node)) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    static void bfs(String start) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.print(node + " ");

            for (String neighbor : graph.get(node)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}