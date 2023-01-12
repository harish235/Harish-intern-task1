import java.io.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
//Parsing product csv file
        Scanner sc = new Scanner(new File("/Users/harish/IdeaProjects/TaskOne/Products.csv"));
        Products[] p = new Products[3];
        int i = 0;
        while (sc.hasNext())  //returns a boolean value
        {
            String curr_line = sc.next();
            String[] entities = curr_line.split(",");

            p[i] = new Products(Integer.parseInt(entities[0]), entities[1], Integer.parseInt(entities[2]), Integer.parseInt(entities[3]));
            i++;
        }
        sc.close();

//Parsing Wholesaler csv file
        Scanner sd = new Scanner(new File("/Users/harish/IdeaProjects/TaskOne/Wholesaler.csv"));
        Wholesaler[] w = new Wholesaler[3];
        i = 0;
        while (sd.hasNext())  //returns a boolean value
        {
            String curr_line = sd.next();
            String[] entities = curr_line.split(",");

            w[i] = new Wholesaler(Integer.parseInt(entities[0]), entities[1], Integer.parseInt(entities[2]), Integer.parseInt(entities[3]), Integer.parseInt(entities[4]));
            i++;
        }
        sd.close();

//Parsing Retailer csv file
        Scanner sr = new Scanner(new File("/Users/harish/IdeaProjects/TaskOne/Retailer.csv"));
        Retailer[] r = new Retailer[4];
        i = 0;
        while (sr.hasNext())  //returns a boolean value
        {
            String curr_line = sr.next();
            String[] entities = curr_line.split(",");
//            for ( String str: entities)
//            {
//                System.out.println(str);
//            }
            r[i] = new Retailer(Integer.parseInt(entities[0]), entities[1], Integer.parseInt(entities[2]), Integer.parseInt(entities[3]), Integer.parseInt(entities[4]));
            i++;
        }
        sr.close();
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println( "\n\t\tWelcome to Task - 1" );
            System.out.println( "\n\tSelect 1 for Product details" );
            System.out.println( "\n\tSelect 2 for Wholesaler details" );
            System.out.println( "\n\tSelect 3 for Retailer details" );
            System.out.println( "\n\tSelect 4 for updating wholesaler stock" );
            System.out.println( "\n\tSelect 5 for updating retailer stock" );
            System.out.println( "Select 6 for EXIT" );

            int op = s.nextInt( );
            switch( op )
            {
                case 1:
                    for(i=0;i<3;i++){
                        p[i].display();
                    }
                    break;
                case 2:
                    for(i=0;i<2;i++){
                        w[i].display();
                    }
                    break;
                case 3:
                    for(i=0;i<2;i++){
                        r[i].display();
                    }
                    break;
                case 4:
                    System.out.println( "\n\tEnter the wholesaler id : " );
                    int ch = s.nextInt();
                    ch = ch-1;
                    w[ch].display();
                    System.out.println("\n\tProduct details from inventory");
                    int pro_id = w[ch].p_id;
                    pro_id = pro_id - 1;
                    p[pro_id].display();
                    System.out.println( "\n\tEnter the qty of products to be purchased : ");
                    int qty = s.nextInt();
                    w[ch].addStock(qty);
                    p[pro_id].reduce_stock(qty);
                    w[ch].display();
                    p[pro_id].display();
                    break;
                case 5:
                    System.out.println( "\n\tEnter the retailer id : " );
                    int retailer_id = s.nextInt();
                    retailer_id = retailer_id-1;
                    r[retailer_id].display();
                    System.out.println("\n\tProduct details from Wholesaler");
                    int wholesale_pro_id = r[retailer_id].w_id;
                    wholesale_pro_id = wholesale_pro_id - 1;
                    w[wholesale_pro_id].display();
                    System.out.println( "\n\tEnter the qty of products to be purchased : ");
                    int p_qty = s.nextInt();
                    r[retailer_id].addStock(p_qty);
                    w[wholesale_pro_id].reduce_stock(p_qty);
                    w[wholesale_pro_id].display();
                    r[retailer_id].display();
                    break;
                case 6:
                    System.exit( 0 );
            }
        }


    }
}