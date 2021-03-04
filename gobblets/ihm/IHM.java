package gobblets.ihm;
import gobblets.data.*;
import gobblets.ihm.Menu;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Francais;

public abstract class IHM {
    private static Dictionnaire language;
    private static IHM ihm;

    public IHM() {
        ihm = getIHM();
    }

    public static IHM getIHM(){
       return ihm;
    }

    public static void setIHM(IHM obj){
        ihm=obj;
    }

    public static void setLanguage(String langue){
        if (langue == "Français") {
            language = new Francais();
        }else if (langue=="English"){
            language = new Anglais();
        }else if(langue=="Deutsche"){
            language=new Allemand();
        }
        }

    public static Dictionnaire getLanguage() {
        return language;
    }

    public static String couleur(Couleur c){
        return language.couleur(c);
    }

    public static String taille(Taille t){

        return language.taille(t);
    }

    public static String etat(Etat e){

        return language.etat(e);
    }

    public  static String action(ActionType a){

        return language.action(a);
    }

    public  static String erreur(Erreur e){
       return language.erreur(e);
    }

    public  static String avertissement(Avertissement a){
        return language.Avertissement(a);
    }

    public  static String menu(Menu m){
        return language.Menu(m);
    }

    public abstract Joueur saisirjoueur(int i);
    public abstract ActionType saisirAction(Joueur j);
    public abstract Taille saisirTaille();
    public abstract int[] saisirCoordonnees(ActionType a);
    public abstract void display(Plateau p, Joueur j);
}

