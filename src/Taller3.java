
import edu.princeton.cs.algs4.*;

public class Taller3 {
    public static void main(String[] args) throws Exception {
        ListaSimple<Comparable> aux = new ListaSimple<>();
        aux.addLast(19);
        aux.addHead(18);
        aux.addHead(15);
        aux.addHead(11);
        aux.addHead(3);
        aux.addHead(13);
        aux.addHead(20);

        for (Comparable i : aux) {
            StdOut.println(i);

        }

        StdOut.println("el ultimo es " + aux.GetLast().item);
        StdOut.println("el primero es " + aux.GetFirst().item);
        StdOut.println("el tamaño es " + aux.size());
        StdOut.println("el ultimo es con get es " + aux.get(aux.size() - 1));

        ListaSimple<Comparable>[] aux1 = new ListaSimple[2];

        aux1 = aux.splitList();

        StdOut.println("la lista split 0 es ");
        for (Comparable i : aux1[0]) {
            StdOut.println(i);

        }
        StdOut.println("la lista split 1 es ");
        for (Comparable i : aux1[1]) {
            StdOut.println(i);

        }
        ListaSimple<Comparable> b = sort(aux);
        StdOut.println("la lista ordenada");

        for (Comparable i : b) {
            StdOut.println(i);

        }
        StdOut.println("la lista esta ordenada " + b.isSorted());
        StdOut.println("la lista esta ordenada " + aux.isSorted());
        assert (aux.isSorted());
    }

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