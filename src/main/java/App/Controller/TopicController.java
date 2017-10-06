package App.Controller;

import App.Model.DriverRepository;
import App.Model.Topic;
import App.Model.Driver;
import java.util.List;
import java.util.ArrayList;

import App.Model.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.ListIterator;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private DriverRepository driverRepository;

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

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping("/drivers")
    public List<Driver> getDriver() {
        List<Driver> drivers = new ArrayList();

        driverRepository.findAll()
        .forEach(drivers :: add);
        return drivers;

    }


}
