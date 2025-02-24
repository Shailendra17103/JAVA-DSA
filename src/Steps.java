public class Steps {
    public static void main(String[] args) {
        Steps steps = new Steps();
        int num = 41; // You can replace this with any number you want to test
        int result = steps.numberOfSteps(num);
        System.out.println("Number of steps to reduce " + num + " to zero: " + result);
    }

    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if (num % 2 == 0) {
            return helper(num / 2, steps + 1);
        }
        return helper(num - 1, steps + 1);
    }
}
