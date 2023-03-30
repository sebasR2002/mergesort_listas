import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {

    /**
     * Nodo representa un nodo de la lista simplemente enlazada
     */
    private class Nodo {
        T item;
        Nodo sig;
    }

    private Nodo first = null;
    private Nodo last = null;
    private int n = 0;

    /**
     * Agregar un item a la cabeza de la lista
     * 
     * @param item
     */
    public void addHead(T item) {

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
    public T removeHead() throws Exception {
        if (first == null)
            throw new Exception("Lista vacia");
        T i = first.item;
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
            T i = pos.item;
            pos = pos.sig;
            return i;
        }

    }

    /*
     * Ejercicios: Implementar los siguientes métodos
     */

    /** Remueve el ultimo elemento de la lista */
    public T removeLast() {
        return null;
    }

    /** Agregar un elemento al final de la lista */
    public void addLast(T item) {
        Nodo x = new Nodo();
        x.item = item;
        x.sig = null;
        last.sig = x;
        x = last;

        n++;
    }

    /** Obtener el item en la i-ésima posición de la lista */
    public T get(int i) throws Exception {
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
    public void insert(int i, T dato) throws Exception {
        int cont = 0;
        Nodo nuevo = new Nodo();
        Nodo x = new Nodo();
        x = first;
        while (cont <= i - 1) {
            if (cont == i - 1) {
                nuevo.sig = x.sig;
                x.sig = nuevo;
                n++;
            } else {
                x = x.sig;
                cont++;
            }

        }
    }

    /** remueve el item de la i-ésima posición de la lista */
    public T remove(int i) {
        return null;
    }

    /** Obtener una nueva ListaSimple con todos los items en orden inverso */
    public ListaSimple<T> invert() {
        return null;
    }

    /** Dividir una lista en dos mitades */
    public ListaSimple<T>[] splitList() {
        return null;
    }
}
