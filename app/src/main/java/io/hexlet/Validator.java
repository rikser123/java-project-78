package io.hexlet;

import io.hexlet.schemas.StringSchemas;
import java.util.function.Function;
import java.util.HashMap;

public class Validator {
    public StringSchemas string() {
        var validators = new HashMap<String, Function<String, Boolean>>();
        return new StringSchemas(validators);
    }
}
