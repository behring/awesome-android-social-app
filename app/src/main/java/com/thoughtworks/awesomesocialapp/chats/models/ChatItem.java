package com.thoughtworks.awesomesocialapp.chats.models;

import com.google.gson.annotations.SerializedName;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import java.util.Date;
import com.thoughtworks.awesomesocialapp.models.Table;


@Entity(tableName = "chat_item")
public class ChatItem extends Table {
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String name;
    private Date time;
    @ColumnInfo(name = "new_message")
    @SerializedName("new_message")
    private String newMessage;
    @ColumnInfo(name = "new_message_count")
    @SerializedName("new_message_count")
    private int newMessageCount;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public int getNewMessageCount() {
        return newMessageCount;
    }

    public void setNewMessageCount(int newMessageCount) {
        this.newMessageCount = newMessageCount;
    }
}
