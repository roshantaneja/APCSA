
import acm.program.*;
import java.util.ArrayList;
import java.awt.Color;
import acm.graphics.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class SillyArrayListExample extends ConsoleProgram
{

    public void run()
    {
        ArrayList things = new ArrayList();
        
        things.add(new GRect(50, 100, 40, 18));
        things.add("Have a nice day");
        things.add(Color.magenta);
        things.add(new ZoomStudent("Lily", "Buckingham Palace"));
        things.add(MediaTools.loadAudioClip("fire.wav"));
        
        String str = (String)things.get(1);
        println(str);
        
        ((ZoomStudent)things.get(3)).setLocation("Westminster Abbey");
    }

}
