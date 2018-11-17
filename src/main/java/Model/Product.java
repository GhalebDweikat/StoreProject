package Model;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private String price;

    public Product(int productId, String productName, String productDescription, String price){
        this.productId = productId;
        this.price = price;
        this.productDescription = productDescription;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
