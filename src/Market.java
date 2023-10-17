import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour{
    private final List<Actor> queue;

    public Market(){
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин ");
        takeInQueue(actor);
    }



    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь ");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for(Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for(Actor actor: queue){
            if(actor.isMakeOrder()){
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил заказ ");
            }
        }
    }


    @Override
    public void relaseFromQueue() {
        List<Actor> relasedActors = new ArrayList<>();
        for(Actor actor: queue){
            if(actor.isTakeOrder()){
                relasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди ");
            }
        }
        relaseFromMarket(relasedActors);
    }

    @Override
    public void relaseFromMarket(List<Actor> actors) {
        for(Actor actor: actors){
            queue.remove(actor);
            System.out.println(actor.getName() + " вышел из магазина");
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        relaseFromQueue();
    }
}
