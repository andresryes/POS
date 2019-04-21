package Models;

public class TransactionDetail {
    private int idDetail;
    private int quantity;
    private Product product;
    private double subtotal;

    public TransactionDetail(int idDetail, int quantity, Product product, double subtotal) {
        this.idDetail = idDetail;
        this.quantity = quantity;
        this.product = product;
        this.subtotal = subtotal;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
