package set;

public class UniqueElements {

    public static int[] uniqueElements(int[] ints) {
        MaxSet<Integer> set = new MaxSet<Integer>();
        for(int i : ints){
            set.add(i);
        }
        int[] sortedArray = new int[set.size()];;
        for(int i= set.size() - 1; i >= 0; i--){
            int max = set.getMax();
            sortedArray[i] = max;
            set.remove(max);
        }
        return sortedArray;
    }
}
