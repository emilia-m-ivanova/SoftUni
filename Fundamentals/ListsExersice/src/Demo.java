public class Demo {
    public static void main(String[] args) {
        int [] numbers = {3, 5, 4, 8, 1, -8, 0,-7, 10, 23};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = numbers[j];
                if(numbers[i]>numbers[j]){
                        numbers[j]=numbers[i];
                        numbers[i]=temp;
                }
            }
        }
        for (int number : numbers) {
            System.out.println(number);
        }

    }
}
