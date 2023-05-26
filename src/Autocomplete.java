public class Autocomplete {
    Term[] terms;


    public Autocomplete(Term[] terms) {
        if(terms == null) throw new NullPointerException();

        QueryHeapSort heapSort = new QueryHeapSort(terms);
        this.terms = heapSort.heapSort();
    }

    public Term[] allMatches(String prefix) {
        if(prefix == null) throw new NullPointerException();

        int r = prefix.length();


        Term userPrefix = new Term(prefix, 0);

        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, userPrefix, Term.byPrefixOrder(r));
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, userPrefix, Term.byPrefixOrder(r));

        int size = lastIndex - firstIndex + 1;

        Term[] autocomplete = new Term[size];
        for(int i = 0; i < size; i++, firstIndex++) {
            autocomplete[i] = terms[firstIndex];
        }
        WeightHeapSort heapSort = new WeightHeapSort(autocomplete);
        autocomplete = heapSort.heapSort();

        //should be return the Term[]
        return autocomplete;

    }

    public int numberOfMatches(String prefix) {
        if(prefix == null) throw new NullPointerException();

        int r = prefix.length();

        //To save the size of new Term array


        //Save the user input as Term object
        Term term = new Term(prefix, 0);

        int size = BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(r))
                - BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(r)) + 1;

        //Return the number of terms
        return size;
    }
}
