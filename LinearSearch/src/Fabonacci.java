public class Fabonacci {
    public static void main(String[] args) {
        System.out.println("Simple loop fabonacci");
        fabonacci(10);
        System.out.println("\nrecursion loop fabonacci");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    public static void fabonacci(int n) {
        int first = 0;
        int second = 1;
        int next;
        for (int i = 0; i < n-2; i++) {
            if (first == 0 && second == 1) {
                System.out.print(first + " "+ second);
            }
            next = first + second;
            first = second;
            second = next;
            System.out.print(" " + next);
        }
    }

        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }


}
