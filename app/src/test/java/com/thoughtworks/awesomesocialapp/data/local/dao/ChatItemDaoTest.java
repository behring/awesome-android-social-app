package com.thoughtworks.awesomesocialapp.data.local.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.test.TestUtils;
import androidx.test.core.app.ApplicationProvider;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ChatItemDaoTest {

    private ChatItemDao chatItemDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        chatItemDao = db.getChatItemDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void writeChatItemAndReadInList() throws ParseException {
        ChatItem chatItem = TestUtils.createChatItem();
        chatItem.setName("lin");
        chatItemDao.insert(chatItem);
        List<ChatItem> chatItems = chatItemDao.findChatItems();
        assertThat(chatItems.get(0).getName(), equalTo(chatItem.getName()));
    }
}