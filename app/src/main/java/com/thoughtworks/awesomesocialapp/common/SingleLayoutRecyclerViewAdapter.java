package com.thoughtworks.awesomesocialapp.common;

public abstract class SingleLayoutRecyclerViewAdapter extends BaseRecyclerViewAdapter {
    private final int layoutId;

    public SingleLayoutRecyclerViewAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}
