package hr.infomare.cop.opci;

import java.lang.reflect.Field;

public class Pomocna {
    public Pomocna() {
        super();
    }

    public static void debugObjekta(Object object) {
        if (object == null) {
            System.err.println("Debug null referenca!!!");
        } else {
            Class klasa = object.getClass();
            Field[] polja = klasa.getDeclaredFields();
            for (Field polje : polja) {
                polje.setAccessible(true);
                try {
                    System.out.println("----------------------------------------");
                    System.out.println(polje.getName() + ": " + polje.get(object));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}
