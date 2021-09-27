package za.ac.nwu.ac.web.sb.exception;

import java.util.Arrays;
import java.util.List;

public class ErrorResponse {
    private String error;
    private String errorDescription;
    private Error[] errors;

    ErrorResponse(String error)
    {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public List<Error> getErrors() {
        return Arrays.asList(errors);
    }
}
