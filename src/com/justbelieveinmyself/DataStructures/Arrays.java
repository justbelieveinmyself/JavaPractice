package DataStructures;

public class Arrays {
    public static void main(String[] args) {
        String[] names = {"Dmitry", "Nikita", "Vadim", "Ilya", "Daniel"};
        System.out.println(java.util.Arrays.toString(names));
        System.out.println("------------------------");
        for(int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }
        System.out.println("------------------------");
        System.out.println("Using foreach or enhanced for");
        int j = 10;
        for(String name : names)
        {
            j = 16;
            name = "null";
            System.out.println(name);
        }
        System.out.println(j);
        System.out.println("------------------------");
        System.out.println("Lets copy array");
        String[] copyOfNames = java.util.Arrays.copyOf(names, names.length * 2);
        for(String copiedName : copyOfNames)
        {
            System.out.println(copiedName);
        }
        System.out.println("------------------------");
        System.out.println("Sorting names");
        java.util.Arrays.sort(names);
        for(String name : names)
        {
            System.out.println(name);
        }
        System.out.println("------------------------");
        System.out.println("Two-dimensional array");
        //int[][] prices = new int[3][3];
        int[][] prices = new int[][]{
                {6, 5, 4},
                {1, 2, 3},
                {7, 8, 9}
        };
        for(int[] price : prices){
            java.util.Arrays.sort(price);
            for(int p : price){
                System.out.print(p);
            }
            System.out.println();
        }
        // Sorting each row in ascending order
        for (int i = 0; i < prices.length; i++) {
            java.util.Arrays.sort(prices[i]);
        }
        java.util.Arrays.sort(prices, (a, b) -> Integer.compare(a[0],b[0]));
        // Printing the sorted array
        for (int[] row : prices) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println("------------------------");
        System.out.println("Ragged array");
        double[][][] doubles = new double[3][][];
        doubles[0] = new double[1][3];
        doubles[1] = new double[2][3];
        doubles[2] = new double[3][3];
        for(double[][] d : doubles)
        {
            for(double[] dArray : d) {
                java.util.Arrays.fill(dArray, 4.5);
            }
        }
        for(double[][] d : doubles)
        {
            for(double[] dArray : d) {
                System.out.println(java.util.Arrays.toString(dArray));
            }

        }
        //useless info
        int odd = 10;
        System.out.printf("%3d", odd);
    }

}