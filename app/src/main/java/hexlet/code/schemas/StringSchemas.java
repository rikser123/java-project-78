package hexlet.code.schemas;

import java.util.function.Function;
import java.util.Map;

public class StringSchemas extends BaseSchema<String> {

    public StringSchemas(Map<String, Function<String, Boolean>> validators) {
        super(validators);
    }

    public StringSchemas required() {
        Function<String, Boolean> validator = value -> value != null && !value.isEmpty();
        validators.put("required", validator);

        return new StringSchemas(validators);
    }

    public StringSchemas minLength(Integer length) {
        Function<String, Boolean> validator = value -> {
            if (value == null) {
                return false;
            }
            return value.length() >= length;
        };
        validators.put("minLength", validator);

        return new StringSchemas(validators);
    }

    public StringSchemas contains(String string) {
        Function<String, Boolean> validator = value -> value.contains(string);
        validators.put("contains", validator);

        return new StringSchemas(validators);
    }
}
