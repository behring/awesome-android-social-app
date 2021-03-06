package com.thoughtworks.awesomesocialapp.chats;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;
import com.thoughtworks.awesomesocialapp.common.ViewModelFactory;
import com.thoughtworks.awesomesocialapp.data.FetchDataCallback;
import com.thoughtworks.awesomesocialapp.databinding.FragmentChatsBinding;

public class ChatsFragment extends Fragment {
    private FragmentChatsBinding binding = null;
    private ChatsViewModel viewModel;
    private ChatsRecyclerViewAdapter adapter;

    public static ChatsFragment newInstance() {
        return new ChatsFragment();
    }

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
        adapter = new ChatsRecyclerViewAdapter();
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            viewModel = ViewModelProviders.of(this, factory).get(ChatsViewModel.class);
        }
        viewModel.getData(new FetchDataCallback<List<ChatItem>>() {
            @Override
            public void onFetchDataSuccess(List<ChatItem> data) {
                adapter.updateData(data);
            }

            @Override
            public void onFetchDataFailure(Throwable throwable) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
