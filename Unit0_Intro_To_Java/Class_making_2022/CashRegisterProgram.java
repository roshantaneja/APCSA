
import acm.program.*;

public class CashRegisterProgram extends ConsoleProgram
{

    public void run()
    {
        CashRegister register = new CashRegister();
        
        register.recordPurchase(29.50);
        register.recordPurchase(79.25);
        register.enterPayment(50);
        
        double change = register.getChange();
        println(change);
        register.reset();
     
    }


}
