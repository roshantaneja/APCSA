

public class Student extends Person
{
    public Student(String initialName)
    {
        super(initialName);
    }
    
    public void doWork(double hours){
        System.out.println(super.getName() + " completed " + 2 * hours + " homeworks");
    }
    
    public boolean doesComplainAboutTests(){
        return true;
    }
}
