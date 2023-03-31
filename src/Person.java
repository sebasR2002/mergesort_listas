
import java.text.DecimalFormat;

class Person implements Comparable<Person> {

    private String nombres;
    private String apellidos;
    private int edad;
    private float peso;

    public Person(String n, String a, int e, float p) {
        nombres = n;
        apellidos = a;
        edad = e;
        peso = p;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public float getPeso() {
        return peso;
    }

    public String toString() {
        return nombres + " " + apellidos + " : " + edad + ", " + df.format(peso);
    }

    @Override
    public int compareTo(Person o) {
        if (this.getApellidos().compareTo(o.getApellidos()) > 0)
            return 1;

        else if (this.getApellidos().compareTo(o.getApellidos()) < 0)
            return -1;

        else if (this.getApellidos().compareTo(o.getApellidos()) == 0) {

            if (this.getNombres().compareTo(o.getNombres()) > 0)
                return 1;

            else if (this.getNombres().compareTo(o.getNombres()) < 0)
                return -1;
        }
        
        return 0;
    }

    private static final DecimalFormat df = new DecimalFormat();
    {
        df.setMaximumFractionDigits(2);
    }

}