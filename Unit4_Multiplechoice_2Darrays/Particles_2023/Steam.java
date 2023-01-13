import java.awt.Color;

public class Steam extends Particle
{
    int age;
    public Steam()
    {
        super(ParticlesProgram.STEAM, new Color((int)(Math.random() * 20) + 230, (int)(Math.random() * 20) + 230, (int)(Math.random() * 20) + 230));
        age = 0;
    }
    
    public void increment(){
        age ++;
    }
    
    public boolean hasCondensed(){
        return age > 100;
    }

}
