package com.ik.graph.interview.problems;

import java.util.ArrayList;

public class CycleDetectionUsingAdjacencyLiist {
	
	
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V]; // Array to keep track of visited vertices
        // Perform DFS traversal from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i] && hasCycle(i, -1, visited, adj)) // Check for cycle starting from vertex i
                return true;
        }
        return false;
    }

    // Helper function for DFS traversal to detect cycle
    private boolean hasCycle(int v, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true; // Mark current vertex as visited
        // Traverse all adjacent vertices
        for (int u : adj.get(v)) {
            // If adjacent vertex is not visited, recursively visit it
            if (!visited[u]) {
                if (hasCycle(u, v, visited, adj)) // Recursively check for cycle in adjacent vertices
                    return true;
            }
            // If adjacent vertex is visited and is not parent of current vertex, then cycle exists
            else if (u != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        // below is another input 
        
        int[][] adjArray = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};

        // Convert the array to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int[] neighbors : adjArray) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int neighbor : neighbors) {
                list.add(neighbor);
            }
            adj1.add(list);
        }
        CycleDetectionUsingAdjacencyLiist cycleDetection = new CycleDetectionUsingAdjacencyLiist();
        boolean hasCycle = cycleDetection.isCycle(V, adj1);
        System.out.println("Graph has cycle: " + hasCycle);
    }

}
