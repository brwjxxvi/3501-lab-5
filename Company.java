public class Company{
    int classement[];
    String name;
    public Company(String name, int[] ranking){
        this.classement = ranking;
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}