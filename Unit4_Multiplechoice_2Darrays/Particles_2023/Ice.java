import java.awt.Color;

public class Ice extends Particle
{
    private int age;
    
    public Ice()
    {
        super(ParticlesProgram.ICE, Color.white);
        age = 0;
    }
    
    public void increment(){
        age ++;
    }
    
    public boolean hasMelted(){
        return (age >= 255);
    }
}
