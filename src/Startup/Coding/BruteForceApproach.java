package Startup.Coding;

import java.util.*;

class BruteForceApproach {
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of airports

        int[][] cost = new int[n][n];

        // Input travel costs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int minCost = INF;
        int bestA = -1, bestB = -1, bestC = -1, bestD = -1;

        // Brute force all possible (A, B, C, D) combinations
        for (int A = 0; A < n; A++) {
            for (int B = 0; B < n; B++) {
                if (A == B) continue;
                for (int C = 0; C < n; C++) {
                    if (C == A || C == B) continue;
                    for (int D = 0; D < n; D++) {
                        if (D == A || D == B || D == C) continue;

                        // Ensure direct travel between A → B → C → D exists
                        if (cost[A][B] == INF || cost[B][C] == INF || cost[C][D] == INF) continue;

                        int totalCost = cost[A][B] + cost[B][C] + cost[C][D];

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