package gobblets.ihm.langues;
import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

import java.util.HashMap;


public class Allemand implements Dictionnaire{
    private HashMap<Couleur,String> couleurs;
    private HashMap<Taille,String> tailles;
    private HashMap<Etat,String> etats;
    private HashMap<ActionType,String> actions;
    private HashMap<Erreur,String> erreurs;
    private HashMap<Menu,String> menu;
    private HashMap<Avertissement,String> avert;

    public Allemand() {
        couleurs=new HashMap<Couleur,String>();
        tailles=new HashMap<Taille,String>();
        etats= new HashMap<Etat,String>();
        actions=new HashMap<ActionType,String>();
        erreurs=new HashMap<Erreur,String>();
        menu = new HashMap<Menu,String>();
        avert = new HashMap<Avertissement,String>();
    }
    @Override
    public String couleur(Couleur c) {
        couleurs.put(Couleur.WHITE,"Weiß");
        couleurs.put(Couleur.ROUGE,"Rot");
        couleurs.put(Couleur.VERT,"Grün");
        couleurs.put(Couleur.BLEU,"Blau");
        couleurs.put(Couleur.JAUNE,"Gelb");
        return couleurs.get(c);
    }

    @Override
    public String taille(Taille t) {
        tailles.put(Taille.PETITE,"Klein");
        tailles.put(Taille.MOYENNE,"Durchschnitt");
        tailles.put(Taille.GRANDE,"großartig");
        return tailles.get(t);
    }

    @Override
    public String etat(Etat e) {
        etats.put(Etat.MATCHNUL,"zeichnen");
        etats.put(Etat.JOUEUR1GAGNE,"Spieler 1 hat gewonnen");
        etats.put(Etat.JOUEUR2GAGNE,"Spieler 2 hat gewonnen");
        etats.put(Etat.JEUENCOURS,"Spiel läuft");
        etats.put(Etat.JEUQUITTE,"Spiel übrig");
        return etats.get(e);
    }

    @Override
    public String action(ActionType a) {
        actions.put(ActionType.PLACER,"Ort");
        actions.put(ActionType.DEPLACER,"Bewegen");
        actions.put(ActionType.QUITTER,"Geh");
        actions.put(ActionType.ANNULER,"abbrechen");
        return actions.get(a);
    }

    @Override
    public String erreur(Erreur e) {
        erreurs.put(Erreur.PASDEPIECEICI,"Kein Bauer hier");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Bauer nicht verfügbar");
        erreurs.put(Erreur.PASTAPIECE,"nicht dein Bauer");
        erreurs.put(Erreur.CASEBLOQUEE,"Die Box ist gesperrt");
        erreurs.put(Erreur.ARGUMENTCORRECT,"Falsches Argument");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Falsche Diagonale");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Größe nicht verfügbar");
        erreurs.put(Erreur.ORIGINEVIDE,"Leerer Ursprung");
        erreurs.put(Erreur.ERREUR,"FEHLER");
        erreurs.put(Erreur.IMPLACE,"Das kann man hier nicht platzieren");
        erreurs.put(Erreur.IMPDEPLACE,"Sie k�nnen dies hier nicht verschieben");
        return erreurs.get(e);
    }

    @Override
    public String Menu(Menu m) {
        menu.put(Menu.MENU_AIDE,"Hifle");
        menu.put(Menu.MENU_APROPOS,"über");
        menu.put(Menu.MENU_ENREGISTRER,"speichern");
        menu.put(Menu.MENU_FICHIER,"Datei");
        menu.put(Menu.MENU_LANGUE,"Sprache");
        menu.put(Menu.MENU_NOUVEAU,"Neu");
        menu.put(Menu.MENU_OUVRIR,"hören");
        menu.put(Menu.MENU_QUITTER,"Geh");
        menu.put(Menu.MENU_VALIDER,"Best�tigen");
        menu.put(Menu.MENU_PARTIE,"Teil");
        
        return menu.get(m);
    }

    @Override
    public String Avertissement(Avertissement a) {
        avert.put(Avertissement.TONTOUR, "Du bist dran");
        avert.put(Avertissement.JOUEUR,  "Spieler");
        avert.put(Avertissement.CHOIXACTION, "Wahl der Aktion");
        avert.put(Avertissement.CHOIXDESTINATION, "Wahl der Ziel");
        avert.put(Avertissement.CHOIXORIGIN, "Wahl der Herkunft");
        avert.put(Avertissement.CHOIXTAILLE, "Wahl der Größe");
        avert.put(Avertissement.COULEURJOUEUR, "Spielerfarbe");
        avert.put(Avertissement.NOMJOUEUR, "Spielername");
        avert.put(Avertissement.CHOIXCOULEUR,"w�hle deine Farbe");
        avert.put(Avertissement.PIECERESTANTE,"Der Rest");
        avert.put(Avertissement.JOUEURCOULDIF,"Spieler m�ssen unterschiedliche Farben haben");
        avert.put(Avertissement.REGLE, "Dieses Spiel wird mit zwei Spielern auf einem Spielbrett gespielt, das aus einem Dreier-Schachbrett besteht " + 
        		"Felder in drei Feldern, wie Filzl�use. Jeder Spieler hat am Anfang sechs " + 
        		"Die Zimmer in seinem Haus k�nnen drei Gr��en haben: klein, " + 
        		"mittelgro� oder gro�, und jede hat zwei Zimmer in jeder Gr��e.\r\n" + 
        		"\r\n" + 
        		"Die Spieler f�hren jeweils eine Aktion aus, und zwar je zwei Aktionen:\r\n" + 
        		"\r\n" + 
        		"- Ein Spieler kann ein St�ck seines Hauses auf ein Tablett legen " + 
        		"- ein Spieler kann eine seiner M�nzen auf dem Spielbrett bewegen (und " + 
        		"sichtbar) auf ein anderes Feld auf der Platte.\r\n" + 
        		"\r\n" + 
        		"Um ein St�ck auf der Platte zu platzieren/zu verschieben, muss das K�stchen " + 
        		"Der Lieferumfang ist frei oder enth�lt nur Einzelteile, die kleiner sind als der platzierte Raum.\r\n" +
        		"Wird eine M�nze auf ein belegtes Feld gelegt, so deckt dieses Feld " + 
        		"Bereits vorhandene Teile sind unsichtbar. Nur das gr�sste St�ck auf der Box ist sichtbar.\r\n" + 
        		"\r\n" + 
        		"Es ist m�glich, ein St�ck des Gegners oder eines seiner eigenen St�cke abzudecken.\r\n" + 
        		"Wenn ein Teil, das ein anderes abdeckt, bewegt wird, " + 
        		"verborgen wieder sichtbar werden.\r\n" + 
        		"\r\n" + 
        		"Ein Spieler gewinnt das Spiel, wenn er erreicht, dass alle Teile " + 
        		"Die sichtbare Seite einer Zeile, Spalte oder Diagonale geh�rt zu ihm.\r\n" + 
        		"F�r den Fall, dass beide Spieler bei " + 
        		"mit gleicher Bewegung geht das Spiel weiter, bis ein Spieler " + 
        		"Das ist die Gewinnposition.");
        return avert.get(a);
    }
}
