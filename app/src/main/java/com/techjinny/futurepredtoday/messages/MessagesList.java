package com.techjinny.futurepredtoday.messages;

import androidx.dynamicanimation.animation.SpringAnimation;

public class MessagesList {

    private String name, mobile, lastMessage,profilePic;

    private String unseenMesssage;


    public MessagesList(String name, String mobile, String lastMessage,String profilePic, String unseenMesssage) {
        this.name = name;
        this.mobile = mobile;
        this.lastMessage = lastMessage;
        this.profilePic = profilePic;
        this.unseenMesssage = unseenMesssage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getUnseenMesssage() {
        return unseenMesssage;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setUnseenMesssage(String unseenMesssage) {
        this.unseenMesssage = unseenMesssage;
    }
}
