package App.Model;

public class Topic {
    private String courseName;
    private String courseId;
    private String courseDesc;

    public Topic(String name, String id, String desc) {
        super();
        courseName = name;
        courseId = id;
        courseDesc = desc;
    }

    public Topic() {
        super();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseName(String val) {
        courseName = val;
    }

    public void setCourseDesc(String val) {
        courseDesc = val;
    }

    public void setCourseId(String val) {
        courseId = val;
    }

}
