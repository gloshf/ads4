public class Dijkstra {

    public static void main(String[] args) {

        String[] cities = {
                "Edinburgh",
                "Stirling",
                "Perth",
                "Dundee",
                "Glasgow"
        };

        int[][] graph = {

                {0,    50, 100, 0,   70},
                {50,   0,   40, 0,   50},
                {100, 40,   0,  60,   0},
                {0,    0,  60,  0,    0},
                {70,  50,   0,  0,    0}
        };

        int[] distance = {0, 999, 999, 999, 999};
        boolean[] visited = new boolean[5];

        for (int i = 0; i < 5; i++) {

            int min = 999;
            int current = -1;

            for (int j = 0; j < 5; j++) {

                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true;

            for (int j = 0; j < 5; j++) {

                if (graph[current][j] != 0 &&
                        distance[current] + graph[current][j] < distance[j]) {

                    distance[j] =
                            distance[current] + graph[current][j];
                }
            }
        }

        System.out.println("Shortest distance:");
        System.out.println(distance[3]);

    }
}