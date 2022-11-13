public class Children {
    private String nameOfChild;
    private String childDateOfBirth;

    public Children(String nameOfChild, String childDateOfBirth) {
        this.nameOfChild = nameOfChild;
        this.childDateOfBirth = childDateOfBirth;
    }

    public String getNameOfChild() {
        return nameOfChild;
    }

    public void setNameOfChild(String nameOfChild) {
        this.nameOfChild = nameOfChild;
    }

    public String getChildDateOfBirth() {
        return childDateOfBirth;
    }

    public void setChildDateOfBirth(String childDateOfBirth) {
        this.childDateOfBirth = childDateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(getNameOfChild()+" "+getChildDateOfBirth());
    }
}
