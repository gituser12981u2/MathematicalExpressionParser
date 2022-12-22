package RecursiveCalculator;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    
    /** 
     * @param other
     * @return Fraction
     */
    public Fraction add(Fraction other) {
        int lcm = lcm(this.denominator, other.denominator);
        int a = lcm / this.denominator;
        int b = lcm / other.denominator;
        return new Fraction(this.numerator * a + other.numerator * b, lcm);
    }

    
    /** 
     * @param other
     * @return Fraction
     */
    public Fraction subtract(Fraction other) {
        int lcm = lcm(this.denominator, other.denominator);
        int a = lcm / this.denominator;
        int b = lcm / other.denominator;
        return new Fraction(this.numerator * a - other.numerator * b, lcm);
    }

    
    /** 
     * @param other
     * @return Fraction
     */
    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    
    /** 
     * @param other
     * @return Fraction
     */
    public Fraction divide(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    
    /** 
     * @param a
     * @param b
     * @return int
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    
    /** 
     * @param a
     * @param b
     * @return int
     */
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }
}
