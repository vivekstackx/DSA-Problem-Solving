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
2⁸ = (2²)⁴ = (2*2)⁴
ab ham ise aise v likh sakte----
(base)⁸ = (base²)⁴ = (base * base)⁸/²
----------------
agr power odd hota h to use ham aise likh sakte h jaise ki 
2⁹ = 2 * 2⁸
  = 2 * (2 * 2)⁸/²
yani ki hamne odd ko even me convert kr diya 
ab ise ham aise v likh sakte h --
2⁹ = (base)⁹ = base * (base * base)⁹-¹/²

-------------
agr yadi power negative hota h to --
2-⁸ = 1/2⁸ 
dhyan dene vali baat ye h ki yanha pahle ye 8 power negative tha jo ab positive ban gya h 
to ham ise aise v likh sakte h 
1/(base)⁸ = fun(1/base , -8)
yanha pe -8 islie diya gya kyunki 
pahle ye number negative tha jo ab ye postive banana h to ek - laga denge to positive ho jayega
------
isme ek chij or h ham jab 1/2⁸ to pahle yanha ham resipocal pahle solve kr rhe h fir uske baad number solve kr rhe h yani 
ki 
1/2 pahle solve ho rha h fir uske baad 2⁸  solve ho rha h 
ham yanha aise v kr sakte h ki 
pahle hi han number ko solve kr le 
yani 1/2⁸ jo h isme jo denominator h usko pahle solve kr le yani ki 2⁸ = 256 pahle solve kr lenge fir uske baad 
1/256 kr denge 

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
