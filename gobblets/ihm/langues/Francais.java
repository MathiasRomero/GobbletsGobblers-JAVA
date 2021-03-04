package gobblets.ihm.langues;
import gobblets.data.*;
import gobblets.ihm.*;


import java.util.HashMap;

public class Francais implements Dictionnaire {
    private HashMap<Couleur,String> couleurs;
    private HashMap<Taille,String> tailles;
    private HashMap<Etat,String> etats;
    private HashMap<ActionType,String> actions;
    private HashMap<Erreur,String> erreurs;
    private HashMap<Menu,String> menu;
    private HashMap<Avertissement,String> avert;

    public Francais() {

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
        couleurs.put(Couleur.WHITE,"blanc");
        couleurs.put(Couleur.ROUGE,"rouge");
        couleurs.put(Couleur.VERT,"vert");
        couleurs.put(Couleur.BLEU,"bleu");
        couleurs.put(Couleur.JAUNE,"jaune");
        return couleurs.get(c);
    }

    @Override
    public String taille(Taille t) {
        tailles.put(Taille.PETITE,"petite");
        tailles.put(Taille.MOYENNE,"moyenne");
        tailles.put(Taille.GRANDE,"grande");
        return tailles.get(t);
    }

    @Override
    public String etat(Etat e) {
        etats.put(Etat.MATCHNUL,"Match nul");
        etats.put(Etat.JOUEUR1GAGNE,"Victoire du joueur 1");
        etats.put(Etat.JOUEUR2GAGNE,"Victoire du joueur 2");
        etats.put(Etat.JEUENCOURS,"En cours");
        etats.put(Etat.JEUQUITTE,"Vous avez quittez");
        return etats.get(e);
    }

    @Override
    public String action(ActionType a) {
        actions.put(ActionType.PLACER,"Placer");
        actions.put(ActionType.DEPLACER,"Deplacer");
        actions.put(ActionType.QUITTER,"Quitter");
        actions.put(ActionType.ANNULER,"Annuler");
        return actions.get(a);
    }

    @Override
    public String erreur(Erreur e) {
        erreurs.put(Erreur.PASDEPIECEICI,"Pas de pi�ce ici");
        erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Pas de pi�ce ici");
        erreurs.put(Erreur.PASTAPIECE,"Pas ta pièce");
        erreurs.put(Erreur.CASEBLOQUEE,"La case est bloquée");
        erreurs.put(Erreur.ARGUMENTCORRECT,"Argument incorrect");
        erreurs.put(Erreur.DIAGONALEINCORRECTE,"Diagonale incorrecte");
        erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Taille non disponible");
        erreurs.put(Erreur.ORIGINEVIDE,"Origine vide");
        erreurs.put(Erreur.ERREUR,"ERREUR");
        erreurs.put(Erreur.IMPLACE,"Placement interdit");
        erreurs.put(Erreur.IMPDEPLACE,"Deplacement interdit");
        return erreurs.get(e);
    }

    @Override
    public String Menu(Menu m) {
        menu.put(Menu.MENU_AIDE,"Aide");
        menu.put(Menu.MENU_APROPOS,"A propos");
        menu.put(Menu.MENU_ENREGISTRER,"Enregistrer");
        menu.put(Menu.MENU_FICHIER,"Fichier");
        menu.put(Menu.MENU_LANGUE,"Langue");
        menu.put(Menu.MENU_NOUVEAU,"Nouveau");
        menu.put(Menu.MENU_OUVRIR,"Ouvrir");
        menu.put(Menu.MENU_QUITTER,"Quitter");
        menu.put(Menu.MENU_VALIDER,"Valider");
        menu.put(Menu.MENU_PARTIE,"Partie");
        return menu.get(m);

    }

    @Override
    public String Avertissement(Avertissement a) {
        avert.put(Avertissement.TONTOUR, "C'est ton tour");
        avert.put(Avertissement.JOUEUR, "Joueur");
        avert.put(Avertissement.CHOIXACTION, " choix de l'action");
        avert.put(Avertissement.CHOIXDESTINATION, "choix de la destination");
        avert.put(Avertissement.CHOIXORIGIN, "choix de l'origine");
        avert.put(Avertissement.CHOIXTAILLE, "choix de la taille");
        avert.put(Avertissement.COULEURJOUEUR, "Couleur du joueur");
        avert.put(Avertissement.NOMJOUEUR, "Nom du joueur");
        avert.put(Avertissement.CHOIXCOULEUR,"Choix de ta couleur");
        avert.put(Avertissement.PIECERESTANTE,"Pi�ce restante");
        avert.put(Avertissement.JOUEURCOULDIF,"Les joueur doivent avoir des couleur diff�rente");
        avert.put(Avertissement.REGLE, "Ce jeu se joue � deux joueurs sur un plateau constitu� d�un damier de trois\r\n" + 
        		"cases par trois cases, comme le morpion. Chaque joueur dispose au d�but de six " + 
        		"pi�ces dans sa maison. Les pi�ces peuvent �tre de trois tailles : petite, " + 
        		"moyenne ou grosse, et chacun poss�de deux pi�ces de chaque taille.\n" + 
        		"\r\n" + 
        		"    Les joueurs ex�cutent chacun leur tour une action parmiles deux actions suivantes :\r\n" + 
        		"\r\n" + 
        		"� un joueur peut placer une pi�ce de sa maison sur une case du plateau\r\n" + 
        		"� un joueur peut d�placer l�une de ses pi�ces pr�sentes sur le plateau (et " + 
        		"visible) vers une autre case du plateau.\r\n" + 
        		"\r\n" + 
        		"    Pour placer/d�placer une pi�ce sur le plateau, il est n�cessaire que la case\r\n" + 
        		"d�arriv�e soit libre ou ne contienne que des pi�ces plus petites que la pi�ce plac�e.\r\n" + 
        		"\r\n" + 
        		"    Dans le cas o� une pi�ce est pos�e sur une case occup�e, celle-ci couvre alors " + 
        		"les pi�ces d�j� pr�sentes, les rendant invisibles. Seule la plus grande pi�ce pr�sente sur la case est visible.\r\n" + 
        		"\r\n" + 
        		"    Il est possible de couvrir une pi�ce de l�adversaire ou l�une de ses propres pi�ces.\r\n" + 
        		"Lorsque l�on d�place une pi�ce qui en couvrait une autre, la pi�ce pr�c�demment " + 
        		"cach�e redevient alors visible. \r\n" + 
        		"\r\n" + 
        		"    Un joueur remporte la partie lorsqu�il parvient � ce que toutes les pi�ces " + 
        		"visibles d�une ligne, d�une colonne ou d�une diagonale lui appartiennent. \r\n" + 
        		"Dans le cas o� les deux joueurs satisfont la condition de victoire lors " + 
        		"d�un m�me mouvement, la partie continue jusqu�� ce qu�un seul joueur soit en " + 
        		"position gagnante.");
        return avert.get(a);
    }
}
