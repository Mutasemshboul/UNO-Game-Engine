import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    private Deck deck;
    private List<Player> players;
    private Card topCard;
    private int currentPlayerIndex;
    private boolean reverse;
    private Factory  factory;
    private Factory  otherFactory;
    private ScoreBehavior scoreBehavior;

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Factory getOtherFactory() {
        return otherFactory;
    }

    public ScoreBehavior getScoreBehavior() {
        return scoreBehavior;
    }

    public Game(){
        deck = new Deck();
        players = new ArrayList<>();
        topCard = null;
        currentPlayerIndex = 0;
        reverse = false;
        this.factory = new CardFactory();
        this.scoreBehavior = new BasicScore();

    }

    public void setOtherFactory(Factory otherFactory) {
        this.otherFactory = otherFactory;
    }

    public void setScoreBehavior(ScoreBehavior scoreBehavior) {
        this.scoreBehavior = scoreBehavior;
    }


    public void setupGame() {
        Scanner scanner = new Scanner(System.in);



        try {
            System.out.print("Enter the number of players (2 - 10): ");
            int numPlayers = scanner.nextInt();
            if(numPlayers>=2 && numPlayers<=10){
                for (int i = 1; i <= numPlayers; i++) {
                    System.out.print("Enter the name of player " + i + ": ");
                    String playerName = scanner.next();
                    players.add(new Player(playerName));
                }

                deck.shuffle();
                dealInitialCards();
                topCard = deck.drawCard();
            }
            else {
                System.out.println("Please Enter a valid number");
                setupGame();
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            setupGame();
        }





    }

    protected void dealInitialCards() {
        if(this.otherFactory == null){
            for (Player player : players) {
                for (int i = 0; i < 7; i++) {
                    if((deck.drawCard().getValue()!=(Value.OPTIONAL))){
                        player.addCardToHand(deck.drawCard());
                    }

                }
            }
        }
        else{
            for (Player player : players) {
                for (int i = 0; i < 7; i++) {
                    player.addCardToHand(deck.drawCard());
                }
            }
        }

    }

    private boolean canPlayCard(Player player) {
        for (Card card : player.getHand()) {
            if (isValidPlay(card)|| card.getValue()==Value.WILD||card.getValue()==Value.WILD_DRAW_FOUR||card.getValue()==Value.OPTIONAL) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPlay(Card card) {
        return card.getColor().equals(topCard.getColor()) || card.getValue().equals(topCard.getValue());
    }
    public void startGame() {
        setupGame();
        playGame();
    }
    public void addCard(Card c){
        if(this.otherFactory!=null){
            this.deck.addCard(c);
        }
        else{
            System.out.println("Please choose your own Factory Card");
        }
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("Current card: " + topCard);
            System.out.println("Current color: " + topCard.getColor());
            System.out.println(currentPlayer.getName() + "'s turn");
            System.out.println("Your score : "+ currentPlayer.getScore());

            if (canPlayCard(currentPlayer)) {
                System.out.println("Your hand: " + currentPlayer.getHand());

                System.out.print("Enter the index of the card you want to play (1-" + ( players.get(currentPlayerIndex).getHand().size()) + "): ");
                int cardIndex = scanner.nextInt();
                if(cardIndex<1 || cardIndex > players.get(currentPlayerIndex).getHand().size()){
                   throw new NumberFormatException();
                }

                Card card = currentPlayer.playCard(cardIndex-1);


                 if(card.getValue()==Value.WILD_DRAW_FOUR||card.getValue()==Value.WILD || card.getValue()==Value.OPTIONAL){
                     if(this.otherFactory!=null){
                         if(card.getValue()==Value.OPTIONAL){
                             card = otherFactory.createCard(card);
                             card.doAction(this);
                             topCard.setValue(card.getValue());
                             topCard.setColor(card.getColor());
                         }
                         else {
                             card = factory.createCard(card);
                             card.doAction(this);
                         }
                     }


                }
                else if (isValidPlay(card)){
                    if(card.getValue()==Value.DRAW_TOW||card.getValue()==Value.SKIP||card.getValue()==Value.REVERSE){
                        card = factory.createCard(card);
                        card.doAction(this);
                        topCard.setValue(card.getValue());
                        topCard.setColor(card.getColor());
                    }
                    else{
                        topCard.setValue(card.getValue());
                        topCard.setColor(card.getColor());
                    }
                    scoreBehavior.calculateBehavior(this);
                }
                else {
                    System.out.println("Invalid play! Try again.");
                    currentPlayer.addCardToHand(card);
                }
            } else {
                System.out.println("No playable cards. Drawing a card...");
                Card drawnCard = deck.drawCard();
                currentPlayer.addCardToHand(drawnCard);
                System.out.println("You drew: " + drawnCard);

                if (isValidPlay(drawnCard)) {
                    topCard = drawnCard;
                }
            }

            System.out.println("-----------------------------------------------");

            if (currentPlayer.getHand().isEmpty()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (reverse) {
                currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
    }






}
