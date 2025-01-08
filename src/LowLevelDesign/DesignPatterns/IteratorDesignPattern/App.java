package LowLevelDesign.DesignPatterns.IteratorDesignPattern;

public class App {

    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();
        courseRepository.addCourse(new Course("Design Patterns"));
        courseRepository.addCourse(new Course("Spring"));
        courseRepository.addCourse(new Course("Java"));


        Iterator iterator = courseRepository.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
