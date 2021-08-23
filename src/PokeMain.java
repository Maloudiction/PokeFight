import java.util.Scanner;

public class PokeMain {
    static String Newline = System.getProperty("line.separator");
    static Scanner scanner = new Scanner(System.in);
    static String name1, name2;

    public static void main(String[] args) {
        System.out.println("Joueur 1, comment t'appelles-tu ?" + Newline);
        name1 = scanner.nextLine();
        System.out.println("Joueur 2, comment t'appelles-tu ?" + Newline);
        name2 = scanner.nextLine();
        System.out.println(Newline + name1 + ", choisissez votre Pokémon !" + Newline);
        Pokemon pkmn1 = choixPoke();
        System.out.println(Newline + name2 + ", choisissez votre Pokémon !" + Newline);
        Pokemon pkmn2 = choixPoke();

        System.out.println(Newline + name1 +" : " + pkmn1.getNom() + " !" + Newline);
        System.out.println(name2 +" : " + pkmn2.getNom() + " !" + Newline);

        String winner = onJoue(pkmn1, pkmn2, name1, name2);
        if(winner.equals(name1)) endScreen(winner, pkmn2);
        else endScreen(winner, pkmn1);
    }

    public static Pokemon choixPoke() {

        System.out.println("Pour cela, entrez le nombre correspondant puis faites Entrée");
        System.out.println("Pikachu --> 1");
        System.out.println("Salamèche --> 2");
        System.out.println("Bulbizarre --> 3");
        System.out.println("Carapuce --> 4");
        System.out.println("Soporifik --> 5");
        System.out.println("Etourvol --> 6");
        System.out.println("Minidraco --> 7");
        System.out.println("Racaillou --> 8");
        System.out.println("Séviper --> 9");

            while(true)
            {
                int result = Integer.parseInt(scanner.nextLine());
                switch (result)
                {
                    case 1:
                        return new Pokemon("Pikachu", Type.FOUDRE, 90);
                    case 2:
                        return new Pokemon("Salamèche", Type.FEU, 100);
                    case 3:
                        return new Pokemon("Bulbizarre", Type.PLANTE, 90);
                    case 4:
                        return new Pokemon("Carapuce", Type.EAU, 100);
                    case 5:
                        return new Pokemon("Soporifik", Type.PSY, 90);
                    case 6 :
                        return new Pokemon("Etourvol", Type.VOL, 90);
                    case 7 :
                        return new Pokemon("Minidraco", Type.DRAGON, 100);
                    case 8 :
                        return new Pokemon("Racaillou", Type.SOL, 100);
                    case 9 :
                        return new Pokemon("Séviper", Type.POISON, 90);
                    default:
                        System.out.println("Le Pokémon correspondant à ce nombre n'existe pas !");
                }
            }
    }

    public static String onJoue(Pokemon pkmn1, Pokemon pkmn2, String name1, String name2)
    {
        String joueurCourant = name1;
        String joueurGagnant = "";
        boolean gameOver = false;
        System.out.println(Newline + "================================================================" + Newline);

        while (!gameOver)
        {
            String efficacite;
            if (joueurCourant.equals(name1))
            {
                Attaque atk = choixAttaque(joueurCourant, pkmn1);
                efficacite = pkmn1.attaquer(pkmn2, atk);
                System.out.println(pkmn1.ToString() + "attaque " + pkmn2.getNom() + efficacite + "Il reste " + pkmn2.getPv() + "pv à " + pkmn2.getNom());
                if (pkmn2.getPv() <= 0)
                {
                    joueurGagnant = name1;
                    gameOver = true;
                }
                else joueurCourant = name2;
            }
            else
            {
                Attaque atk = choixAttaque(joueurCourant, pkmn2);
                efficacite = pkmn2.attaquer(pkmn1, atk);
                System.out.println(pkmn2.ToString() + "attaque " + pkmn1.getNom() + efficacite + "Il reste " + pkmn1.getPv() + "pv à " + pkmn1.getNom());
                if (pkmn1.getPv() <= 0)
                {
                    joueurGagnant = name2;
                    gameOver = true;
                }
                else joueurCourant = name1;
            }

            System.out.println(Newline + "================================================================" + Newline);
        }
        return joueurGagnant;
    }

    public static Attaque choixAttaque(String joueurCourant, Pokemon pkmn)
    {
        while(true) {
            System.out.println(Newline + joueurCourant + ", entrez le numéro de votre attaque préférée puis faites Entrée");
            System.out.println(pkmn.getAttaque(0).getNom() + " --> 1");
            System.out.println(pkmn.getAttaque(1).getNom() + " --> 2");
            System.out.println(pkmn.getAttaque(2).getNom() + " --> 3");
            System.out.println(pkmn.getAttaque(3).getNom() + " --> 4" + Newline);
            int numAttaque = Integer.parseInt(scanner.nextLine());
            if (numAttaque >= 0 && numAttaque < 5)
                return pkmn.attaques[numAttaque - 1];
            System.out.println("Alors t'as que 4 attaques hein noobi :)");
        }
    }

    public static void endScreen(String gagnant, Pokemon pokeKO)
    {
        System.out.println(Newline + pokeKO.getNom() + " se sent un peu patraque... Il est KO !!");
        System.out.println(Newline + "_________________________________________");
        System.out.println("    :)       :)        :)        :)    ");
        System.out.println("                 GRAND                 ");
        System.out.println("                GAGNANT                ");
        System.out.println("                " + gagnant + "               ");
        System.out.println("    :)       :)        :)        :)    ");
        System.out.println("_________________________________________" + Newline);
    }
}
