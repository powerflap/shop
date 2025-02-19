package org.skypro.skyshop.searcheble;

import org.jetbrains.annotations.NotNull;

public interface Searchable {

    @SuppressWarnings("unused")
    @NotNull
    default String getSearchableName() {
        return this.getClass().getSimpleName() + "-" + this.hashCode();
    }


    @NotNull
    String getSearchableTerm();


    @SuppressWarnings("unused")
    @NotNull
    String getSearchableContentKind();
}
