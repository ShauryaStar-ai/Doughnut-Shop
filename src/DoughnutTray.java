import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DoughnutTray {
    /*Static so that so not assoicated with instance*/
    private static final int fulltray = 10;
    private static DoughnutTray instance = null; // null and then can be later access by singleton

    private int numDoughtnuts; //very specific to the instance

    // Constructor for the individual instane
    private DoughnutTray(int numDoughtnuts){
        this.numDoughtnuts = numDoughtnuts;
    }
    // Singleton
    public static DoughnutTray getInstance() {
        if (instance == null) {
            instance = new DoughnutTray(fulltray);
        }
        return instance;
    }
    /*Take doughnut from the tray and boolena return based on if the act was sucessful or not*/
    private final ReentrantLock lock = new ReentrantLock(); // we are taking matter in our own hands
    public boolean takeDonut(String name) {
        lock.lock();
        boolean gotLock = false;
        try {
            gotLock = lock.tryLock(1000, TimeUnit.MILLISECONDS); // Wait 1 second

            if (!gotLock) { //could not get the lock
                System.out.println("🚫 Someone else is taking the donut!");
                return false; // Exit early if couldn't get the lock
            }

            // 👇 This part runs only if we successfully acquired the lock
            System.out.println(name + " is getting doughnuts for you 🍩");

            // Simulate taking a donut
            if (numDoughtnuts > 0) {
                numDoughtnuts--;
                System.out.println(name + " took a donut. Donuts left: " + numDoughtnuts);
                return true;
            } else {
                System.out.println("No donuts left!");
                return false;
            }

        } catch (InterruptedException e) {
            System.out.println("❗ Interrupted while trying to get doughnuts.");
            return false;
        } finally {
            if (gotLock) {
                lock.unlock(); // Only unlock if we actually got the lock
            }
        }
    }

    /*Reffing the specfic instance of the object tray*/
    public void refill(){
        this.numDoughtnuts = fulltray;
    }
    /*Checking the number of dougnuts in the specific instance*/
    public int getNumDoughtnuts() {
        return numDoughtnuts;
    }
}
