package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (checkOnNull(address, field)) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (checkOnNull(address, field)) {
                    result.put(field.getName(), List.of(
                            "can not be null"
                    ));
                } else if (checkOnLength(address, field)) {
                    result.put(field.getName(), List.of(
                            "length less than " + field.getAnnotation(MinLength.class).minLength()
                    ));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public static boolean checkOnNull(Address address, Field field) throws IllegalAccessException {
        return field.isAnnotationPresent(NotNull.class) && field.get(address) == null;
    }
    public static boolean checkOnLength(Address address, Field field) throws IllegalAccessException {
        return field.isAnnotationPresent(MinLength.class)
                && field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength();
    }
}
// END
