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
            boolean gotDonut = tray.takeDonut(name);
            if (!gotDonut) {
                System.out.println(name + " found no donuts and leaves 😞");
                return;  // exit thread
            } else {
                System.out.println(name + " took a donut and is happy! 🍩😋");
            }

        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted!");

        }
        finally {
            System.out.println("Thanks for waiting ");
            //later close the lock when you would play with that
        }


    }

    // Your renamed start() method
    public void getDoughNut() {
        this.start();
    }
}
