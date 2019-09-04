package House;

public class Room {

    private Couch theCouch;
    private LazyBoy theLazyBoy;

    public Room(Couch theCouch, LazyBoy theLazyBoy) {
        this.theCouch = theCouch;
        this.theLazyBoy = theLazyBoy;
    }

    public Couch getTheCouch() {
        return theCouch;
    }

    public LazyBoy getTheLazyBoy() {
        return theLazyBoy;
    }

    public void reclineLazyBoy() {
        theLazyBoy.reclineLazyBoy();
        relax();
    }

    private void relax() {
        System.out.println("relaxing");
    }

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Couch theCouch = new Couch("2208", "Dell", "240", dimensions);

        LazyBoy theLazyBoy = new LazyBoy("blue", dimensions);

        Room theRoom = new Room(theCouch, theLazyBoy);
        theRoom.getTheCouch().getColor();
        theRoom.getTheLazyBoy().reclineLazyBoy();
        theRoom.reclineLazyBoy();

    }
}
