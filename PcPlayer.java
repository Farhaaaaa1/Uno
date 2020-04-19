package com.company;

public class PcPlayer extends Player {
    @Override
    void getCard(Repository repository) {

    }

    @Override
    void playing(Repository repository, GameSystem game) {
        boolean access = false;
        if (playIsValid(repository))
            puttingAutomatic(repository, game);
        else {
            if (repository.getForfeit() == 1)
                access = true;
            getCard(repository);
        }
        if (playIsValid(repository) && access)
            puttingAutomatic(repository, game);
    }

    public void puttingAutomatic(Repository repository, GameSystem gameSystem) {
        for (Card A :
                CardList) {
            if(repository.getForfeit()==1){



            }
            else if(repository.getForfeit()>1){
              //  if()
            }

        }
    }
}
