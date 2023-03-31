
import edu.princeton.cs.algs4.*;

public class Taller3 {
    public static ListaSimple<Comparable> sort(ListaSimple<Comparable> a) throws Exception {
        if (a.size() <= 1)
            return a;
        ListaSimple<Comparable>[] aux = new ListaSimple[2];
        aux = a.splitList();
        ListaSimple<Comparable> x = sort(aux[0]);
        ListaSimple<Comparable> y = sort(aux[1]);
        return a.fusionar(x, y);

    }
}