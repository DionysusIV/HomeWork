public class Main {
    public static void main(String[] args) {
        ChainingHashMap <Integer ,String> map = new ChainingHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(12,"12");
        map.put(15,"15");


        System.out.println(map);
        System.out.println("map.get(2): " + map.get(2));
        System.out.println("map.delete(1): " + map.delete(1));
        System.out.println("map.delete(1) again: " + map.delete(1));
        System.out.println(map);
    }
}
