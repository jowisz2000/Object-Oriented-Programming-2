import java.util.Objects;

public class Time {
    private int d;
    private int h;
    private int min;
    private int s;

    static final int SECONDS_PER_MINUTE = 60;
    static final int MINUTES_PER_HOUR = 60;
    static final int HOURS_PER_DAY = 24;

    static Time ZERO = new Time(0,0,0,0);
    static Time ONE_SECOND = new Time(0,0,0,1);
    static Time ONE_MINUTE = new Time(0,0,1,0);
    static Time ONE_HOUR = new Time(0,1,0,0);
    static Time ONE_DAY  = new Time(0,1,0,0);
    static Time ONE_YEAR = new Time(365,0,0,0);

    Time(){}

    Time(int dToAdd, int hToAdd, int minToAdd, int sToAdd){
        this.d= dToAdd;
        this.h = hToAdd;
        this.min = minToAdd;
        this.s = sToAdd;
    }

    static Time timeOf(String timeString){
        String[] splitted = timeString.split(":");
        Integer convertedD = Integer.valueOf(splitted[0]);
        Integer convertedH = Integer.valueOf(splitted[1]);
        Integer convertedMin = Integer.valueOf(splitted[2]);
        Integer convertedS = Integer.valueOf(splitted[3]);
        Time tmp = new Time(convertedD, convertedH, convertedMin, convertedS);
        return tmp;
    }

    static Time copyOf(Time toCopy){
        return new Time(toCopy.d, toCopy.h, toCopy.min, toCopy.s);
    }

    @Override
    public String toString(){
        return String.format("%d:%02d:%02d:%02d", d, h, min, s);
    }

    void addSeconds(int toAdd) {
        this.s += toAdd;
        if (this.s >= SECONDS_PER_MINUTE) {
            this.addMinutes(this.s / SECONDS_PER_MINUTE);
            this.s %= SECONDS_PER_MINUTE;
        }
    }

    void addMinutes(int toAdd){
        this.min+=toAdd;
        if(this.min >= MINUTES_PER_HOUR){
            this.addHours(this.min / MINUTES_PER_HOUR);
            this.min %= MINUTES_PER_HOUR;
        }
    }

    void addHours(int toAdd){
        this.h += toAdd;
        if(this.h >= HOURS_PER_DAY){
            this.addDays(this.h/ HOURS_PER_DAY);
            this.h %= HOURS_PER_DAY;
        }
    }

    void addDays(int toAdd){
        this.d+=toAdd;
    }

    void setDays(int toSet){
        if(toSet<0){
            System.out.println("Błędna liczba dni do ustawienia: "+toSet);
            return;
        }
        this.d = toSet;
    }

    void setHours(int toSet){
        if(toSet>23 || toSet<0){
            System.out.println("Błędna liczba godzin do ustawienia: "+toSet);
            return;
        }
        this.h=toSet;
    }

    void setMinutes(int toSet){
        if(toSet>59 || toSet<0){
            System.out.println("Błędna liczba minut do ustawienia: "+toSet);
            return;
        }
        this.min = toSet;
    }

    void setSeconds(int toSet){
        if(toSet>60 || toSet<0){
            System.out.println("Błędna liczba sekund do ustawienia: "+toSet);
            return;
        }
        this.s=toSet;
    }

    int getDays(){return d;}
    int getHours(){return h;}
    int getMinutes(){return min;}
    int getSeconds(){return s;}

    static Time plusTime(Time first, Time second){
        Time tmp = new Time();
        tmp.addSeconds(first.getSeconds() + second.getSeconds());
        tmp.addMinutes(first.getMinutes() + second.getMinutes());
        tmp.addHours(first.getHours() + second.getHours());
        tmp.addDays(first.getDays() + second.getDays());
        return tmp;
    }

    static Time times(Time first, int toMultiplicate){
        Time tmp = new Time();
        tmp.addSeconds(first.getSeconds() * toMultiplicate);
        tmp.addMinutes(first.getMinutes()* toMultiplicate);
        tmp.addHours(first.getHours() * toMultiplicate);
        tmp.addDays(first.getDays() * toMultiplicate);
        return tmp;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){return true;}
        if(o==null){return false;}
        if(this.getClass() != o.getClass()){
            return false;
        }
        Time time = (Time) o;
        return d==time.getDays() && h==time.getHours() && min==time.getMinutes() && s==time.getSeconds();
    }

    @Override
    public int hashCode(){
        return Objects.hash(d, h, min, s);
    }

}

