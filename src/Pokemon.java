public class Pokemon {
    private final String nom;
    private final Type type;
    private final int maxPv;
    private int pv;
    Attaque[] attaques = new Attaque[4];

    public Pokemon(String nom, Type type, int pv) {
        this.nom = nom;
        this.type = type;
        this.maxPv = pv;
        this.pv = pv;
        switch(nom)
        {
            case "Pikachu" :
                attaques[0] = new Attaque("Eclair", 16, Type.FOUDRE);
                attaques[1] = new Attaque("Fatal-Foudre", 18, Type.FOUDRE);
                attaques[2] = new Attaque("Feu-de-Dieu", 12, Type.FEU);
                attaques[3] = new Attaque("Queue-de-fer", 10, Type.NORMAL);
                break;
            case "Salamèche" :
                attaques[0] = new Attaque("Flammèche", 10, Type.FEU);
                attaques[1] = new Attaque("CAPITAINE FLAMME", 18, Type.FEU);
                attaques[2] = new Attaque("Statik", 12, Type.FOUDRE);
                attaques[3] = new Attaque("Mimi-queue", 16, Type.NORMAL);
                break;
            case "Bulbizarre" :
                attaques[0] = new Attaque("Feuille magik", 16, Type.PSY);
                attaques[1] = new Attaque("Tranche", 14, Type.NORMAL);
                attaques[2] = new Attaque("Giga-Sangsue", 12, Type.PLANTE);
                attaques[3] = new Attaque("PLANTAX UN MAX", 18, Type.PLANTE);
                break;
            case "Carapuce" :
                attaques[0] = new Attaque("Bubulle", 16, Type.EAU);
                attaques[1] = new Attaque("Bulle nulle", 10, Type.EAU);
                attaques[2] = new Attaque("Coup de poing", 14, Type.NORMAL);
                attaques[3] = new Attaque("Algue dans ta face", 14, Type.PLANTE);
                break;
            case "Soporifik" :
                attaques[0] = new Attaque("Choc mental", 14, Type.PSY);
                attaques[1] = new Attaque("Choc emmental", 14, Type.NORMAL);
                attaques[2] = new Attaque("Tsunami", 12, Type.EAU);
                attaques[3] = new Attaque("Psychose", 16, Type.PSY);
                break;
            case "Etourvol" :
                attaques[0] = new Attaque("Cru-Aile", 12, Type.VOL);
                attaques[1] = new Attaque("Cuit-Aile", 16, Type.VOL);
                attaques[2] = new Attaque("Vive attaque", 12, Type.NORMAL);
                attaques[3] = new Attaque("Fiente de pigeon", 18, Type.PSY);
                break;
            case "Minidraco" :
                attaques[0] = new Attaque("Dracogriffe", 14, Type.DRAGON);
                attaques[1] = new Attaque("Croc de mort", 14, Type.NORMAL);
                attaques[2] = new Attaque("Draco-Dévastation", 18, Type.DRAGON);
                attaques[3] = new Attaque("Choc toxic", 12, Type.POISON);
                break;
            case "Racaillou" :
                attaques[0] = new Attaque("°l_(o_o)_l°", 14, Type.NORMAL);
                attaques[1] = new Attaque("THE ROCK", 18, Type.SOL);
                attaques[2] = new Attaque("Flying Caillou", 12, Type.VOL);
                attaques[3] = new Attaque("Caillou-dans-ta-face", 16, Type.SOL);
                break;
            case "Séviper" :
                attaques[0] = new Attaque("Choc Cyanure", 14, Type.POISON);
                attaques[1] = new Attaque("Tétrodotoxine", 18, Type.POISON);
                attaques[2] = new Attaque("Solid Snake", 14, Type.FEU);
                attaques[3] = new Attaque("Masquerade", 12, Type.PLANTE);                                    //Je voulais l'appeler Mascarade mais petit clin d'oeil au Masquerading :)
                break;
            default:
                System.out.println("Nom du Pokémon non existant" + PokeMain.Newline);
        }
    }

    public String attaquer(Pokemon ennemi, Attaque attaque)
    {
        int damage;
        String efficacite;
        switch (attaque.getType())
        {
            case FEU :
                if (ennemi.getType() == Type.PLANTE) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.EAU) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case EAU :
                if (ennemi.getType() == Type.FEU) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.SOL) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.PLANTE) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case FOUDRE:
                if (ennemi.getType() == Type.EAU) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.PSY) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case PLANTE:
                if (ennemi.getType() == Type.EAU) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.FEU) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case PSY:
                if (ennemi.getType() == Type.FOUDRE) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.NORMAL) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case VOL:
                if (ennemi.getType() == Type.PLANTE) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.POISON) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case DRAGON:
                if (ennemi.getType() == Type.DRAGON) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.POISON) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.VOL) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case SOL:
                if (ennemi.getType() == Type.FEU) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.NORMAL) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            case POISON:
                if (ennemi.getType() == Type.PLANTE) { damage = attaque.getDegats() * 2; efficacite = ". C'est TRES EFFICACE ! "; }
                else if (ennemi.getType() == Type.SOL) { damage = attaque.getDegats() / 2; efficacite = ". C'est pas ouf. "; }
                else
                {
                    damage = attaque.getDegats();
                    efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
                }
                break;
            default :
                damage = attaque.getDegats();
                efficacite = ". ça fait mal, mais sans plus. il survit quoi. ";
        }
        ennemi.setPv(ennemi.getPv() - damage);
        return efficacite;
    }

    public String ToString() { return nom + "[" + pv + "/" + maxPv + "] ~~ "; }

    public String getNom() { return nom; }
    public int getPv() { return pv; }
    public void setPv(int value) { pv = value; }
    public Attaque getAttaque(int number) { return attaques[number]; }
    public Type getType() { return type; }
}
