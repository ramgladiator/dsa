package com.ik.graph.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgeListToAdjacencyList {
	
	public static Map<Integer, List<Integer>> convertEdgeListToAdjacencyList(List<int[]> edgeList) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Iterate through each edge and update the adjacency list
        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            
            // Add vertex v to the adjacency list of vertex u
            if (!adjacencyList.containsKey(u)) {
                adjacencyList.put(u, new ArrayList<>());
            }
            adjacencyList.get(u).add(v);
            
            // Add vertex u to the adjacency list of vertex v (assuming it's an undirected graph)
            if (!adjacencyList.containsKey(v)) {
                adjacencyList.put(v, new ArrayList<>());
            }
            adjacencyList.get(v).add(u);
        }
        
        return adjacencyList;
    }

    public static void main(String[] args) {
        List<int[]> edgeList = new ArrayList<>();
        edgeList.add(new int[]{0, 1});
        edgeList.add(new int[]{0, 2});
        edgeList.add(new int[]{1, 3});
        edgeList.add(new int[]{2, 3});
        edgeList.add(new int[]{3, 4});

        Map<Integer, List<Integer>> adjacencyList = convertEdgeListToAdjacencyList(edgeList);

        // Print the adjacency list
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer vertex : entry.getValue()) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

}
