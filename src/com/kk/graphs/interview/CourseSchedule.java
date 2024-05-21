package com.kk.directed.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(course).add(prerequisiteCourse);
        }

        // Array to track visited nodes
        boolean[] visited = new boolean[numCourses];

        // Array to track recursion stack (detect cycle)
        boolean[] recursionStack = new boolean[numCourses];

        // Perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adjList, visited, recursionStack))
                    return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> adjList, boolean[] visited, boolean[] recursionStack) {
        visited[course] = true;
        recursionStack[course] = true;

        for (int neighbor : adjList.get(course)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, adjList, visited, recursionStack))
                    return true;
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recursionStack[course] = false; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses? " + canFinish);
    }
}
