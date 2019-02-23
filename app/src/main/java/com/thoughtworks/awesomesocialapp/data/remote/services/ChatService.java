package com.thoughtworks.awesomesocialapp.data.remote.services;

import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ChatService {
    @GET("chat_items")
    Call<ResponseResult<List<ChatsItem>>> getChatItems();
}
