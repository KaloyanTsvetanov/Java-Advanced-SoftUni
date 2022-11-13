package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() < capacity) {
            for (Student student1 : students) {
                if (student1.equals(student)) {
                    return "Student is already in the university";
                }
            }
            students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student){
        if(!students.isEmpty() && students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String first, String last) {
        Student student = null;
        if (!students.isEmpty()) {
            student =  students.stream().filter(a -> a.getFirstName().equals(first) && a.getLastName().equals(last)).findAny().get();
        }
        return student;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append("==Student: First Name = ").append(student.getFirstName()).append(", Last Name = ").append(student.getLastName()).append(", Best Subject = ").append(student.getBestSubject()).append("\n");
        }
        return sb.toString();
    }


}
