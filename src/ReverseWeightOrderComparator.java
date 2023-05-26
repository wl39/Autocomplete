import java.util.Comparator;

public class ReverseWeightOrderComparator implements Comparator<Term> {


    @Override
    public int compare(Term t1, Term t2) {

        if(t1.getWeight() > t2.getWeight()) {
            return 1;
        } else if (t1.getWeight() < t2.getWeight()) {
            return -1;
        }

        return 0;
    }
}
