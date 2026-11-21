/*
 ========================== binary exponentiation ============================
  ham jante h ---
  2 rashed to power 3 => 2 * 2 * 2 = 8 hota h 
  jisme 2 base hota h and 3 exponent hota h 
=================================================
Binary exponentiation rules --
agar kisi number ka power yani exponent ye sab hota h jaise ki ---
agar exponent 1 h to uska output always 1 hoga 
like 2 ka power 1 = 1 
like 3 ka power 1 = 1 etc 
----------------
agar power even hota h to usse ham aise likh sakte h jaise ki 
2

*/

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
