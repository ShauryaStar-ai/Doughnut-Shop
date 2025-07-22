public class Employee extends Thread {
    private String name;
    private DoughnutTray tray;

    public Employee(String name, DoughnutTray tray) { // Pass shared tray to Employee
        this.name = name;
        this.tray = tray;
    }

    @Override
    public void run() {
        System.out.println(name + " is trying to get a donut 🍩");
        try {
            Thread.sleep(2000); // simulate time to grab donut
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted!");
            return;
        }

        synchronized (tray) { // lock shared tray
            if (tray.numDonuts > 0) {
                tray.numDonuts--;
                System.out.println(name + " grabbed a donut 🍩. Donuts left: " + tray.numDonuts);
            } else {
                System.out.println(name + " found no donuts 😭 Waiting for refill...");
            }
        }
    }

    // Your renamed start() method
    public void getDoughNut() {
        this.start();
    }
}
