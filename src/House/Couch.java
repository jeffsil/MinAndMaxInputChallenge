package House;

public class Couch {
    private String model;
    private String manufacturer;
    private String color;
    private Dimensions dimensions;

    public Couch(String model, String manufacturer, String color, Dimensions dimensions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
        this.dimensions = dimensions;
    }

    public void recline() {
        System.out.println("Reclining");
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
