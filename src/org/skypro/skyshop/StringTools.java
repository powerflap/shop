package org.skypro.skyshop;

import org.jetbrains.annotations.NotNull;

public final class StringTools {

    public static int countMatches(@NotNull String searchTerm, @NotNull String query) {
        if (searchTerm.isEmpty() || query.isEmpty()) {
            return 0;
        }

        int count = 0, fromIndex = 0;
        int queryLength = query.length();
        while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) {
            count++;
            fromIndex += queryLength;
        }

        return count;
    }
}