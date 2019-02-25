package com.thoughtworks.awesomesocialapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;

public class TestUtils {

    public static ChatItem createChatItem() throws ParseException {
        ChatItem chatItem = new ChatItem();
        chatItem.setAvatarUrl("");
        chatItem.setName("test user");
        chatItem.setNewMessage("this is test message.");
        chatItem.setNewMessageCount(8);
        chatItem.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse("2016-10-24 21:59:06"));
        return chatItem;
    }
}
