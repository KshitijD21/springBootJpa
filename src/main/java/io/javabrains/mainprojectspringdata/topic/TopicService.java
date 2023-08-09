package io.javabrains.mainprojectspringdata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(

                    new Topic("Spring" , "Spring Fremwork" , "Spring Fremwork description"),
                    new Topic("Java" , "Java Fremwork" , "Java Fremwork description"),
                    new Topic("js" , "js Fremwork" , "js Fremwork decription")

            )
    ) ;

    public List<Topic> getAllTopic(){
        List<Topic> topics = new ArrayList<>();
       topicRepository.findAll()
        .forEach(topics::add);
       return topics;
    }

    public Optional<Topic> getTopic(String id){
       return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

//    public void getDelete(String id) {
//        for (int i =0 ; i<topics.size();i++){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.remove(i);
//                return;
//            }
//        }
//    }

    //lambda Expression

    public void deleteTopic(String id){
       topicRepository.deleteById(id);
    }
}
