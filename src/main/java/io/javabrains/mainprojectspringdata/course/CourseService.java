package io.javabrains.mainprojectspringdata.course;

import io.javabrains.mainprojectspringdata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse(String topicId){
        List<Course> courses = new ArrayList<>();
       courseRepository.getByTopicId(topicId)
        .forEach(courses::add);
       return courses;
    }

    public Optional<Course> getCourse(String id){
       return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

//    public void deleteCourse(String id) {
//        for (int i =0 ; i<courses.size();i++){
//            course t = courses.get(i);
//            if (t.getId().equals(id)){
//                courses.remove(i);
//                return;
//            }
//        }
//    }

    //lambda Expression

    public void deleteCourse(String id){
       courseRepository.deleteById(id);
    }
}
