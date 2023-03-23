
public class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce(); // Hooray!  Fractions automatically reduce themselves.
    }
    
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
        this.reduce();
    }

    /**  This method automatically reduces the fraction, using
     *   a "greatest common factor" method discovered by Euclid.
     *   (How cool and historic!)
     */
    private void reduce()
    {
        int gcf = numerator;
        int temp = denominator;
        while (temp != 0) 
        {
            if (gcf > temp)
                gcf -= temp;
            else
                temp -= gcf;
        }        
        numerator /= gcf;
        denominator /= gcf;        
    }
    
    public Fraction add(Fraction f) {
        Fraction result = new Fraction(this.numerator * f.getDenominator() + f.getNumerator() * this.denominator, this.denominator * f.getDenominator());
        result.reduce();
        return result;
    }
    
    public Fraction multiply(Fraction f){
        Fraction result = new Fraction(this.numerator * f.getNumerator(), this.denominator * f.getDenominator());
        result.reduce();
        return result;
    }
    
    public Fraction divide(Fraction f){
        Fraction result = new Fraction(this.numerator * f.getDenominator(), this.denominator * f.getNumerator());
        result.reduce();
        return result;
    }
    
    public Fraction reciprocal(){
        Fraction result = new Fraction(this.denominator, this.numerator);
        result.reduce();
        return result;
    }
    
    public Fraction cubed(){
        Fraction result = this.multiply(this).multiply(this);
        result.reduce();
        return result;
    }
    
    public String toString(){
        return(this.numerator + "/" + this.denominator);
    }
    
    public int getNumerator(){
        return numerator;
    }
    
    public int getDenominator(){
        return denominator;
    }

}