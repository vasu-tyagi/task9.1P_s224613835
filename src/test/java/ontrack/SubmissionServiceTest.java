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
}