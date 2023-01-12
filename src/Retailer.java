public class Retailer{
    int id;
    String name;
    int w_id;
    int stock;
    int price;


    Retailer(int w, String x, int y, int z, int d){
        this.id = w;
        this.name = x;
        this.w_id = y;
        this.stock = z;
        this.price = d;
    }

    public void display(){
        System.out.println("\nRetailer ---> id - "+this.id+"\tname - "+this.name+"\twholesaler id - "+this.w_id+"\tstock - "+this.stock+"\tprice - "+this.price);
    }

    public void addStock(int x){
        this.stock = this.stock + x;
    }
}
