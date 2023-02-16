public sealed abstract class RandomString permits RandomWord, LoremIpsum{
    private final int pole;

    public RandomString(int pole) {
        this.pole = pole;
    }

    public int getPole() {
        return pole;
    }

    abstract public String rand();
}
