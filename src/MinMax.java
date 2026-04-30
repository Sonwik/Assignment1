public class MinMax {
    static class Pair {
        int min;
        int max;
    }

    public static void main(String[] args) {
        int[] dataset = {40, 38, 45, 51, 60, 78, 14, 98, 85, 55};

        Pair result = findMinMax(dataset, 0, dataset.length - 1);

        System.out.println("Maximum Element: " + result.max);
        System.out.println("Minimum Element: " + result.min);
        System.out.println("Range (Max - Min): " + (result.max - result.min));
    }

    public static Pair findMinMax(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair leftResult, rightResult;

        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result.max = arr[low];
                result.min = arr[high];
            } else {
                result.max = arr[high];
                result.min = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;
        leftResult = findMinMax(arr, low, mid);
        rightResult = findMinMax(arr, mid + 1, high);

        result.max = Math.max(leftResult.max, rightResult.max);
        result.min = Math.min(leftResult.min, rightResult.min);

        return result;
    }
}