public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int numOdd = 0;
        int prev = 0;
        int prevPrev = 1;

        for (int i = 0; i < x; i++) {
            int curr = prev + prevPrev;

            System.out.print(curr);
            if (i < x - 1) {
                System.out.print(" "); // Make sure we don't print a trailing space
            }

            if (curr % 2 == 1) {
                numOdd++;
            }

            prevPrev = prev;
            prev = curr;
        }

        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
