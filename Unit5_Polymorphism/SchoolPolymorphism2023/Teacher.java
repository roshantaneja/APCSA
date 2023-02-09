

public class Teacher extends Employee
{

    public Teacher(String initialName)
    {
        super(initialName, 30000.00);
    }
    
    public void doWork(double hours){
        System.out.println(getName() + " graded " + (3*hours) + " papers");
    }
    
}
