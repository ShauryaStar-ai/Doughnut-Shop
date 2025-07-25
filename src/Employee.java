public class Employee extends Thread {
    /*Each object in the employee needs to have a name and acess to the tray */
    private String name;
    private DoughnutTray tray;
    // Empoyess constrcutror
    public Employee(String name, DoughnutTray tray) { // Pass shared tray to Employee
        this.name = name;
        this.tray = tray;
    }
    // Run meathod were the employee try to take doughnuts
    @Override
    public void run() {
        System.out.println(name + " is trying to get a donut 🍩");
        try {
            Thread.sleep(2000); // simulate time to grab donut
            boolean gotDonut = tray.takeDonut(this.name); // where the doughtnut really got take or not
            /*Telling the user what happend from the call to the function takeDoughnut*/

            if (!gotDonut) { //could not get doughnut
                System.out.println(name + " found no donuts and leaves 😞");
                if (DoughnutTray.getInstance().getNumDoughtnuts() < 0){ DoughnutTray.getInstance().refill(); //filling thr try if inned
                    System.out.println("The tray was empty therefore we refilled it");
                }
                return;  // exit thread leave no need to do more work
            } else {
                System.out.println(name + " took a donut for YOUUUUUU! 🍩😋");
            }

        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted!");

        }
        finally {
            System.out.println("Thanks for waiting 🫂 ");
            //later close the lock when you would play with that
        }


    }


}
