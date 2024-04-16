package model.enums;

public enum Humor {

    ABSURDO("También conocido como “humor deadpan”, el humor seco es una expresión"),
    Seco("el humor seco es una expresión humorística en la que la persona muestra serenidad y una actitud impasible"),
    Satira("El humor satírico se basa en el discurso para generar cierta gracia en el público oyente. Por lo general, utiliza rarezas o características extrañas de la vida diaria para hacer comparaciones con los defectos de las personas."),
    Blanco("Es un tipo de humor muy simple y sano que agrada a la mayoría de las personas."),
    Sarcastico("De su etimología podemos ver que este tipo de humor se fundamenta en el uso del verbo mordaz, sádico o hiriente para causar gracias a quien lo escucha. Descubre cuál es la diferencia entre ironía y sarcasmo."),
    Hacker("Sin duda, este es un humor muy particular y llamativo, ya que utiliza la realidad tecnológica para hacer reír a los lectores."),
    Crudo("Tal y como su nombre indica, es el humor que no teme decir las cosas de forma directa e incluso dolorosa. "),
    Verde("Este humor está relacionado con temas sexuales. "),
    Negro("Este tipo de humor es un poco singular porque mezcla sátira, burla, lo grotesco e incluso lo absurdo en una forma de humor que no agrada a todos. ");
    private String descripcion;

    Humor(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
