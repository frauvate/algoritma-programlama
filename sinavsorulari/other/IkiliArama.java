package sinavsorulari.other;

public class IkiliArama {

    // Binary search recursive method
    public static int binarySearch(int[] array, int target, int left, int right) {
        // Base condition: if the range is invalid, the target is not found
        if (left > right) {
            return -1;
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Check if the target is at the middle index
        if (array[mid] == target) {
            return mid;
        }

        // If the target is smaller, search in the left half
        if (target < array[mid]) {
            return binarySearch(array, target, left, mid - 1);
        }

        // If the target is larger, search in the right half
        return binarySearch(array, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch(array, target, 0, array.length - 1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}