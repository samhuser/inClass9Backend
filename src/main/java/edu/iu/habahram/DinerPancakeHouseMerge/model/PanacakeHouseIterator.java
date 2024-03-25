package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class PanacakeHouseIterator implements Iterator{
    int position = 0;
    MenuItem[] items;
    @Override
    public boolean hasNext() {
        if(position >= items.length || items[position] == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem current = items[position];
        position++;
        return current;
    }
}
