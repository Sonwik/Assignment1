public class QuickSort {
    public static void main(String[] args) {
        int[] dataset = {40, 38, 45, 51, 60, 78, 14, 98, 85, 55};
        int pivot = dataset[0];
        int i = 0;

        for (int j = 1; j < dataset.length; j++) {
            if (dataset[j] < pivot) {
                i++;
                int temp = dataset[i];
                dataset[i] = dataset[j];
                dataset[j] = temp;
            }
        }
        int temp = dataset[0];
        dataset[0] = dataset[i];
        dataset[i] = temp;

        System.out.println("After Partition (Pivot " + pivot + "): " + java.util.Arrays.toString(dataset));
    }
}