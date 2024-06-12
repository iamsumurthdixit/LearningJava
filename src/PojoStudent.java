public class PojoStudent {
    int name;
    private int rollNumber;
    protected String address;

    public void setName(int name){
        this.name = name;
    }
    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getName(){
        return name;
    }
    public int getRollNumber(){
        return rollNumber;
    }
    public String getAddress(){
        return address;
    }
}
