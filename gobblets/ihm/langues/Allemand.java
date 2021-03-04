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
        couleurs.put(Couleur.WHITE,"WeiÃŸ");
        couleurs.put(Couleur.ROUGE,"Rot");
        couleurs.put(Couleur.VERT,"GrÃ¼n");
        couleurs.put(Couleur.BLEU,"Blau");
        couleurs.put(Couleur.JAUNE,"Gelb");
        return couleurs.get(c);
    }

    @Override
    public String taille(Taille t) {
        tailles.put(Taille.PETITE,"Klein");
        tailles.put(Taille.MOYENNE,"Durchschnitt");
        tailles.put(Taille.GRANDE,"groÃŸartig");
        return tailles.get(t);
    }

    @Override
    public String etat(Etat e) {
        etats.put(Etat.MATCHNUL,"zeichnen");
        etats.put(Etat.JOUEUR1GAGNE,"Spieler 1 hat gewonnen");
        etats.put(Etat.JOUEUR2GAGNE,"Spieler 2 hat gewonnen");
        etats.put(Etat.JEUENCOURS,"Spiel lÃ¤uft");
        etats.put(Etat.JEUQUITTE,"Spiel Ã¼brig");
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
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Bauer nicht verfÃ¼gbar");
        erreurs.put(Erreur.PASTAPIECE,"nicht dein Bauer");
        erreurs.put(Erreur.CASEBLOQUEE,"Die Box ist gesperrt");
        erreurs.put(Erreur.ARGUMENTCORRECT,"Falsches Argument");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Falsche Diagonale");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"GrÃ¶ÃŸe nicht verfÃ¼gbar");
        erreurs.put(Erreur.ORIGINEVIDE,"Leerer Ursprung");
        erreurs.put(Erreur.ERREUR,"FEHLER");
        erreurs.put(Erreur.IMPLACE,"Das kann man hier nicht platzieren");
        erreurs.put(Erreur.IMPDEPLACE,"Sie können dies hier nicht verschieben");
        return erreurs.get(e);
    }

    @Override
    public String Menu(Menu m) {
        menu.put(Menu.MENU_AIDE,"Hifle");
        menu.put(Menu.MENU_APROPOS,"Ã¼ber");
        menu.put(Menu.MENU_ENREGISTRER,"speichern");
        menu.put(Menu.MENU_FICHIER,"Datei");
        menu.put(Menu.MENU_LANGUE,"Sprache");
        menu.put(Menu.MENU_NOUVEAU,"Neu");
        menu.put(Menu.MENU_OUVRIR,"hÃ¶ren");
        menu.put(Menu.MENU_QUITTER,"Geh");
        menu.put(Menu.MENU_VALIDER,"Bestätigen");
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
        avert.put(Avertissement.CHOIXTAILLE, "Wahl der GrÃ¶ÃŸe");
        avert.put(Avertissement.COULEURJOUEUR, "Spielerfarbe");
        avert.put(Avertissement.NOMJOUEUR, "Spielername");
        avert.put(Avertissement.CHOIXCOULEUR,"wähle deine Farbe");
        avert.put(Avertissement.PIECERESTANTE,"Der Rest");
        avert.put(Avertissement.JOUEURCOULDIF,"Spieler müssen unterschiedliche Farben haben");
        avert.put(Avertissement.REGLE, "Dieses Spiel wird mit zwei Spielern auf einem Spielbrett gespielt, das aus einem Dreier-Schachbrett besteht " + 
        		"Felder in drei Feldern, wie Filzläuse. Jeder Spieler hat am Anfang sechs " + 
        		"Die Zimmer in seinem Haus können drei Größen haben: klein, " + 
        		"mittelgroß oder groß, und jede hat zwei Zimmer in jeder Größe.\r\n" + 
        		"\r\n" + 
        		"Die Spieler führen jeweils eine Aktion aus, und zwar je zwei Aktionen:\r\n" + 
        		"\r\n" + 
        		"- Ein Spieler kann ein Stück seines Hauses auf ein Tablett legen " + 
        		"- ein Spieler kann eine seiner Münzen auf dem Spielbrett bewegen (und " + 
        		"sichtbar) auf ein anderes Feld auf der Platte.\r\n" + 
        		"\r\n" + 
        		"Um ein Stück auf der Platte zu platzieren/zu verschieben, muss das Kästchen " + 
        		"Der Lieferumfang ist frei oder enthält nur Einzelteile, die kleiner sind als der platzierte Raum.\r\n" +
        		"Wird eine Münze auf ein belegtes Feld gelegt, so deckt dieses Feld " + 
        		"Bereits vorhandene Teile sind unsichtbar. Nur das grösste Stück auf der Box ist sichtbar.\r\n" + 
        		"\r\n" + 
        		"Es ist möglich, ein Stück des Gegners oder eines seiner eigenen Stücke abzudecken.\r\n" + 
        		"Wenn ein Teil, das ein anderes abdeckt, bewegt wird, " + 
        		"verborgen wieder sichtbar werden.\r\n" + 
        		"\r\n" + 
        		"Ein Spieler gewinnt das Spiel, wenn er erreicht, dass alle Teile " + 
        		"Die sichtbare Seite einer Zeile, Spalte oder Diagonale gehört zu ihm.\r\n" + 
        		"Für den Fall, dass beide Spieler bei " + 
        		"mit gleicher Bewegung geht das Spiel weiter, bis ein Spieler " + 
        		"Das ist die Gewinnposition.");
        return avert.get(a);
    }
}
