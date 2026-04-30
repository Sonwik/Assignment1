public class Hashing {
    public static void main(String[] args) {
        int[] dataset = {40, 38, 45, 51, 60, 78, 14, 98, 85, 55};
        Integer[] table = new Integer[7];

        for (int key : dataset) {
            int index = key % 7; // h(k) = k mod 7
            while (table[index] != null) {
                index = (index + 1) % 7;
            }
            table[index] = key;
        }
        System.out.println("Hash Table: " + java.util.Arrays.toString(table));
    }
}