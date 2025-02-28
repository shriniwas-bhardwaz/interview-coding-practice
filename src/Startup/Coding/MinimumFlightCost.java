package Startup.Coding;
import java.util.*;

// Time Complexity - O(N^2) - The Best approach
public class MinimumFlightCost {
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

        // Find top 4 minimum-cost neighbors for each airport in O(n²) total time
        List<int[]>[] topFourNeighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            topFourNeighbors[i] = findTopKNeighbors(directCosts[i], 4, i);
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

    // Find top k minimum cost neighbors in O(n) time
    private static List<int[]> findTopKNeighbors(int[] costs, int k, int selfIdx) {
        List<int[]> result = new ArrayList<>();

        // Make k passes to find the k minimal elements - O(kn) = O(n) since k is constant (4)
        boolean[] used = new boolean[costs.length];
        used[selfIdx] = true; // Skip self

        for (int i = 0; i < k; i++) {
            int minCost = INF;
            int minIdx = -1;

            // Find the next minimum cost edge
            for (int j = 0; j < costs.length; j++) {
                if (!used[j] && costs[j] < minCost) {
                    minCost = costs[j];
                    minIdx = j;
                }
            }

            if (minIdx != -1 && minCost != INF) {
                result.add(new int[]{minCost, minIdx});
                used[minIdx] = true;
            } else {
                break; // No more valid neighbors
            }
        }

        return result;
    }
}
