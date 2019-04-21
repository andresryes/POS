package Models;

public class Customer {

    private int idCustomer;
    private String name;
    private String address;
    private String nit;

    public Customer(int idCustomer, String name, String address, String nit) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.address = address;
        this.nit = nit;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
