import java.util.ArrayDeque;

public class Program {
    public static void main(String[] args){

        ArrayDeque<String> states = new ArrayDeque<>();

        states.add("Germany");
        states.addFirst("France");
        states.push("Great Britain");
        states.addLast("Spain");
        states.add("Italy");


        String sFirst = states.getFirst();
        System.out.println(sFirst);

        String sLast = states.getLast();
        System.out.println(sLast);

        System.out.printf("Queue size: %d \n", states.size());


        while(states.peek()!=null){

            System.out.println(states.pop());
        }


    }
}
