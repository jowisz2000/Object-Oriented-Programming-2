import java.util.*;

public class Main {

    public static void fillCollections(ArrayList<Item<String>> students3) {
        Random random = new Random();
        String seed="qwertyuiopasdfghjklzxcvbnm";
        StringBuilder tmp= new StringBuilder();
        StringBuilder tmp2= new StringBuilder();

        for(int j=0; j<8; j++){
            tmp.append(seed.charAt(random.nextInt(seed.length())));
            tmp2.append(seed.charAt(random.nextInt(seed.length())));
        }
        students3.add(new Item(tmp,tmp2, UUID.randomUUID()));
    }
    
    static public void fill(Collection<Item<String>> toCheck, List<Item<String>> toAdd){
        long startTime = System.nanoTime();
        for (Item<String> stringItem : toAdd) {
            toCheck.add(stringItem);
        }
        long finishTime = System.nanoTime();
        System.out.println("Time needed to add all elements to "+toCheck.getClass().getName()+" : "+(finishTime-startTime)/1e6);
    }

    static public void addFirstElement(List<Item<String>> toCheck, List<Item<String>> toAdd){
        long startTime  = System.nanoTime();
        for (Item<String> stringItem : toAdd) {
            toCheck.add(0, stringItem);
        }
        long finishTime = System.nanoTime();
        System.out.println("To add in front of "+ toCheck.getClass().getName()+" "+(finishTime-startTime)/1e6);
    }

    static public void findElement(Collection<Item<String>> toCheck, List<Item<String>> toAdd){
        long startTime = System.nanoTime();
        for(Item<String> stringItem:toAdd){
            toCheck.contains(stringItem);
        }
        long finishTime = System.nanoTime();
        System.out.println("Search in "+ toCheck.getClass().getName()+": " +(finishTime-startTime)/1e6);
    }

    public static void main(String[] args) {

        ArrayList<Item<String>> students1 = new ArrayList<>();
        for(int i=0; i<100000; i++){
            fillCollections(students1);
        }

        ArrayList<Item<String>> students2 = new ArrayList<>();
        for(int i=0; i<300; i++){
            Random random = new Random();
            students2.add(students1.get(random.nextInt(100000)));
        }

        ArrayList<Item<String>> students3 = new ArrayList<>();
        for(int i=0; i<300; i++){
            fillCollections(students3);
        }

        ArrayList<Item<String>> arrayListToCheck = new ArrayList<>();
        fill(arrayListToCheck, students1);

        LinkedList<Item<String>> linkedListToCheck = new LinkedList<>();
        fill(linkedListToCheck, students1);

        HashSet<Item<String>> hashSetToCheck = new HashSet<>();
        fill(hashSetToCheck, students1);

        arrayListToCheck.clear();
        linkedListToCheck.clear();

        System.out.println(" ");
        addFirstElement(arrayListToCheck, students1);
        addFirstElement(linkedListToCheck, students1);
        System.out.println(" ");

        findElement(arrayListToCheck, students2);
        findElement(linkedListToCheck, students2);
        findElement(hashSetToCheck, students2);
        System.out.println(" ");

        findElement(arrayListToCheck, students3);
        findElement(linkedListToCheck, students3);
        findElement(hashSetToCheck, students3);
    }
}