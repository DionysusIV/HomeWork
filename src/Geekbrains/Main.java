package Geekbrains;

public class Main {

    public static void main(String[] args) {
	    Competitor [] competitors = {
                new Human(),
                new Cat(),
                new Robot()
        };

        Obstacle[] obstacles = {
                new Cross(300),
                new Wall(1)
        };

        for(Competitor c: competitors){
            for(Obstacle o: obstacles){
                if(!o.action(c)){
                    break;
                };
            }
        }
    }
}
