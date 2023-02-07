

public class Magic8Ball implements Advisor
{
    public void giveAdvice(Student student){
        System.out.println("Hey " + student.getName() + ", you should ask again!");
    }
}
