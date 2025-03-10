package org.skypro.skyshop;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.searcheble.Searchable;
import java.util.List;
import java.util.Set;

public final class ArrayTools {

    public static final int NOT_FOUND = -1;


    @SuppressWarnings("unused")
    @Contract(pure = true)
    public static <T> int getFirsIndex(T[] array, boolean free) {
        for (int i = 0; i < array.length; i++) {
            if (free && array[i] == null) {
                return i;
            } else if (!free && array[i] != null) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @SuppressWarnings("unused")
    public static <T> @NotNull String toString(List<T> list) {
        if (list == null) {
            return "";
        }

        String[] semiResults = new String[list.size()];
        for (int i = 0; i < semiResults.length; i++) {
            semiResults[i] = list.get(i).toString();
        }
        return String.join(", ", semiResults);
    }


    public static <K, V> @NotNull String toString(Set<Searchable> map) {
        if (map == null) {
            return "";
        }

        var sb = new StringBuilder();
        for (var mapEntry : map.entrySet()) {
            sb.append(mapEntry.getKey()).append(": ").append(mapEntry.getValue())
                    .append('\n');

        }
        return sb.toString();
    }
}