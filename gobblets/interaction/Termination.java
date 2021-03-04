package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Termination extends Action{
    public Termination(){

    }

    public boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException {
        return true;
    }

    public boolean appliquer(Joueur joueur){
        return false;
    }
}
