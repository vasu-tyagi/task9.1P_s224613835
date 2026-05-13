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
}