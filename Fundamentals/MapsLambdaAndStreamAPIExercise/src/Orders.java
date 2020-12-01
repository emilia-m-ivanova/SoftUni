import java.util.*;

public class Orders {
    static class Product{
        double price;
        int quantity;
        public void setPrice(double price){
            this.price = price;
        }
        public void addQuantity (int quantity){
            this.quantity+=quantity;
        }
        public double getPrice (){
            return this.price;
        }
        public int getQuantity (){
            return this.quantity;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Product> products = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("buy")){
            String [] product = input.split(" ");
            String name = product[0];
            double price = Double.parseDouble(product[1]);
            int quantity = Integer.parseInt(product[2]);
            if(!products.containsKey(name)){
                Product productDetails = new Product();
                products.put(name,productDetails);
            }
            products.get(name).setPrice(price);
            products.get(name).addQuantity(quantity);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.println(entry.getKey()+" -> "+String.format
                    ("%.2f",entry.getValue().getPrice()*entry.getValue().getQuantity()));
        }
    }
}
