package Models;

public class Product {

    private int idProduct;
    private int stock;
    private double price;
    private Category category;
    private String image;
    private String name;
    private String description;

    public Product(int idProduct, int stock, double price, Category category, String image, String name, String description) {
        this.idProduct = idProduct;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double isPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
