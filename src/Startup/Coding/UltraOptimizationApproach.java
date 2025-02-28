package Startup.Coding;


import java.util.*;

// Time Complexity - O(N^2 LogN)
public class UltraOptimizationApproach {
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of airports

        // Direct lookup table for costs between airports - O(1) access
        int[][] directCosts = new int[n][n];

        // Fill the direct costs table - O(n²)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                directCosts[i][j] = sc.nextInt();
                if (i == j) {
                    directCosts[i][j] = INF; // No self-loops
                }
            }
        }

        // Precompute top 4 minimum-cost neighbors for each airport - O(n² log n)
        List<int[]>[] topFourNeighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            // Use PriorityQueue to efficiently extract minimum cost edges
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < n; j++) {
                if (i != j && directCosts[i][j] < INF) {
                    pq.offer(new int[]{directCosts[i][j], j}); // O(log n) insertion
                }
            }

            // Extract top 4 minimum cost neighbors - O(log n)
            topFourNeighbors[i] = new ArrayList<>();
            while (!pq.isEmpty() && topFourNeighbors[i].size() < 4) {
                topFourNeighbors[i].add(pq.poll());
            }
        }

        // Main algorithm to find the minimum cost path A -> B -> C -> D
        int minCost = INF;
        int bestA = -1, bestB = -1, bestC = -1, bestD = -1;

        // Iterate over all possible (B, C) pairs - O(n²)
        for (int B = 0; B < n; B++) {
            for (int C = 0; C < n; C++) {
                if (B == C || directCosts[B][C] == INF) continue; // Skip if no direct edge or same node

                int costBC = directCosts[B][C]; // O(1) lookup

                // Try all combinations of A from B's top 4 and D from C's top 4 - O(1)
                for (int[] edgeA : topFourNeighbors[B]) {
                    int A = edgeA[1];
                    int costAB = edgeA[0];

                    if (A == B || A == C) continue;

                    for (int[] edgeD : topFourNeighbors[C]) {
                        int D = edgeD[1];
                        int costCD = edgeD[0];

                        if (D == A || D == B || D == C) continue;

                        int totalCost = costAB + costBC + costCD;

                        if (totalCost < minCost) {
                            minCost = totalCost;
                            bestA = A;
                            bestB = B;
                            bestC = C;
                            bestD = D;
                        }
                    }
                }
            }
        }

        // Output the result
        if (minCost == INF) {
            System.out.println("No valid path found");
        } else {
            System.out.println("Minimum cost: " + minCost);
            System.out.println("Airports: " + bestA + " -> " + bestB + " -> " + bestC + " -> " + bestD);
        }

        sc.close();
    }
}

