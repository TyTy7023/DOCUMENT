import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> listProducts;
    private int quantity; 
    
    public Cart() {
        listProducts = new ArrayList<Product>();
    }
    //getter
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
    public int getQuantity() {
        return quantity;
    }
    //setter
    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //method
    public void addProduct(Product product, int quantity) {
        listProducts.add(product);
        listProducts.get(listProducts.indexOf(product)).setQuantity(quantity);
    }
    public void removeProduct(Product product) {
        int index = listProducts.indexOf(product);
        listProducts.remove(index);
    }
    public void totalPrice()
    {
        int sum=0;
        for(int i=0;i<listProducts.size();i++)
            sum=sum+(listProducts.get(i).price*listProducts.get(i).getQuantity());
        System.out.println("\tTotal price in your cart: "+sum);
    }
    
} 