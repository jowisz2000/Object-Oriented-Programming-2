import java.util.Random;

public non-sealed class RandomWord extends RandomString{
    public RandomWord(int pole) {
        super(pole);
    }

    @Override
    public String rand() {
        String seed="qwertyuiopasdfghjklzxcvbnm";
        StringBuilder tmp= new StringBuilder();

        for(int i=0; i<getPole(); i++){
            Random random = new Random();
            tmp.append(seed.charAt(random.nextInt(seed.length())));
        }
        return tmp.toString();
    }
}
