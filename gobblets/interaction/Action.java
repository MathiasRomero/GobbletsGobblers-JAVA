package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Action {

    public Action(){

    }

    public abstract boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException;

    public abstract boolean appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException;
}
