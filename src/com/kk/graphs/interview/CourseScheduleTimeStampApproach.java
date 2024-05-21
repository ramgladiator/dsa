package com.kk.directed.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleTimeStampApproach {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        boolean[] visited = new boolean[numCourses];
        int[] arrivalTime = new int[numCourses];
        int[] departureTime = new int[numCourses];
        int time = 0;

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adjList, visited, arrivalTime, departureTime, time))
                    return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> adjList, boolean[] visited,
                             int[] arrivalTime, int[] departureTime, int time) {
        visited[course] = true;
        arrivalTime[course] = time++;//while visiting a node we will set arrival time

        for (int neighbor : adjList.get(course)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, adjList, visited, arrivalTime, departureTime, time))
                    return true;
            } else {
                if (departureTime[neighbor] == 0) {
                    return true; // Cycle detected
                }
            }
        }

        departureTime[course] = time++;//while departure the node we will set departure time
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleTimeStampApproach courseSchedule = new CourseScheduleTimeStampApproach();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses? " + canFinish);
    }
}
