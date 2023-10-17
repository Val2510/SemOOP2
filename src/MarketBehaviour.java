import java.util.List;

public interface MarketBehaviour {
    void acceptToMarket(Actor actor);
    void relaseFromMarket(List<Actor> actors);
    void update();
}
