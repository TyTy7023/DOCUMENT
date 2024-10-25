public interface Payment {
    public void payBill(Waiter waiter, Order order);
 
    public  class Cash implements Payment{
        public void payBill(Waiter waiter,  Order order){
            waiter.totalBill(order);
            System.out.println("Pay by cash");
        }
    }
        public  class Card implements Payment{
        public void payBill(Waiter waiter,  Order order){
            waiter.totalBill(order);
            System.out.println("Pay by Credit Card");
        }
    }
}  