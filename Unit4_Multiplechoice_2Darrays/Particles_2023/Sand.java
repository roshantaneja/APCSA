import java.awt.Color;

public class Sand extends Particle
{

    public Sand()
    {
        super(ParticlesProgram.SAND, new Color((int)(Math.random() * 20) + 200, (int)(Math.random() * 20) + 200, (int)(Math.random() * 20) + 20));
    }

}
