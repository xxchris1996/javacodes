package pcInterface;

public class DemoMain {
    public static void main(String[] args) {
        laptop lap = new laptop();
        lap.powerOn();

        Mouse mouse = new Mouse();
        USB usbMouse = new Mouse();
        Mouse mouse1 = (Mouse) usbMouse;
        lap.useDevice(mouse1);

        lap.powerOff(); 
    }
}
