public class BasicCard extends Card{
    public BasicCard(Color color, Value value,String type ){
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        System.out.println("BasicCardr");
    }

    @Override
    public int getScore() {
        return 2;
    }
}
