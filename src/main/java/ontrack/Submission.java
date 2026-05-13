package ontrack;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Submission {
    private final String status;
    private final String submissionId;
    private final String studentId;
    private final String taskId;
    private final List<String> attachments;
    private final Instant timestamp;

    public Submission(String status, String studentId, String taskId, List<String> attachments) {
        this.status = status;
        this.submissionId = UUID.randomUUID().toString();
        this.studentId = studentId;
        this.taskId = taskId;
        this.attachments = List.copyOf(attachments);
        this.timestamp = Instant.now();
    }

    public String getStatus() {
        return status;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTaskId() {
        return taskId;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}