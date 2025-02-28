package Startup.Coding;

import java.util.*;

// Time Complexity - O(N^3)
public class BasicOptimizationApproach {
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of airports

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());


        // Input travel costs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cost = sc.nextInt();
                if (i != j) {
                    adj.get(i).add(new int[]{cost, j}); // Store (cost, destination)
                }
            }
        }

        // Sort each adjacency list based on cost (smallest first)
        for (int i = 0; i < n; i++) {
            adj.get(i).sort(Comparator.comparingInt(a -> a[0]));
        }

        int minCost = INF;
        int bestA = -1, bestB = -1, bestC = -1, bestD = -1;

        // Step 2: Iterate over all edges (B, C)
        for (int B = 0; B < n; B++) {
            for (int C = B + 1; C < n; C++) {
                int costBC = INF;
                for (int[] p : adj.get(B)) {
                    if (p[1] == C) {
                        costBC = p[0];
                        break;
                    }
                }


                if (costBC == INF) continue; // No direct edge between B and C

                // Get top 4 minimum-cost neighbors for B (excluding C)
                List<int[]> topB = new ArrayList<>();
                for (int[] p : adj.get(B)) {
                    if (p[1] != C) topB.add(p);
                    if (topB.size() == 4) break;
                }

                // Get top 4 minimum-cost neighbors for C (excluding B)
                List<int[]> topC = new ArrayList<>();
                for (int[] p : adj.get(C)) {
                    if (p[1] != B) topC.add(p);
                    if (topC.size() == 4) break;
                }

                // Try all combinations of A from B's top 4 and D from C's top 4
                for (int[] a : topB) {
                    for (int[] d : topC) {
                        int A = a[1], D = d[1];
                        if (A == B || A == C || A == D) continue;
                        if (D == B || D == C || D == A) continue;

                        int totalCost = a[0] + costBC + d[0];
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

