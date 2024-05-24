public class Purchases {
    private String name;
    private Integer price;

    public Purchases(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
