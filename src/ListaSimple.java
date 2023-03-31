import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class ListaSimple<T> implements Iterable<T> {

    /**
     * Nodo representa un nodo de la lista simplemente enlazada
     */
    public class Nodo {
        Comparable item;
        Nodo sig;
    }

    private Nodo first = null;
    private Nodo last = null;
    private int n = 0;

    // accesor de firts
    public Nodo GetFirst() {
        return first;
    }

    // accesor de last
    public Nodo GetLast() {
        return last;
    }

    /**
     * Agregar un item a la cabeza de la lista
     * 
     * @param item
     */
    public void addHead(Comparable item) {

        Nodo x = new Nodo();
        x.item = item;
        x.sig = first;
        first = x;
        if (first.sig == null)
            last = first;
        n++;
    }

    /**
     * Remover el primer nodo de la lista
     * 
     * @return item contenido en el nodo eliminado
     * @throws Exception
     */
    public Comparable removeHead() throws Exception {
        if (first == null)
            throw new Exception("Lista vacia");
        Comparable i = first.item;
        first = first.sig;
        n--;
        return i;
    }

    /**
     * True si la lista esta vacia
     * 
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * @return Longitud de la lista
     */
    public int size() {
        return n;
    }

    /**
     * Obtener un iterador para la lista
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    /**
     * Implementacion del iterador para la lista simple
     */
    private class IteradorLista implements Iterator<T> {

        private Nodo pos = first;

        @Override
        public boolean hasNext() {
            return pos != null;
        }

        @Override
        public T next() {
            T i = (T) pos.item;
            pos = pos.sig;
            return i;
        }

    }

    /*
     * Ejercicios: Implementar los siguientes métodos
     */

    /** Remueve el ultimo elemento de la lista */
    public Comparable removeLast() throws Exception {
        Comparable item = null;
        int cont = 0;
        Nodo x = new Nodo();
        if (last != null) {
            while (cont < n) {
                if (cont == n - 2) {
                    item = x.sig.item;
                    x.sig = null;
                    n--;

                } else {
                    x = x.sig;
                    cont++;
                }
            }
            return item;
        } else
            throw new Exception("lista vacia");

    }

    /** Agregar un elemento al final de la lista */
    public void addLast(Comparable item) {
        Nodo x = new Nodo();
        if (last == null) {
            addHead(item);
            return;
        }
        x.item = item;
        x.sig = null;
        last.sig = x;
        x = last;

        n++;
    }

    /** Obtener el item en la i-ésima posición de la lista */
    public Comparable get(int i) throws Exception {
        if (i < n && i >= 0) {
            int cont = 0;
            Nodo x = new Nodo();
            x = first;
            while (cont <= i) {
                if (cont == i)
                    return x.item;
                else {
                    x = x.sig;
                    cont++;
                }
            }
        } else
            throw new Exception("Lista vacia");
        return null;

    }

    /** Insertar un item en la i-ésima posición de la lista */
    public void insert(int i, Comparable dato) throws Exception {
        int cont = 0;
        Nodo nuevo = new Nodo();
        Nodo x = new Nodo();
        nuevo.item = dato;
        x = first;
        if (i == 0) {
            addHead(dato);
            return;
        }
        if (i == n - 1) {
            addLast(dato);
            return;
        }
        if (i < n && i >= 0) {

            while (cont <= i - 1) {
                if (cont == i - 1) {
                    nuevo.sig = x.sig;
                    x.sig = nuevo;
                } else {
                    x = x.sig;
                    cont++;
                }
            }
        } else
            throw new Exception("posicion fuera de rango");
    }

    /** remueve el item de la i-ésima posición de la lista */
    public Comparable remove(int i) throws Exception {
        int cont = 0;
        Nodo x = new Nodo();
        x = first;
        Comparable item = null;
        if (i < n && i >= 0) {

            while (cont <= i - 1) {
                if (cont == i - 1) {
                    item = x.sig.item;
                    x.sig = x.sig.sig;
                    n--;

                } else {
                    x = x.sig;
                    cont++;
                }

            }
            return item;
        } else
            throw new Exception("posicion fuera de rango");
    }

    /** Obtener una nueva ListaSimple con todos los items en orden inverso */
    public ListaSimple<T> invert() throws Exception {
        ListaSimple<T> x = new ListaSimple<T>();
        for (int i = 0; i < n; i++) {
            x.addHead(get(i));
        }
        return x;
    }

    /** Dividir una lista en dos mitades */
    public ListaSimple<T>[] splitList() throws Exception {
        ListaSimple<T>[] split = new ListaSimple[2];
        split[0] = new ListaSimple<T>();
        split[1] = new ListaSimple<T>();
        int div = (n - 1) / 2;
        for (int i = 0; i <= div; i++) {
            split[0].addHead(get(i));
        }
        for (int i = div + 1; i > div && i < n; i++) {
            split[1].addHead(get(i));
        }
        return split;
    }

    public ListaSimple<Comparable> fusionar(ListaSimple<Comparable> a, ListaSimple<Comparable> b) {
        ListaSimple<Comparable> Temp = new ListaSimple<Comparable>();
        boolean t = true;
        Nodo ia = (ListaSimple<T>.Nodo) a.first;
        Nodo ib = (ListaSimple<T>.Nodo) b.first;
        int hi;

        for (int i = 0; i < a.size() + b.size(); i++) {

            if (less(ib.item, ia.item)) {
                Temp.addLast(ia.item);
                ia = ia.sig;
            } else if (less(ia.item, ib.item)) {
                Temp.addLast(ib.item);
                ib = ib.sig;
            }

            else {
                Temp.addLast(ia.item);
                ia = ia.sig;
                Temp.addLast(ib.item);
                ib = ib.sig;
            }

            if (ia.sig == null) {

            }
        }
        return Temp;
    }

    public boolean less(Comparable item, Comparable item2) {
        return item.compareTo(item2) < 0;
    }

    public boolean isSorted() throws Exception {
        if (n == 0) {
            throw new Exception("La lista no tiene items");
        } else if (n == 1) {
            return true;
        } else {
            Nodo n = first;
            while (n.sig != null) {

                if (!less(n.item, n.sig.item))
                    return false;
            }
            return true;
        }
    }
}
