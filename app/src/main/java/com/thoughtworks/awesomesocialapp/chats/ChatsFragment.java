package com.thoughtworks.awesomesocialapp.chats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.common.BaseRecyclerViewAdapter;
import com.thoughtworks.awesomesocialapp.databinding.FragmentChatsBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatsFragment extends Fragment {

    public static ChatsFragment newInstance() {
        return new ChatsFragment();
    }

    private FragmentChatsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentChatsBinding.inflate(inflater);
        initUI();
        return binding.getRoot();
    }

    private void initUI() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new ChatsRecyclerViewAdapter(mockData()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private List<ChatsItem> mockData() {
        List<ChatsItem> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ChatsItem item = new ChatsItem();
            item.setAvatarUrl("ddd");
            item.setName("behring" + i);
            item.setNewMessage("this is a new message " + i);
            item.setNewMessageCount(i + 1);
            item.setTime(new Date());
            data.add(item);
        }
        return data;
    }
}
