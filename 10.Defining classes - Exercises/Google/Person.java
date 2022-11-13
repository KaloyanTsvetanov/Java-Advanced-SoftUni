import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private Car car;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private List<Parents> parentsList = new ArrayList<>();
    private List<Children> childrenList = new ArrayList<>();

    public Person() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append("\n");
        if(company!=null){
            sb.append(getCompany().toString()).append("\n");
        }

        sb.append("Car:").append("\n");
        if(car!=null) {
            sb.append(getCar().toString()).append("\n");
        }

        sb.append("Pokemon:").append("\n");
        if(pokemonList!=null){
            for(var a: getPokemonList()){
                sb.append(a.toString()).append("\n");
            }
        }

        sb.append("Parents:").append("\n");
        if(parentsList!=null){
            for(var a: getParentsList()){
                sb.append(a.toString()).append("\n");
            }
        }

        sb.append("Children:").append("\n");
        if(childrenList!=null){
            for(var a: getChildrenList()){
                sb.append(a.toString()).append("\n");
            }
        }
        String result = sb.toString();
        return result;

    }
}
