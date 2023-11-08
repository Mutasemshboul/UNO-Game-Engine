public class MutasemScore implements ScoreBehavior{
    @Override
    public void calculateBehavior(Game g) {

        //Card c  = g.topCard;
        int score= g.getPlayers().get(g.getCurrentPlayerIndex()).getScore();
        if( score%2==0 && score!=0){
            g.getPlayers().get(g.getCurrentPlayerIndex()).setScore(g.getTopCard().getScore()+5);
        }else{
            g.getPlayers().get(g.getCurrentPlayerIndex()).setScore(g.getTopCard().getScore()+2);
        }


    }
}
