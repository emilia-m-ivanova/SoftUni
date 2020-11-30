public class BlankReceipt {
        static void printReceiptHeader(){
            System.out.println("CASH RECEIPT");
            System.out.println("------------------------------");
        }
        static void printReceiptBody(){
            System.out.println("Charged to____________________");
            System.out.println("Received by___________________");
        }
        static void printReceiptFooter(){
            System.out.println("------------------------------");
            System.out.println("(c) SoftUni");
        }
        static void printReceipt(){
            printReceiptHeader();
            printReceiptBody();
            printReceiptFooter();
        }

    public static void main(String[] args) {
        printReceipt();
    }
    }

