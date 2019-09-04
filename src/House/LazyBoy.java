package House;

public class LazyBoy {

    private String color;
    private Dimensions dimensions;

    public LazyBoy(String color, Dimensions dimensions) {
        this.color = color;
        this.dimensions = dimensions;
    }

    public void reclineLazyBoy() {
        System.out.println("Lazyboy reclining");
    }
    public String getColor() {
        return color;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

}
