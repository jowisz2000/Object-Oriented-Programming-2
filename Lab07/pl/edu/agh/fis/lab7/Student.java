package pl.edu.agh.fis.lab7;

public class Student extends Person {

    private int idNumber;
    private double average;

    public Student(String firstName, String lastName, int idNumber, double average) {
        super(firstName, lastName);
        this.idNumber=idNumber;
        this.average=average;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public Person greater(Person ob) {

        if (!(ob instanceof Student))
            return null;

        Student tmp = (Student) ob;
        double tmpAvg = tmp.getAverage();
        if(average>tmpAvg){
            return this;
        }
        else{
            return ob;
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", id number: " + idNumber + ", average: " + average;
    }
}
