package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("не найден элемент");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean rsl = false;
        for (String abus : abuses) {
            if (value.equals(abus)) {
                rsl = true;
                break;
            }
        }
        if (rsl) {
            throw new ElementAbuseException("запрещенные ключи");
        }
        return rsl;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        }   catch (ElementAbuseException ea) {
            ea.printStackTrace();
        }   catch (ElementNotFoundException e) {
            e.printStackTrace();
        }   catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] array = {"Гусь", "Утка", "Ястреб"};
        try {
            int result = FindEl.indexOf(array, "Кот");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
