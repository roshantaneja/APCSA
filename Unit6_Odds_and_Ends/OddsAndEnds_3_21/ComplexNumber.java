

public class ComplexNumber
{
    private double realPart;
    private double imagPart;
    
    public ComplexNumber(double realPart, double imagPart)
    {
        this.realPart = realPart;
        this.imagPart = imagPart;
    }
    
    public ComplexNumber(double realPart)
    {
        this.realPart = realPart;
        this.imagPart = 0;
    }
    
    /** This method adds together two complex numbers.
     Happy St. Patrick's Day!
     @param other the other complex number
     @return the sum of the two complex numbers
     */
    public ComplexNumber add(ComplexNumber other)
    {
        double realResult = this.realPart + other.realPart;
        double imagResult = this.imagPart + other.imagPart;
        ComplexNumber result = new ComplexNumber(realResult, imagResult);
        return result;
    }
    
    
    public ComplexNumber multiply(ComplexNumber other)
    {
       double realResult = this.realPart * other.realPart - 
                           this.imagPart * other.imagPart;
       double imagResult = this.realPart * other.imagPart + 
                           other.realPart * this.imagPart;
       return new ComplexNumber(realResult, imagResult);
    }
    
 
    public ComplexNumber squared()
    {
        return this.multiply(this);
    }
    
    @Override
    public String toString()
    {
        return this.realPart + " + " + this.imagPart + "i";
    }
}
