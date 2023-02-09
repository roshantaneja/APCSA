

public abstract class Employee extends Person
{
    private double salary;
    
    public Employee(String initialName, double initialSalary)
    {
        super(initialName);
        salary = initialSalary;
    }
    
    public double getSalary(){
        return (salary);
    }
}
