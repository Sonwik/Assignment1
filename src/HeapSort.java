public class HeapSort {
    public static void main(String[] args) {
        int[] dataset = {40, 38, 45, 51, 60, 78, 14, 98, 85, 55};
        buildMaxHeap(dataset);
        System.out.println("State after Heapify: " + java.util.Arrays.toString(dataset));

        int max = dataset[0];
        dataset[0] = dataset[dataset.length - 1];
        System.out.println("Extracted Max: " + max);
    }

    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}