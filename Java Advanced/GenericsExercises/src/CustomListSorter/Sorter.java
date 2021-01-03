package CustomListSorter;

public class Sorter {

    public static <T extends Comparable<T>> void sort (CustomList<T> list){
        for (int i = 0; i < list.getSize(); i++) {
            for (int j = i; j < list.getSize(); j++) {
                if(list.get(i).compareTo(list.get(j))>0){
                    list.swap(i,j);
                }
            }
        }
    }
}
