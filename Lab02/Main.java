import java.math.BigInteger;
import java.util.Arrays;

public class Main{

    public static int nwd(int a, int b){
        int temp;
        while(b!=0){
            temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    public static int extendEuclid(int a, int b){
        int x0=1;
        int x=0;
        int b0=b;
        int q;

        while(b!=0){
            q=a/b;
            int temp=x;
            x= x0-q*x;
            x0=temp;
            temp = a%b;
            a=b;
            b=temp;
        }

        if(x0<9){
            x0+=b0;
        }
        return x0;
    }

    public static void main(String[] args) {
        int p = 397;
        int q = 103;
        int n = p*q;
        int fi = (p-1)*(q-1);

        int e = 3;
        while(nwd(fi, e)!=1){
            e+=2;
        }

        int d = extendEuclid(e, fi);

        if(args.length !=1){
            return;
        }

        byte[] c = new byte[args[0].length()];
        BigInteger[] keys = new BigInteger[args[0].length()];
        BigInteger eConverted = new BigInteger(""+e);
        BigInteger nConverted = new BigInteger(""+n);
        BigInteger dConverted = new BigInteger(""+d);

        for(int i=0; i<args[0].length(); i++){
            c[i] = (byte)args[0].charAt(i);
            BigInteger tmp = new BigInteger(""+c[i]);
            keys[i] = tmp.modPow(eConverted, nConverted);
        }

        String[] checkSolution = new String[args[0].length()];
        for(int i=0; i<args[0].length(); i++){
            checkSolution[i] = ""+ (char) keys[i].modPow(dConverted, nConverted).intValue();
        }

        System.out.println(Arrays.toString(checkSolution));
    }

}
