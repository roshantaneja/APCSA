import java.awt.Color;

public class Lava extends Particle
{
    int age;
    public Lava()
    {
        super(ParticlesProgram.LAVA, new Color((int)(Math.random() * 50) + 200, (int)(Math.random() * 20) + 50, (int)(Math.random() * 20) + 50));
        age = 0;
        // new Color((int)(Math.random() * 50) + 200, (int)(Math.random() * 20), (int)(Math.random() * 20))
    }
    
    public void increment(){
        age++;
    }
    
    public boolean hasHardened() {
        return age > 10000;
    }
}
