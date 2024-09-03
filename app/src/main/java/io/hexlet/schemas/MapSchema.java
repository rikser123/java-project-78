package io.hexlet.schemas;

import java.util.Map;
import java.util.function.Function;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema(Map<String, Function<Map<String, String>, Boolean>> validators) {
        super(validators);
    }

    public MapSchema required() {
        Function<Map<String, String>, Boolean> validator = value -> value != null;
        validators.put("required", validator);

        return new MapSchema(validators);
    }

    public MapSchema sizeof(Integer limit) {
        Function<Map<String, String>, Boolean> validator = value -> value.keySet().size() == limit;
        validators.put("sizeof", validator);

        return new MapSchema(validators);
    }
}
