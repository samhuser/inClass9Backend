package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items){
        this.menuItems = items;
    }

    @Override
    public boolean hasNext() {

    }

    @Override
    public MenuItem next() {
        return null;
    }
    @Override
    public void remove(){
        if(position <= 0){
            throw new IllegalStateException();
        }
        if(menuItems[position-1] != null){
            for(int i = position -1; i<(menuItems.length-1); i++){
                menuItems[i] = menuItems[i+1];
            }
        }
        menuItems[menuItems.length-1] = null;

    }
}
