
import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
import java.util.List;

public class Taller3 {

    public static void main(String[] args) throws Exception {
        int N = 16000;
        List<Person> personas = new ArrayList<>();
        personas = GeneradorADTs.generar(N);
        ListaSimple<Comparable> personasimple = new ListaSimple<>();
        for (Person person : personas) {
            personasimple.addLast(person);
        }
        /*
         * for (Comparable person : personasimple) {
         * StdOut.println(person.toString());
         * }
         */
        // StdOut.println("lista ordenada");
        StdOut.println("empieza reloj");
        Stopwatch a = new Stopwatch();
        ListaSimple<Comparable> Listaordenada = sort(personasimple);
        StdOut.println("el tiemppo para ordenar N fue de " + a.elapsedTime());
        /*
         * for (Comparable comparable : Listaordenada) {
         * StdOut.println(((Person) comparable).toString());
         * 
         * }
         */

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