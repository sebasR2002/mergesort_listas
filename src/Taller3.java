
public class Taller3 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    }

    public ListaSimple[] splitList(ListaSimple list) throws Exception {
        ListaSimple[] split = new ListaSimple[2];
        int div = (list.size() - 1) / 2;
        for (int i = 0; i <= div; i++) {
            split[0].addLast(list.get(i));
        }
        for (int i = 0; i > div && i < list.size(); i++) {
            split[1].addHead(list.get(i));
        }
        return split;
    }
}