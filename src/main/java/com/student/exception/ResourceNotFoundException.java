package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String ResourceName;
    private String FieldName;
    private Object FieldValue;


    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldValue));
        this.ResourceName = resourceName;
        this.FieldName = fieldName;
        this.FieldValue = fieldValue;
    }


    public String getResourceName() {
        return ResourceName;
    }

    public String getFieldName() {
        return FieldName;
    }

    public Object getFieldValue() {
        return FieldValue;
    }
}
