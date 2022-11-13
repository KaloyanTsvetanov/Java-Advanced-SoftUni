import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String date;
    private List<Parent> parentList = new ArrayList<>();
    private List<Child> childList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" ").append(getDate()).append("\n");
        sb.append("Parents:").append("\n");
        if(parentList!=null) {
            for (var a : getParentList()){
                sb.append(a.toString()).append("\n");
            }
        }
        sb.append("Children:").append("\n");
        if(childList!=null){
            for(var a : getChildList()){
                sb.append(a.toString()).append("\n");
            }
        }
        String result = sb.toString();
        return result;
    }
}
