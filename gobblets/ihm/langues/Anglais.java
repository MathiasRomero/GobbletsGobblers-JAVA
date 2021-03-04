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

public class Anglais implements Dictionnaire{
    private HashMap<Couleur,String> couleurs;
    private HashMap<Taille,String> tailles;
    private HashMap<Etat,String> etats;
    private HashMap<ActionType,String> actions;
    private HashMap<Erreur,String> erreurs;
    private HashMap<Menu,String> menu;
    private HashMap<Avertissement,String> avert;

    public Anglais() {
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
        couleurs.put(Couleur.WHITE, "white");
        couleurs.put(Couleur.ROUGE, "red");
        couleurs.put(Couleur.VERT, "green");
        couleurs.put(Couleur.BLEU, "blue");
        couleurs.put(Couleur.JAUNE, "yellow");
        return couleurs.get(c);
    }

    @Override
    public String taille(Taille t) {
        tailles.put(Taille.PETITE,"small");
        tailles.put(Taille.MOYENNE,"medium");
        tailles.put(Taille.GRANDE,"big");
        return tailles.get(t);
    }

    @Override
    public String etat(Etat e) {
        etats.put(Etat.MATCHNUL,"Draw");
        etats.put(Etat.JOUEUR1GAGNE,"Player 1 win");
        etats.put(Etat.JOUEUR2GAGNE,"Player 2 win");
        etats.put(Etat.JEUENCOURS,"ongoing");
        etats.put(Etat.JEUQUITTE,"quit");
        return etats.get(e);
    }

    @Override
    public String action(ActionType a) {
        actions.put(ActionType.PLACER,"Place");
        actions.put(ActionType.DEPLACER,"Move");
        actions.put(ActionType.QUITTER,"Quit");
        actions.put(ActionType.ANNULER,"Cancel");
        return actions.get(a);
    }

    @Override
    public String erreur(Erreur e) {
        erreurs.put(Erreur.PASDEPIECEICI,"nothing here");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"pawn not available");
        erreurs.put(Erreur.PASTAPIECE,"Not yours");
        erreurs.put(Erreur.CASEBLOQUEE,"blocked place");
        erreurs.put(Erreur.ARGUMENTCORRECT,"Incorrect Argument");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Incorrect diagonal");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"size not available");
        erreurs.put(Erreur.ORIGINEVIDE,"Empty origin");
        erreurs.put(Erreur.ERREUR,"ERROR");
        erreurs.put(Erreur.IMPLACE,"you can't place that here");
        erreurs.put(Erreur.IMPDEPLACE,"you can't move this here");
        return erreurs.get(e);
    }

    @Override
    public String Menu(Menu m) {
        menu.put(Menu.MENU_AIDE,"Help");
        menu.put(Menu.MENU_APROPOS,"About");
        menu.put(Menu.MENU_ENREGISTRER,"Save");
        menu.put(Menu.MENU_FICHIER,"File");
        menu.put(Menu.MENU_LANGUE,"Language");
        menu.put(Menu.MENU_NOUVEAU,"New");
        menu.put(Menu.MENU_OUVRIR,"Open");
        menu.put(Menu.MENU_QUITTER,"Quit");
        menu.put(Menu.MENU_VALIDER,"Confirm");
        menu.put(Menu.MENU_PARTIE,"Game");
        return menu.get(m);
    }

    @Override
    public String Avertissement(Avertissement a) {
        avert.put(Avertissement.TONTOUR, "It's your turn");
        avert.put(Avertissement.JOUEUR, "Player");
        avert.put(Avertissement.CHOIXACTION, "Choose the action");
        avert.put(Avertissement.CHOIXDESTINATION, "Choose the destination");
        avert.put(Avertissement.CHOIXORIGIN, "Choose the origin");
        avert.put(Avertissement.CHOIXTAILLE, "Choose the size");
        avert.put(Avertissement.COULEURJOUEUR, "Player's color");
        avert.put(Avertissement.NOMJOUEUR, "player's name");
        avert.put(Avertissement.CHOIXCOULEUR,"choose your color");
        avert.put(Avertissement.PIECERESTANTE,"Remaining pawn");
        avert.put(Avertissement.JOUEURCOULDIF,"Each player must have his own color");
        avert.put(Avertissement.REGLE, "This game is played by two players on a board consisting of a checker of three " + 
        		"boxes by three boxes, like the crab. Each player has at the beginning of six " + 
        		"rooms in his house. The rooms can be three sizes: small, " + 
        		"medium or large, and each has two pieces of each size.\r\n" + 
        		"\r\n" + 
        		"Players take turns executing one action among the following two actions:\r\n" + 
        		"\r\n" + 
        		"— a player can place a piece of their house on a board box " + 
        		"— a player can move one of their pieces on the board (and " + 
        		"visible) to another box in the tray.\r\n" + 
        		"\r\n" + 
        		"To place/move a piece on the tray, it is necessary that the " + 
        		"is free or contains only parts smaller than the part placed.\r\n" +
        		"In the case where a part is placed on an occupied box, it then covers " + 
        		"the parts already present, making them invisible. Only the largest part on the box is visible.\r\n" + 
        		"\r\n" + 
        		"It is possible to cover an opponent’s piece or one of his own pieces. " + 
        		"When moving a part that covered another part, the part previously " + 
        		"hidden then becomes visible again.\r\n" + 
        		"\r\n" + 
        		"A player wins the game when he manages to get all the pieces " + 
        		"visible from a line, column or diagonal belong to it.\r\n" + 
        		"In case both players satisfy the condition of victory on " + 
        		"of the same movement, the game continues until only one player is in " + 
        		"winning position.");
        return avert.get(a);
    }
}
