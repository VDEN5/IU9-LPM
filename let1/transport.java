public class transport {
    private String typetr;
    public transport(String rty){
        this.typetr=rty;
    }
    public String movereal(){
        if (this.typetr=="car") {return "poechal";}
        if (this.typetr=="samolet"){return "polet";}
        return "nothing";
    }
}
