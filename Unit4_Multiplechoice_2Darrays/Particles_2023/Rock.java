import java.awt.Color;

public class Rock extends Particle
{
    
    public Rock()
    {
        super(ParticlesProgram.ROCK, new Color((int)(Math.random() * 20) + 150, (int)(Math.random() * 20) + 150, (int)(Math.random() * 20) + 150));
    }

}
