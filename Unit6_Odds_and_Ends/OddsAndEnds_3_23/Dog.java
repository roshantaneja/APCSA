

public class Dog
{
    //private INSTANCE variables
    
    private String name;
    private int idNumber;
    
    //private STATIC (borg) variables
    
    private static int nextAvailableID = 100;

    public Dog(String name)
    {
        this.name = name;
        this.idNumber = Dog.nextAvailableID;
        Dog.nextAvailableID++;
    }
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return idNumber;
    }
    
    public static boolean isHappyToSeeYou(){
        return true;
    }

}
