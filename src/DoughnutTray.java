public class DoughnutTray {
    private static final int fulltray = 100; // constant meaning that if the tray is gonna
    // be full there would be 20 doughtnuts
    private static DoughnutTray instance = null; // so we start of the doughnut tray not ebing there

    // this one attribute of the doughnut class in java
    private static int numDoughtnuts;

    // constructor which we made private
    private DoughnutTray(int numDoughtnuts){
        this.numDoughtnuts = numDoughtnuts;
    }

    // Public method to get the single instance
    public static  DoughnutTray getInstance() { // would later put lock and  synchronized for thread safety
        if (instance == null) {
            instance = new DoughnutTray(fulltray);
        }
        return instance;
    }
    // one  for the doughnut tray
    public void refill(){
        this.numDoughtnuts = fulltray;
    }
    public synchronized boolean takeDonut(String name) { // name of the emplyee taking the tray
        if (numDoughtnuts > 0) {
            numDoughtnuts--;
            System.out.println(name + " grabbed a donut 🍩. Donuts left: " + numDoughtnuts);
            return true;
        } else {
            System.out.println(name + " found no donuts 😭 Waiting for refill...");
            return false;
        }
    }


}
