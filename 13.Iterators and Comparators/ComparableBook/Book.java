import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year,String... authors){
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

//    public Iterator<E> iterator(){
//        return new Iterator<E>() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public E next() {
//                return null;
//            }
//        };
//
//    }

    @Override
    public int compareTo(Book other) {
        int result = this.title.compareTo(other.title);

        if(result==0){
            result = Integer.compare(this.year,other.year);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
