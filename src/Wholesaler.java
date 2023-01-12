public class Wholesaler{
    int id;
    String name;
    int p_id;
    int stock;
    int price;


    Wholesaler(int w, String x, int y, int z, int d){
        this.id = w;
        this.name = x;
        this.p_id = y;
        this.stock = z;
        this.price = d;
    }

    public void addStock(int x){
        this.stock = this.stock + x;
    }

    public void display(){
        System.out.println("\nWholesaler ---> id - "+this.id+"\tname - "+this.name+"\tproduct id - "+this.p_id+"\tstock - "+this.stock+"\tprice - "+this.price);
    }

    public void reduce_stock(int x){
        this.stock = this.stock - x;
    }
}
