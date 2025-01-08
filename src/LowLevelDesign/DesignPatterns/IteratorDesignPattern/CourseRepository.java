package LowLevelDesign.DesignPatterns.IteratorDesignPattern;

public class CourseRepository {

    private Course[] courses = new Course[10];
    private int index = 0;

    
    public void addCourse(Course course) {
        courses[index++] = course;
    }

    public Iterator createIterator() {
        return new CourseIterator();
    }


    private class CourseIterator implements Iterator {

        private int position = 0;
        @Override
        public boolean hasNext() {

            if(position < courses.length && courses[position] != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return courses[position++];
        }
    }
}
