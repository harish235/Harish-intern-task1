public class Products{
    private int id;
    private String name;
    private int stock;
    private int price;

    Products(){ }
    Products(int w, String x, int y, int z){
        this.id = w;
        this.name = x;
        this.stock = y;
        this.price = z;
    }

    public void reduce_stock(int x){
        this.stock = this.stock - x;
    }

    public void reduce_stock(Products p, int x){
        p.stock = p.stock - x;
    }

    public void display(){
        System.out.println("\nProducts ---> id - "+this.id+"\tname - "+this.name+"\tstock - "+this.stock+"\tprice - "+this.price);
    }
}