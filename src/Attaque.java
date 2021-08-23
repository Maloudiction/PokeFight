public class Attaque {
    private final String nom;
    private final int degats;
    private final Type type;

    public Attaque(String nom, int degats, Type type){
        this.nom = nom;
        this.degats = degats;
        this.type = type;
    }

    public String getNom() { return nom;}
    public int getDegats() { return degats;}
    public Type getType() { return type;}
}
