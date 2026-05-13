package ontrack;

import java.util.List;

public class SubmissionService {

    public Submission submitTask(String studentId, String taskId, List<String> attachments) {
        return new Submission("accepted");
    }
}