package Startup.Coding;
import java.util.*;

public class TestingApproach {
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of airports

        // Cost table for direct flights
        int[][] costs = new int[n][n];

        // Fill cost table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = sc.nextInt();
                if (i == j) {
                    costs[i][j] = INF; // No self-loops
                }
            }
        }

        // Store the two cheapest outgoing flights for each airport
        int[][] top2Outgoing = new int[n][2];
        int[][] top2Costs = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(top2Outgoing[i], -1);
            Arrays.fill(top2Costs[i], INF);

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (costs[i][j] < top2Costs[i][0]) {
                    // Shift previous min to second place
                    top2Costs[i][1] = top2Costs[i][0];
                    top2Outgoing[i][1] = top2Outgoing[i][0];

                    top2Costs[i][0] = costs[i][j];
                    top2Outgoing[i][0] = j;
                } else if (costs[i][j] < top2Costs[i][1]) {
                    // New second min
                    top2Costs[i][1] = costs[i][j];
                    top2Outgoing[i][1] = j;
                }
            }
        }

        int minCost = INF;
        int bestA = -1, bestB = -1, bestC = -1, bestD = -1;

        // Try all possible B → C connections
        for (int B = 0; B < n; B++) {
            for (int C = 0; C < n; C++) {
                if (B == C || costs[B][C] == INF) continue; // B and C must be different

                int costBC = costs[B][C];

                for (int aIdx = 0; aIdx < 2; aIdx++) {
                    int A = top2Outgoing[B][aIdx];
                    if (A == -1 || A == B || A == C) continue; // Ensure unique selection

                    for (int dIdx = 0; dIdx < 2; dIdx++) {
                        int D = top2Outgoing[C][dIdx];
                        if (D == -1 || D == A || D == B || D == C) continue; // Ensure unique selection

                        // Skip if A → B or C → D were already considered before
                        if ((top2Outgoing[B][0] == A || top2Outgoing[B][1] == A) &&
                                (top2Outgoing[C][0] == D || top2Outgoing[C][1] == D)) {
                            continue;
                        }

                        int totalCost = top2Costs[B][aIdx] + costBC + top2Costs[C][dIdx];

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

