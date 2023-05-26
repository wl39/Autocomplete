import java.util.Comparator;

public class PrefixOrderComparator implements Comparator<Term>{
    private int r;

    PrefixOrderComparator(int r) {
        this.r = r;
    }

    @Override
    public int compare(Term t1, Term t2) {
        //If the r1 is less than r it would return t1's query length otherwise return r
        int r1 = (t1.getQuery().length() < r) ? t1.getQuery().length() : r;
        int r2 = (t2.getQuery().length() < r) ? t2.getQuery().length() : r;

        //Comparing both Query (which is from index to given prefix length).
        return t1.getQuery().substring(0, r1).compareToIgnoreCase(t2.getQuery().substring(0, r2));
    }
}
