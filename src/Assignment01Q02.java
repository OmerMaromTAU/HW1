public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int numberOfSummands = Integer.parseInt(args[0]);

        for (int i = 0; i < numberOfSummands; i++) {
            double summand = 1.0 / (1 + 2 * i);
            if (i % 2 == 0) {
                approxPi += summand;
            } else {
                approxPi -= summand;
            }
        }

        approxPi *= 4;

        System.out.println(approxPi + " " + actualPi);
    }
}
