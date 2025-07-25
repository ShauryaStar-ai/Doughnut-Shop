/*My employees keep fighting because they all want to grab donuts from the same tray at once 😡.
Sometimes two people grab the same donut. Other times, no one restocks and the tray is empty!
Can you build me a little simulation to show how my staff can stop fighting and work in harmony?
I don’t care about your fancy ‘Java’ terms – I just want to see:**
 🍩 A tray where donuts are added & taken
👨‍🍳 A baker who refills donuts
👩‍💼👨‍💼 Staff who take donuts to serve customers
🚦 Everyone waiting their turn (no crashes!)
Make it fun, show me in the console, and prove it won’t crash if 10 people rush in.”*/
public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 🍩 Get the single shared doughnut tray (Singleton)
        DoughnutTray tray = DoughnutTray.getInstance();

        // 👷 Create employees, all sharing the same tray
        Employee bob = new Employee("Bob", tray);
        Employee alice = new Employee("Alice", tray);
        Employee john = new Employee("John", tray);

        // 🧵 Start threads (each employee will try to get a donut)
        System.out.println("The company has" + tray.getNumDoughtnuts());
        System.out.println("-----------------------------------------");
        System.out.println("");
        bob.start();
        alice.start();
        john.start();

        // Optional: Wait for all threads to finish
        /*bob.join();
        alice.join();
        john.join();*/

    }
}
