package pcInterface;

public class laptop {

    public void powerOn(){
        System.out.println("笔记本电脑开机");
    }

    public void powerOff(){
        System.out.println("笔记本电脑关机");
    }

    public void useDevice(USB usb) {
        usb.open();
        usb.close();
    }
}
