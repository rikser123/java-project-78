package io.hexlet.schemas;

import java.util.function.Function;
import java.util.Map;

public class StringSchemas {
    private Map<String, Function<String, Boolean>> validators;

    public StringSchemas(Map<String, Function<String, Boolean>> validators) {
        this.validators = validators;
    }

    public StringSchemas required() {
        Function<String, Boolean> validator = value -> value != null && !value.isEmpty();
        validators.put("required", validator);

        return new StringSchemas(validators);
    }

    public StringSchemas minLength(Integer length) {
        Function<String, Boolean> validator = value -> value.length() >= length;
        validators.put("minLength", validator);

        return new StringSchemas(validators);
    }

    public StringSchemas contains(String string) {
        Function<String, Boolean> validator = value -> value.contains(string);
        validators.put("contains", validator);

        return new StringSchemas(validators);
    }

    public boolean isValid(String value) {
        var isValid = true;
        var validationFuncs = validators.values();

        for (var validator : validationFuncs) {
            if (!validator.apply((value))) {
                isValid = false;
            }
        }

        return isValid;
    }
}
