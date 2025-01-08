package LowLevelDesign.DesignPatterns.BuilderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Engineering");
        subs.add("Programming");
        subs.add("Computer Science");
        this.subjects = subs;
        return this;
    }
}
