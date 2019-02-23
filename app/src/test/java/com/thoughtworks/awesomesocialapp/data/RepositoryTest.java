package com.thoughtworks.awesomesocialapp.data;

import android.support.test.filters.SmallTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import com.thoughtworks.awesomesocialapp.DataInjection;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;
import com.thoughtworks.awesomesocialapp.constants.LocalCode;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.network.ServerApiInterface;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import androidx.test.core.app.ApplicationProvider;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
@SmallTest
public class RepositoryTest {

    private Repository repository;

    @Before
    public void setUp() {
        repository = DataInjection.provideRepository(ApplicationProvider.getApplicationContext());
    }

    @Test
    public void getDatabase() {
        assertNotNull(repository.getDatabase());
    }

    @Test
    public void getChatItems_WhenDatabaseHasData_MustGetDataForDatabase() {
        repository.getDatabase().getChatItemDao().insertChatItems(mockChatItems());
        ResponseResult responseResult = repository.getChatItems();
        assertEquals(LocalCode.QUERY_SUCCESS, responseResult.getCode());
    }

    private List<ChatItem> mockChatItems() {
        List<ChatItem> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ChatItem item = new ChatItem();
            item.setAvatarUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000" +
                    "&sec=1550774291648&di=d021d4fec92c4af2474b8bd79af89ea4&imgtype=0&src=" +
                    "http%3A%2F%2Ftupian.qqjay.com%2Ftou3%2F2015%2F1030%2F64d8430af77d66c80" +
                    "254092965e98398.jpg");
            item.setName("test" + i);
            item.setNewMessage("this is a new message " + i);
            item.setNewMessageCount(i + 1);
            item.setTime(new Date());
            data.add(item);
        }
        return data;
    }
}