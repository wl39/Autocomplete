import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    public Term(String query, long weight) {
        if (query == null || weight < 0) throw new IllegalArgumentException();
        this.query = query;
        this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrderComparator();
    }

    public static Comparator<Term> byPrefixOrder(int r) throws IllegalArgumentException {

        if(r < 0) {
            throw new IllegalArgumentException();

        }

        return new PrefixOrderComparator(r);
    }

    public int compareTo(Term that) {
        return query.compareTo(that.query);
    }

    public String getQuery() {
        return query;
    }

    public long getWeight() {
        return weight;
    }

    public String toString() {
        return weight + "\t" + query;
    }
}