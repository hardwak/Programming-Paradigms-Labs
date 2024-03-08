package Lab8;

import java.lang.reflect.Field;

class Debug {
    public static void fields(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields){
            field.setAccessible(true);
            try {
                System.out.println("Field: " + field.getName() + " => " + field.getType() + ", " + field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

