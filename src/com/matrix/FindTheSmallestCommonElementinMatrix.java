package com.kk.matrix;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
public class FindTheSmallestCommonElementinMatrix {




    /*To find the smallest common element in all rows of a matrix, you can follow these steps:

    Iterate through each element of the first row.
    For each element, check if it exists in all other rows.
    Keep track of the smallest common element found so far.*/

    public static int smallestCommonElement(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;

        Set<Integer> commonElements = new HashSet<>();
        // Add all elements of the first row to the set
        for (int num : matrix[0]) {
            commonElements.add(num);
        }

        // Iterate through remaining rows
        for (int i = 1; i < matrix.length; i++) {
            Set<Integer> rowElements = new HashSet<>();
            // Add all elements of the current row to a temporary set
            for (int num : matrix[i]) {
                rowElements.add(num);
            }

            // Retain only the elements present in both sets
            commonElements.retainAll(rowElements);

            // If common elements set becomes empty, no need to continue
            if (commonElements.isEmpty())
                return -1;
        }

        // Find the smallest element in the common elements set
        int smallest = Integer.MAX_VALUE;
        for (int num : commonElements) {
            smallest = Math.min(smallest, num);
        }

        return smallest;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6}
        };
        int smallestCommon = smallestCommonElement(matrix);
        if (smallestCommon != -1) {
            System.out.println("Smallest common element: " + smallestCommon);
        } else {
            System.out.println("No common element found.");
        }
    }
}
