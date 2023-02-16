import java.util.Random;

public final class LoremIpsum extends RandomString {
    public LoremIpsum(int pole) {
        super(pole);
    }

    @Override
    public String rand() {
        String seed="qwertyuiopasdfghjklzxcvbnm ";
        seed+=seed.toUpperCase();
        StringBuilder tmp= new StringBuilder();
        for(int i=0; i<getPole(); i++){
            Random random = new Random();
            tmp.append(seed.charAt(random.nextInt(seed.length())));
        }
        return tmp.toString();
    }
}
