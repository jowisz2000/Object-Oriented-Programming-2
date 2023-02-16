public class Main {
    public static void main(String[] args) {
        byte[] a = {9,9,8};
        byte[] b = {4,5,6};
        byte[] c = {2,9,2};
        byte[] d = {9,8};
        BigNumber first = new BigNumber(a,b);
        BigNumber second = new BigNumber(c,d);
        System.out.println(BigNumber.plus(first,second));

    }
}
