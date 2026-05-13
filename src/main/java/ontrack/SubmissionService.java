package ontrack;

import java.util.List;
import java.util.regex.Pattern;

public class SubmissionService {

    public Submission submitTask(String studentId, String taskId, List<String> attachments) {
        if (studentId == null || !Pattern.matches("s\\d+", studentId)) {
            throw new IllegalArgumentException("Invalid student id: " + studentId);
        }
        if (taskId == null || !Pattern.matches("[A-Z]+\\d+-\\d+\\.\\d+[A-Z]", taskId)) {
            throw new IllegalArgumentException("Invalid task id: " + taskId);
        }
        if (attachments == null || attachments.isEmpty()) {
            throw new IllegalArgumentException("attachments must not be empty");
        }
        return new Submission("accepted");
    }
}