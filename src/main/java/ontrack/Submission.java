package ontrack;

import java.util.List;

public class Submission {
    private final String status;

    public Submission(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}