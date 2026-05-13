package ontrack;

import java.util.List;
import java.util.regex.Pattern;

public class SubmissionService {

    private static final Pattern STUDENT_ID_PATTERN = Pattern.compile("s\\d+");
    private static final Pattern TASK_ID_PATTERN = Pattern.compile("[A-Z]+\\d+-\\d+\\.\\d+[A-Z]");

    public Submission submitTask(String studentId, String taskId, List<String> attachments) {
        validateStudentId(studentId);
        validateTaskId(taskId);
        validateAttachments(attachments);
        return new Submission("accepted", studentId, taskId, attachments);
    }

    private void validateStudentId(String studentId) {
        if (studentId == null || !STUDENT_ID_PATTERN.matcher(studentId).matches()) {
            throw new IllegalArgumentException("Invalid student id: " + studentId);
        }
    }

    private void validateTaskId(String taskId) {
        if (taskId == null || !TASK_ID_PATTERN.matcher(taskId).matches()) {
            throw new IllegalArgumentException("Invalid task id: " + taskId);
        }
    }

    private void validateAttachments(List<String> attachments) {
        if (attachments == null || attachments.isEmpty()) {
            throw new IllegalArgumentException("attachments must not be empty");
        }
    }
}