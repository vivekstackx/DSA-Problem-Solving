
/*
 ========================== Binary Exponentiation ============================

 Ham jante h --

 2 raised to power 3 => 2 * 2 * 2 = 8 hota h.

 Jisme 2 base hota h aur 3 exponent hota h.

 ============================================================================
 Binary Exponentiation Rules
 ============================================================================

 1. Agar exponent 0 hota h to output always 1 hota h.

    Like:
    2 ka power 0 = 1
    3 ka power 0 = 1

 2. Agar exponent even hota h to use ham aise likh sakte h --

    2⁸ = (2²)⁴
       = (2 * 2)⁸/²

    Yani:

    base⁸ = (base * base)⁸/²

 3. Agar exponent odd hota h to use ham aise likh sakte h --

    2⁹ = 2 * 2⁸
       = 2 * (2 * 2)⁸/²

    Yani odd exponent ko even exponent mein convert kar dete h.

    Ise ham aise bhi likh sakte h --

    base⁹ = base * (base * base)⁽⁹⁻¹⁾/²

 4. Agar exponent negative hota h to --

    2⁻⁸ = 1 / 2⁸

    Dhyan dene wali baat ye h ki yahan exponent negative tha,
    lekin reciprocal lene ke baad exponent positive ho jata h.

    Ise ham aise bhi likh sakte h --

    1 / base⁸ = 1 / fun(base, -8)

    Yahan -8 isliye diya gaya kyunki original exponent negative tha.
    Uska positive power calculate karne ke liye -exponent kar denge.

 ---------------------------------------------------------------------------

 Isme ek chij aur h.

 Jab ham 1 / 2⁸ calculate karte h to hamare paas do options h.

 Pehla:
 1 / 2 ko pahle calculate karein aur uske baad power calculate karein.

 Dusra:
 Pahle denominator ko solve karein.

 Yani:
 2⁸ = 256

 Ab:
 1 / 256

 Ham dusre approach ka use kar sakte h, yani pahle power calculate
 kar lenge aur uske baad ek baar reciprocal le lenge.

 ============================================================================
*/

class Solution {

    private double powerOfNumber(double base, long exponent) {
        if (exponent == 0) return 1;

        // Agar exponent negative h
        if (exponent < 0) {
            return 1 / powerOfNumber(base, -exponent);
        }

        // Agar exponent even h
        if (exponent % 2 == 0) {
            return powerOfNumber(base * base, exponent / 2);
        }

        // Agar exponent odd h
        return base * powerOfNumber(base * base, (exponent - 1) / 2);
    }

    public double myPow(double x, int n) {
        return powerOfNumber(x, (long) n);
    }
}
