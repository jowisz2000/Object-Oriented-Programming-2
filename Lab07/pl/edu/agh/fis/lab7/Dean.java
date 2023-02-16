package pl.edu.agh.fis.lab7;

public class Dean extends Person{
    int startYear;
    String degree;
    int endYear;

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Dean(String degree, String firstName, String lastName, int startYear, int endYear) {
        super(firstName, lastName);
        this.degree = degree;
        this.endYear=endYear;
        this.startYear=startYear;
    }

    @Override
    public Person greater(Person ob) {

        if (!(ob instanceof Dean))
            return null;

        Dean tmp = (Dean) ob;
        int tmpDiff = tmp.getEndYear() - tmp.getStartYear();
        if(tmpDiff > (endYear-startYear)){
            return ob;
        }
        else{
            return this;
        }
    }

    @Override
    public String toString() {
        return degree+" "+super.toString()+", Dean of the Faculty from "+startYear+" to "+endYear;
    }
}
