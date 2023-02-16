import java.util.Arrays;
import static java.lang.Math.max;

public final class BigNumber {

    private final byte[] integerPart;
    private final byte[] fractionalPart;
    BigNumber(byte[] integerPartToSet, byte[]fractionalPartToSet){
        integerPart = Arrays.copyOf(integerPartToSet, integerPartToSet.length);
        fractionalPart = Arrays.copyOf(fractionalPartToSet, fractionalPartToSet.length);
    }


    public static final BigNumber ZERO = new BigNumber(new byte[]{0}, new byte[]{0});
    public static final BigNumber ONE = new BigNumber(new byte[]{1}, new byte[]{0});
    public static final BigNumber TWO = new BigNumber(new byte[]{2}, new byte[]{0});
    public static final BigNumber TEN = new BigNumber(new byte[]{1,0}, new byte[]{0});

    public static BigNumber valueOf(byte[] t1, byte[] t2){
        if(Arrays.equals(ZERO.getInteger(), t1) && Arrays.equals(ZERO.getFraction(), t2)){
            return BigNumber.ZERO;
        }

        if(Arrays.equals(ONE.getInteger(), t1) && Arrays.equals(ONE.getFraction(), t2)){
            return BigNumber.ONE;
        }

        if(Arrays.equals(TWO.getInteger(), t1) && Arrays.equals(TWO.getFraction(), t2)){
            return BigNumber.TWO;
        }

        if(Arrays.equals(TEN.getInteger(), t1) && Arrays.equals(TEN.getFraction(), t2)){
            return BigNumber.TEN;
        }

        return new BigNumber(t1,t2);
    }


    @Override
    public String toString(){
        StringBuilder first = new StringBuilder();
        for (int i=fractionalPart.length-1; i>=0; i--)
            first.append(fractionalPart[i]);

        StringBuilder second = new StringBuilder();
        for (int i=integerPart.length-1; i>=0; i--)
            second.append(integerPart[i]);
        return second+","+first;
    }

    public byte[] getInteger(){
        return Arrays.copyOf(integerPart, integerPart.length);
    }

    public byte[] getFraction(){
        return Arrays.copyOf(fractionalPart, fractionalPart.length);
    }


    static BigNumber plus(BigNumber t1, BigNumber t2){
        int lengthOfFraction = max(t1.getFraction().length, t2.getFraction().length);
        byte[] fractionToReturn = new byte[lengthOfFraction];
        boolean isOver9 = false;

        for(int i=0; i<lengthOfFraction; i++) {
            if (t1.getFraction().length > i) {
                fractionToReturn[i] += t1.getFraction()[i];
            }
            if (t2.getFraction().length > i) {
                fractionToReturn[i] += t2.getFraction()[i];
            }

            if(isOver9){
                fractionToReturn[i]+=1;
                isOver9=false;
            }

            if (fractionToReturn[i] > 9) {
                isOver9=true;
                fractionToReturn[i]-=10;
            }
        }

        int lengthOfInteger = max(t1.getInteger().length, t2.getInteger().length);
        byte[] integerToReturn = new byte[lengthOfInteger];

        for(int j=0; j<lengthOfInteger; j++){
            if (t1.getInteger().length > j) {
                integerToReturn[j] += t1.getInteger()[j];
            }
            if (t2.getInteger().length > j) {
                integerToReturn[j] += t2.getInteger()[j];
            }

            if(isOver9){
                integerToReturn[j]+=1;
                isOver9=false;
            }

            if (integerToReturn[j] > 9) {
                isOver9=true;
                integerToReturn[j]-=10;
            }
        }
        System.out.println(isOver9);

        if(isOver9){
            byte[] tmp = new byte[lengthOfInteger+1];
            tmp[lengthOfInteger]=1;
            tmp[lengthOfInteger-1]-=10;
            System.arraycopy(integerToReturn, 0, tmp, 0, lengthOfInteger);
            return new BigNumber(tmp, fractionToReturn);
        }

        return new BigNumber(integerToReturn, fractionToReturn);
    }
}
