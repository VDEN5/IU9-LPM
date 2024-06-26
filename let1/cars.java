public class cars extends  transport {
    public String model;
    public boolean openli;
    public cars(String mode){
        super("cars");
        this.model=mode;
        this.openli=false;
    }
    public void opendoor(){
        this.openli=true;
    }
    public boolean getopenli(){return  this.openli;}
}
