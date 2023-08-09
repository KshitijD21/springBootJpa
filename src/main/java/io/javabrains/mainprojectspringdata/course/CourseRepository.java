package io.javabrains.mainprojectspringdata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> getByTopicId(String topicId);

}
