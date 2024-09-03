package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchemas;

import java.util.Map;
import java.util.function.Function;
import java.util.HashMap;

public final class Validator {
    public StringSchemas string() {
        var validators = new HashMap<String, Function<String, Boolean>>();
        return new StringSchemas(validators);
    }

    public NumberSchema number() {
        var validators = new HashMap<String, Function<Integer, Boolean>>();
        return new NumberSchema(validators);
    }

    public MapSchema map() {
        var validators = new HashMap<String, Function<Map<String, String>, Boolean>>();
        return new MapSchema(validators);
    }
}
