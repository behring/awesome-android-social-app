package com.thoughtworks.awesomesocialapp.chats;

import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.common.SingleLayoutRecyclerViewAdapter;

import java.util.List;

public class ChatsRecyclerViewAdapter extends SingleLayoutRecyclerViewAdapter {
    private List<ChatsItem> data;

    public ChatsRecyclerViewAdapter(List<ChatsItem> data) {
        super(R.layout.item_chats);
        this.data = data;
    }

    @Override
    public Object getItemForPosition(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
