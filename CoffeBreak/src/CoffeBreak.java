import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class CoffeBreak extends JFrame{
    private JPanel myPanel;
    private JLabel myLabel;
    private JButton btnOk;
    private JButton btnOff;


    MouseClicker mouse = new MouseClicker();
    public CoffeBreak() {
        setContentPane(myPanel);
        setResizable(false);
        setSize(300,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Runnable r = new MouseClicker();
        Thread hilomouse = new Thread(r);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilomouse.start();

            }
        });
        btnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             hilomouse.stop();

            }
        });
    }
    class MouseClicker implements Runnable {


        @Override
        public void run() {
            Point currect = MouseInfo.getPointerInfo().getLocation();

            try {
                Robot bot = new Robot();

                while (true) {
                    bot.mouseMove(currect.x - 15, currect.y+20);
                    Thread.sleep(10000);
                    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    bot.mouseMove(currect.x + 15, currect.y-20);
                    bot.mouseMove(currect.x, currect.y);


                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main (String args[]){
        CoffeBreak cf = new CoffeBreak();

    }
}
