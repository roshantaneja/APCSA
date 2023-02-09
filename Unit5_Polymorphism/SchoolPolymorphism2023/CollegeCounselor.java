

public class CollegeCounselor extends Employee implements Advisor
{

    public CollegeCounselor(String initialName)
    {
        super(initialName, 40000.00);
    }
    
    public void doWork(double hours){
        System.out.println(getName() + " wrote " + (4.0 * hours / 3) + " letters of reccomendation");
    }
    
    public void giveAdvice(Student student){
        System.out.println("Hey " + student.getName() + ", you should do well on your SATs!");
    }

}
