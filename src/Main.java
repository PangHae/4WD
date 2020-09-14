public class Main {

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Player p1 = new Player(10,10,10, inv);
        Commands cmd = new Commands();
    }
}
