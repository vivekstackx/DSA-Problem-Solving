class Solution {

    private double powerOfNumber(double base, long exponent) {
        if (exponent == 0) return 1;

        // Compute positive power first, then take reciprocal once at the end
        if (exponent < 0) {
            return 1 / powerOfNumber(base, -exponent);
        }

        // If exponent is even
        if (exponent % 2 == 0) {
            return powerOfNumber(base * base, exponent / 2);
        }

        // If exponent is odd
        return base * powerOfNumber(base * base, (exponent - 1) / 2);
    }

    public double myPow(double x, int n) {
        return powerOfNumber(x, (long) n);
    }
}
