public class BinarySearch {
    public static void main(String[] args) {
        int[] dataset = {14, 38, 40, 45, 51, 55, 60, 78, 85, 98}; // Pre-sorted
        int target = 45;
        int low = 0, high = dataset.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("Low: %d, High: %d, Mid: %d, Value: %d%n", low, high, mid, dataset[mid]);

            if (dataset[mid] == target) {
                System.out.println("Found 45!");
                break;
            } else if (dataset[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
    }
}