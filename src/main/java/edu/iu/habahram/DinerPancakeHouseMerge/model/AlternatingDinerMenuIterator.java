package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;
    Calendar date = Calendar.getInstance();
    int day_of_week = date.get(Calendar.DAY_OF_WEEK);

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = computeInitialPosition();
    }

    private int computeInitialPosition() {
        int startingDay = 1; // Monday
        if (day_of_week == Calendar.TUESDAY || day_of_week == Calendar.THURSDAY || day_of_week == Calendar.SATURDAY) {
            startingDay = 2; // Tuesday
        }
        if (day_of_week == Calendar.SUNDAY) {
            startingDay = 3; // Sunday
        }
        int index = startingDay - 1;
        while (index < items.length && items[index] == null) {
            index += 3; // move to the next valid day's menu
        }
        return index;
    }

    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = computeNextValidPosition();
        return menuItem;
    }

    private int computeNextValidPosition() {
        int nextPosition = position + 3;
        while (nextPosition < items.length && items[nextPosition] == null) {
            nextPosition += 3;
        }
        return nextPosition;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
}
