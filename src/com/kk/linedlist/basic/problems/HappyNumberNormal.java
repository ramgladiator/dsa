package com.kk.linedlist.basic.problems;

import java.util.HashSet;
import java.util.Set;

// T(C) :O(n) and S(C):O(1)
public class HappyNumberNormal {

    public static boolean isHappy(int num) {
        Set<Integer> seenNumbers = new HashSet<>();

        while (num != 1 && !seenNumbers.contains(num)) {
            seenNumbers.add(num);
            num = calculateSumOfSquares(num);
        }

        return num == 1;
    }

    private static int calculateSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example usage:19
        int numberToCheck = 12; // You can change this to any number you want to check
        if (isHappy(numberToCheck)) {
            System.out.println(numberToCheck + " is a happy number!");
        } else {
            System.out.println(numberToCheck + " is not a happy number.");
        }
    }
}
