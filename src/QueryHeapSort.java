public class QueryHeapSort {
    private Term[] array;

    QueryHeapSort(Term[] array) {
        this.array = array;
    }

    Term[] heapSort() {
        int length = array.length;

        for(int i = length / 2; i > 0; i --) {
            downHeap(i, length);
        }

        do {
            Term temp = array[0];
            array[0] = array[length -1];
            array[length - 1] = temp;
//            array.set(0, array.get(length - 1));
//            array.set(length - 1, temp);

            length--;

            downHeap(1, length);
//            System.out.println(temp.getQuery());

        } while (length > 1);

        return array;
    }

    void downHeap(int i, int length) {
        int j;

        Term temp = array[i - 1];

        while(i <= length / 2) {
            j = 2 * i;

            if((j < length) && (array[j-1].compareTo(array[j])) < 0) {
                j++;
            }

            if(temp.compareTo(array[j-1]) > 0 || temp.compareTo(array[j-1]) == 0) {
                break;
            }

            array[i-1] = array[j-1];
//            array.set(i-1, array.get(j-1));
            i=j;
        }
        array[i-1] = temp;
//        array.set(i - 1, temp);
    }
}
