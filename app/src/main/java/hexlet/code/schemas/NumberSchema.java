package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Function;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema(Map<String, Function<Integer, Boolean>> validators) {
        super(validators);
    }

    public NumberSchema required() {
        Function<Integer, Boolean> validator = value -> value != null;
        validators.put("required", validator);

        return new NumberSchema(validators);
    }

    public NumberSchema positive() {
        Function<Integer, Boolean> validator = value -> value == null || value > 0;
        validators.put("positive", validator);

        return new NumberSchema(validators);
    }

    public NumberSchema range(Integer start, Integer end) {
        Function<Integer, Boolean> validator = value -> value >= start && value <= end;
        validators.put("range", validator);

        return new NumberSchema(validators);
    }

}
