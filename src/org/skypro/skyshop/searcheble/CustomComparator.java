package org.skypro.skyshop.searcheble;

import java.util.Comparator;

public  class CustomComparator implements Comparator<Searchable> {
    @Override
    public int compare(org.skypro.skyshop.searcheble.Searchable o1, org.skypro.skyshop.searcheble.Searchable o2) {
        int result = Integer.compare(o1.getSearchableName().length(),
                o2.getSearchableName().length());
        if (result != 0) {
            return o1.getSearchableTerm().compareTo(o2.getSearchableTerm());
        }
        return result;
    }
}