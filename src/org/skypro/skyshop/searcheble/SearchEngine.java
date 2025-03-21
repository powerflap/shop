package org.skypro.skyshop.searcheble;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.StringTools;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


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
        Set<org.skypro.skyshop.searcheble.Searchable> results = new TreeSet<>(new CustomComparator());

        int i = 0;
        for (org.skypro.skyshop.searcheble.Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchableTerm().contains(query)) {
                results.put(searchable.getSearchableName(), searchable);
                if (i++ >= MAX_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }




    @NotNull
    public org.skypro.skyshop.searcheble.Searchable searchMostFrequent(String query) throws org.skypro.skyshop.searcheble.BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new org.skypro.skyshop.searcheble.BestResultNotFound("Массив элементов для поиска пуст");
        }

        org.skypro.skyshop.searcheble.Searchable mostFrequent = searchableItems.getFirst();
        int maxCount = StringTools.countMatches(mostFrequent.getSearchableTerm(), query);

        for (org.skypro.skyshop.searcheble.Searchable searchable : searchableItems) {
            int count = StringTools.countMatches(searchable.getSearchableTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = searchable;
            }
        }
        if (maxCount <= 0) {
            throw new org.skypro.skyshop.searcheble.BestResultNotFound("Не найдено совпадений");
        }
        return mostFrequent;
    }
}
