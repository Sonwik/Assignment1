import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1
        //System.out.println("Ex 1 (n=4): " + sumSquares(4));

        // 2
        //int[] testArray = {1, 2, 3, 4, 5};
        //System.out.println("Ex 2 (sum of array): " + sumArray(testArray, 5));

        // 3
        //System.out.println("Ex 3 (n=10): " + sumN(10));

        // 4
        //System.out.println("Ex 4 (b=4, n=3): " + sumPowers(4, 3));

        // 5
        // System.out.println("Ex 5 ():");
        // reverseSequence(sc.nextInt(), sc);

        // 6
        // System.out.println("\nEx 6 ():");
        // reverseStrings(sc.nextInt(), sc);

        // 7
        System.out.println("\nEx 7 (Spiral 3x3):");
        int n7 = 3;
        int[][] matrix = new int[n7][n7];
        fillSpiral(matrix, 1, 0, 0, n7);
        for (int i = 0; i < n7; i++) {
            for (int j = 0; j < n7; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        // 8
        //System.out.println("\nEx 8 (n=2, k=3):");
        //allSequences(2, 3, "");

        // 9
        //System.out.println("\nEx 9 (Permutations of AB):");
        //permutations("AB", "");
        // 10
        //System.out.println("\nEx 10:");
        //int num1 = 16;
        //System.out.println(num1 + " is power of two? " + isPowerOfTwo(num1));
        //int num2 = 10;
        //System.out.println(num2 + " is power of two? " + isPowerOfTwo(num2));
    }

    // 1
    public static int sumSquares(int n) {
        if (n == 1) return 1;
        return (n * n) + sumSquares(n - 1);
    }

    // 2
    public static int sumArray(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    // 3
    public static int sumN(int n) {
        if (n <= 1) return n;
        return n + sumN(n - 1);
    }

    // 4
    public static int sumPowers(int b, int n) {
        if (n == 0) return 1;
        int power = 1;
        for(int i = 0; i < n; i++) power *= b;
        return power + sumPowers(b, n - 1);
    }

    // 5
    public static void reverseSequence(int n, Scanner sc) {
        if (n == 0) return;
        int val = sc.nextInt();
        reverseSequence(n - 1, sc);
        System.out.print(val + " ");
    }

    // 6
    public static void reverseStrings(int n, Scanner sc) {
        if (n == 0) return;
        char[] currentStr = sc.next().toCharArray();
        reverseStrings(n - 1, sc);
        System.out.println(String.valueOf(currentStr));
    }

    // 7
    public static void fillSpiral(int[][] mat, int v, int r, int c, int size) {
        if (size <= 0) return;
        if (size == 1) { mat[r][c] = v; return; }
        for (int i = 0; i < size - 1; i++) mat[r][c + i] = v++;
        for (int i = 0; i < size - 1; i++) mat[r + i][c + size - 1] = v++;
        for (int i = 0; i < size - 1; i++) mat[r + size - 1][c + size - 1 - i] = v++;
        for (int i = 0; i < size - 1; i++) mat[r + size - 1 - i][c] = v++;
        fillSpiral(mat, v, r + 1, c + 1, size - 2);
    }

    // 8
    public static void allSequences(int n, int k, String res) {
        if (n == 0) {
            System.out.println(res);
            return;
        }
        for (int i = 1; i <= k; i++) {
            allSequences(n - 1, k, res + i);
        }
    }

    // 9
    public static void permutations(String str, String res) {
        if (str.isEmpty()) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permutations(remaining, res + ch);
        }
    }

    // 10
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }


    }
