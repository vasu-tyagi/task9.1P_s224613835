package ontrack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SubmissionService Tests")
class SubmissionServiceTest {

    @Test
    @DisplayName("Cycle 1 RED: valid submission returns accepted status")
    void testValidSubmissionReturnsAcceptedStatus() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act
        Submission result = service.submitTask(
            "s12345",
            "SIT707-9.1P",
            List.of("report.pdf")
        );

        // Assert
        assertEquals("accepted", result.getStatus());
    }

    @Test
    @DisplayName("Cycle 2 RED: invalid student ID throws IllegalArgumentException")
    void testInvalidStudentIdThrowsException() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act + Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> service.submitTask("bob", "SIT707-9.1P", List.of("report.pdf"))
        );
        assertTrue(ex.getMessage().contains("student"));
    }

    @Test
    @DisplayName("Cycle 2 RED: invalid task ID throws IllegalArgumentException")
    void testInvalidTaskIdThrowsException() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act + Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> service.submitTask("s12345", "not a task", List.of("report.pdf"))
        );
        assertTrue(ex.getMessage().contains("task"));
    }

    @Test
    @DisplayName("Cycle 2 RED: empty attachments throws IllegalArgumentException")
    void testEmptyAttachmentsThrowsException() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act + Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> service.submitTask("s12345", "SIT707-9.1P", List.of())
        );
        assertTrue(ex.getMessage().contains("attachments"));
    }

    @Test
    @DisplayName("Cycle 3 RED: accepted submission returns full payload")
    void testAcceptedSubmissionReturnsFullPayload() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act
        Submission result = service.submitTask(
            "s12345",
            "SIT707-9.1P",
            List.of("report.pdf", "code.zip")
        );

        // Assert
        assertEquals("accepted", result.getStatus());
        assertEquals("s12345", result.getStudentId());
        assertEquals("SIT707-9.1P", result.getTaskId());
        assertEquals(List.of("report.pdf", "code.zip"), result.getAttachments());
        assertNotNull(result.getSubmissionId());
        assertNotNull(result.getTimestamp());
    }

    @Test
    @DisplayName("Cycle 3 RED: each submission has a unique submission id")
    void testEachSubmissionHasUniqueId() {
        // Arrange
        SubmissionService service = new SubmissionService();

        // Act
        Submission first = service.submitTask("s12345", "SIT707-9.1P", List.of("a.pdf"));
        Submission second = service.submitTask("s12345", "SIT707-9.1P", List.of("a.pdf"));

        // Assert
        assertNotEquals(first.getSubmissionId(), second.getSubmissionId());
    }
}