public class DoughnutTray {
    private final int fulltray = 100;
    private int numDoughtnuts;
    private DoughnutTray doughnutTray;
    public DoughnutTray(int numDoughtnuts){
        this.numDoughtnuts = numDoughtnuts;
    }
    public void refill(){
        this.numDoughtnuts = fulltray;
    }

}
