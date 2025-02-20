package org.skypro.skyshop.searcheble;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.StringTools;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public final class SearchEngine {
    private final HashSet<Searchable> searchableItems;


    public SearchEngine() {
        this.searchableItems = new HashSet<>();
        clear();
    }

    public void clear() {
        searchableItems.clear();
    }


    public void add(@NotNull Searchable searchable) {
        searchableItems.add(searchable);
    }


    public static final int MAX_RESULTS = 10_000;


    @NotNull
    public Set<Searchable> search(@NotNull String query) {
        Set<Searchable> results = new TreeSet<>(new CustomComparator());

        int i = 0;
        for (Searchable searchable : searchableItems) {
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

    public static class CustomComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int result = Integer.compare(o1.getSearchableName().length(),
                    o2.getSearchableName().length());
            if (result != 0) {
                return o1.getSearchableTerm().compareTo(o2.getSearchableTerm());
            }
            return result;
        }
    }


    @NotNull
    public Searchable searchMostFrequent(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        Searchable mostFrequent = searchableItems.getFirst();
        int maxCount = StringTools.countMatches(mostFrequent.getSearchableTerm(), query);

        for (Searchable searchable : searchableItems) {
            int count = StringTools.countMatches(searchable.getSearchableTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = searchable;
            }
        }
        if (maxCount <= 0) {
            throw new BestResultNotFound("Не найдено совпадений");
        }
        return mostFrequent;
    }
}
