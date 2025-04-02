package org.skypro.skyshop.searcheble;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.StringTools;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class SearchEngine {
    private final HashSet<org.skypro.skyshop.searcheble.Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new HashSet<>();
        clear();
    }

    public void clear() {
        searchableItems.clear();
    }

    public void add(@NotNull org.skypro.skyshop.searcheble.Searchable searchable) {
        searchableItems.add(searchable);
    }

    public static final int MAX_RESULTS = 10_000;

    @NotNull
    public Set<org.skypro.skyshop.searcheble.Searchable> search(@NotNull String query) {
        Comparator<org.skypro.skyshop.searcheble.Searchable> comparator = new CustomComparator();

        return searchableItems.stream()
                .filter(item -> item != null && item.getSearchableTerm().contains(query))
                .limit(MAX_RESULTS)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    @NotNull
    public org.skypro.skyshop.searcheble.Searchable searchMostFrequent(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        return searchableItems.stream()
                .filter(item -> item != null)
                .reduce((first, second) -> {
                    int firstMatchCount = StringTools.countMatches(first.getSearchableTerm(), query);
                    int secondMatchCount = StringTools.countMatches(second.getSearchableTerm(), query);

                    return firstMatchCount > secondMatchCount ? first : second;
                })
                .orElseThrow(() -> new BestResultNotFound("Не найдено совпадений"));
    }
}