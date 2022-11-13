public class Parents {
    private String nameOfParent;
    private String parentDateOfBirth;

    public Parents(String nameOfParent, String parentDateOfBirth) {
        this.nameOfParent = nameOfParent;
        this.parentDateOfBirth = parentDateOfBirth;
    }

    public String getNameOfParent() {
        return nameOfParent;
    }

    public void setNameOfParent(String nameOfParent) {
        this.nameOfParent = nameOfParent;
    }

    public String getParentDateOfBirth() {
        return parentDateOfBirth;
    }

    public void setParentDateOfBirth(String parentDateOfBirth) {
        this.parentDateOfBirth = parentDateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(getNameOfParent()+" "+getParentDateOfBirth());
    }
}
