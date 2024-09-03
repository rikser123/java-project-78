package io.hexlet.schemas;

import java.util.Map;
import java.util.function.Function;

public class BaseSchema<T> {
    protected Map<String, Function<T, Boolean>> validators;

    public BaseSchema(Map<String, Function<T, Boolean>> validators) {
        this.validators = validators;
    }

    public boolean isValid(T value) {
        var isValid = true;
        var validationFuncs = validators.values();

        for (var validator : validationFuncs) {
            if (!validator.apply(value)) {
                isValid = false;
            }
        }

        return isValid;
    }
}
