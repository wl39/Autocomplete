import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that
    //equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null) throw new NullPointerException();
        int first = 0;
        int last = a.length - 1;
        int firstIndex = -1;

        while(first <= last) {
            int mid = (last - first) / 2  + first;
            if(comparator.compare(a[mid], key) > 0) {
                last = mid -1;
            } else if (comparator.compare(a[mid], key) == 0) {
                firstIndex = mid;
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return firstIndex;
    }

    // Returns the index of the last key in a[] that
    //equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null) throw new NullPointerException();

        int low = 0;
        int high = a.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = (high - low) / 2  + low;
            if (comparator.compare(a[mid], key) > 0) {
                high = mid - 1;
            } else if (comparator.compare(a[mid], key) == 0) {
                lastIndex = mid;
                low = mid + 1;
            } else {
                low = mid + 1;
            }
        }
        return lastIndex;
    }
}
