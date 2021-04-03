package JavaDemo;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        var timer = new Timer(1000, event -> {System.out.println("At the tone, the time is"
                + Instant.ofEpochMilli(event.getWhen()));
            Toolkit.getDefaultToolkit().beep();});
//        var timer = new Timer(1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
    static class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is"
                    + Instant.ofEpochMilli(event.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        }
    }

}
