package sk.upjs.ics.usermanagement;

public class ApiError {

    private int status;
    private String error;

    public ApiError(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
