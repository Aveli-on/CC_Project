package by.Savelii.pp.compatibilityService.dto;

import java.util.ArrayList;
import java.util.List;

public class CompatibilityResponse {
    List<String> errors=new ArrayList<>();

    public CompatibilityResponse() {
    }

    public CompatibilityResponse(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
