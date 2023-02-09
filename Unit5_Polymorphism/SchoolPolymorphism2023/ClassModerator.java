

public class ClassModerator extends Teacher implements Advisor
{

    public ClassModerator(String initialName)
    {
        super(initialName);
    }
    
    public void giveAdvice(Student student){
        System.out.println("Hey " + student.getName() + ", you should clean up and work together");
    }

}
