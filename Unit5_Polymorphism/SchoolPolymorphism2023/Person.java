
public abstract class Person
{
    public String name;
    
    public Person(String initialName){
        name = initialName;
    }
    
    public String getName(){
        return(name);
    }
    
    public abstract void doWork(double hours);
}
