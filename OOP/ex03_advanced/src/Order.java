import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> itemsList = new ArrayList<MenuItem>();
    private Date timeOrder;

    //setters
    public void setItemsList(ArrayList<MenuItem> itemsList) {
        this.itemsList = itemsList;
    }
    public void setTimeOrder(Date timeOrder) {
        this.timeOrder = timeOrder;
    }
    //getters
    public ArrayList<MenuItem> getItemsList() {
        return itemsList;
    }
    public Date getTimeOrder() {
        return timeOrder;
    }
    //methods
    public void addOrder(MenuItem item){
        itemsList.add(new MenuItem(item));
    }
    public void deleteOrder(MenuItem item){
        itemsList.remove(item);
    }
}
