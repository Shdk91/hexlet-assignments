package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Object obj) {
    Field[] allFields = obj.getClass().getDeclaredFields();
    List<String> result = new ArrayList<>();
    for (var f : allFields) {
        f.setAccessible(true);
        try {
            if (f.isAnnotationPresent(NotNull.class) && f.get(obj)==null) {
                result.add(f.getName());
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    return result;

    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        String warningLength = "length less than 4";
        String warningNull = "can not be null";
        Field[] allFields = obj.getClass().getDeclaredFields();
        Map<String, List<String>> result = new HashMap<>();

        for (var f : allFields) {
            f.setAccessible(true);
            try {
                String str = (String) f.get(obj);
                if (f.isAnnotationPresent(MinLength.class) && str.length()<4) {
                    result.put(f.getName(), List.of(warningLength));
                }
                if (f.isAnnotationPresent(NotNull.class) && f.get(obj)==null) {
                    result.put(f.getName(), List.of(warningNull));
                }

            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
// END
