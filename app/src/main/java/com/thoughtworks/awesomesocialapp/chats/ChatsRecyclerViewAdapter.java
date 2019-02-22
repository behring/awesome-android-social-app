package com.thoughtworks.awesomesocialapp.chats;

import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.common.SingleLayoutRecyclerViewAdapter;

public class ChatsRecyclerViewAdapter extends SingleLayoutRecyclerViewAdapter {
    private List<ChatsItem> data = new ArrayList<>();

    ChatsRecyclerViewAdapter() {
        super(R.layout.item_chats);
    }

    @Override
    public Object getItemForPosition(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void updateData(List<ChatsItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
