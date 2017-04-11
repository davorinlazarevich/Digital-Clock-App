import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

/**
 * Created by Davorin on 4/11/2017.
 */
public class DigitalClock extends Applet implements Runnable {
    Thread t = null;
    String timeString = "";

    public void start() {
        t = new Thread( this );
        t.start();
    }

    public void run() {
        try {
            while (true) {
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");

                Date date = Calendar.getInstance().getTime();
                timeString = formatter.format(date);//receives Date and returns String

                repaint();//invokes the paint method
                t.sleep( 1000 );  // interval given in milliseconds
            }
        }
        catch (Exception e) { }
    }

    public void paint( Graphics g ) {
        g.drawString( timeString, 10, 10 );
    }

}
