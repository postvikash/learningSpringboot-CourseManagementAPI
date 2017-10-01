package App.Model;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
            new Topic("Spring Boot", "springboot", "Spring Boot Primer : Quick Start"),
            new Topic("Maven", "maven", "Introduction to Maven"),
            new Topic("AngularJS", "angular", "Thinking In Angular")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String topicId) {
        ListIterator<Topic> itr = topics.listIterator();
        while(itr.hasNext()) {
            if(itr.next().getCourseId().equals(topicId))
                return itr.previous();
        }
        return null;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String topicId, Topic topic) {
        for(int i = 0; i < topics.size(); i++) {
            if(topics.get(i).getCourseId().equals(topicId)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String topicId) {
        for(int i = 0; i < topics.size(); i++) {
            if(topics.get(i).getCourseId().equals(topicId)) {
                topics.remove(i);
                return;
            }
        }
    }
}
