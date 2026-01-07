package com.personal.toolkit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class ZohoService {

    private static final int TOTAL_MINUTES = 8 * 60;

    public String calculateTimeLeft(String inputTime) {
        try {
            String[] timeSplit = inputTime.replaceAll("[.]", ":").split(":");
            int totalMinutes = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);

            int minutesLeft = TOTAL_MINUTES - totalMinutes;

            return String.format("%d hour%s %d minute%s",
                    minutesLeft / 60,
                    minutesLeft / 60 > 1 ? "s" : "",
                    minutesLeft % 60,
                    minutesLeft % 60 > 1 ? "s" : "");
        } catch (NumberFormatException e) {
            log.error("Invalid time format: {}", inputTime);
            return "Invalid time format";
        } catch (Exception e) {
            log.error("Error calculating time left", e);
            return "Error calculating time left" + e.getMessage();
        }
    }
    /**
     * Sorts a given input string of comma separated integers into ascending order
     * @param input e.g. "5,2,8,3,1,6,4"
     * @return a string of comma separated integers in ascending order
     */
    public String sortString(String input) {
        // break the string into an array of integers
        String[] inputs = input.split(",");
        int[] nums = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        // sort the array using merge sort
        int[] sorted = mergeSort(nums);

        // convert the sorted array back into a string
        StringBuilder sb = new StringBuilder();
        for (int num : sorted) {
            sb.append(num).append(",");
        }
        // remove the trailing comma
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * Recursively splits the array into two halves until it is broken down to arrays of length 1
     * @param nums the array to be split
     * @return the sorted array
     */
    private int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            // base case: if the array has only one element, return it as it is already sorted
            return nums;
        }

        // split the array into two halves
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        // merge the two halves
        return merge(left, right);
    }

    /**
     * Merges two sorted arrays into one sorted array
     * @param left the first sorted array
     * @param right the second sorted array
     * @return the merged sorted array
     */
    private int[] merge(int[] left, int[] right) {
        // create a new array to hold the merged array
        int[] result = new int[left.length + right.length];

        // initialize the counters for left, right and result arrays
        int i = 0, j = 0, k = 0;

        // loop until one of the arrays is exhausted
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                // if the element in the left array is smaller, add it to the result array
                result[k++] = left[i++];
            } else {
                // if the element in the right array is smaller, add it to the result array
                result[k++] = right[j++];
            }
        }

        // add any remaining elements in the left array to the result array
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // add any remaining elements in the right array to the result array
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
