import java.util.Comparator;

public class WeightHeapSort {
    private Comparator<Term> comparator;
    private Term[] array;

    WeightHeapSort(Term[] array) {
        comparator = Term.byReverseWeightOrder();
        this.array = array;
    }

    Term[] heapSort() {
        int length = array.length;

        for(int i = length /2; i > 0; i--) {
            upHeap(i, length);
        }

        do {
            int z = 0;
            Term temp = array[0];
            array[0] = array[length -1];
            array[length -1] = temp;

            length --;
            z++;

            upHeap(1, length);

        } while (length > 1);

        return array;

    }

    void upHeap(int i, int length) {
        int j;

        Term temp = array[i - 1];

        while (i <= length /2) {
            j = 2 * i;
            if((j < length) && (Term.byReverseWeightOrder().compare(array[j-1], array[j]) == 1)) {
                j ++;
            }

            if(Term.byReverseWeightOrder().compare(temp, array[j -1]) == -1 || Term.byReverseWeightOrder().compare(temp, array[j -1]) == 0) {
                break;
            }
            array[i-1] = array[j-1];
            i = j;
        }
        array[i-1] = temp;
    }
}
