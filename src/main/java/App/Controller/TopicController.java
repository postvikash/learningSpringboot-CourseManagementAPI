package App.Controller;

import App.Model.Topic;
import java.util.List;

import App.Model.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/")
    public String defaultMessage() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{courseId}")
    public Topic getTopic(@PathVariable("courseId") String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}")
    public void addTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}" )
    public void updateTopic(@RequestBody Topic topic, @PathVariable String topicId) {
        topicService.updateTopic(topicId, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
    public void deleteTopic(@PathVariable String topicId) {
        topicService.deleteTopic(topicId);
    }


}
