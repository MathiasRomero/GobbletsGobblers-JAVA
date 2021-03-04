package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;

public interface Dictionnaire  {
    String couleur(Couleur c);

    String taille(Taille t);

    String etat(Etat e);

    String action(ActionType a);

    String erreur(Erreur e);

    String Menu(Menu m);

    String Avertissement(Avertissement a);
}
