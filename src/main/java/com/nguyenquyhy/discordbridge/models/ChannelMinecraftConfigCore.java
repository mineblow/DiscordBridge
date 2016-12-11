package com.nguyenquyhy.discordbridge.models;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Created by Hy on 12/11/2016.
 */
@ConfigSerializable
public class ChannelMinecraftConfigCore implements IConfigInheritable<ChannelMinecraftConfigCore> {
    void initializeDefault() {
        chatTemplate = "&7<%a> &f%s";
        attachment = new ChannelMinecraftAttachmentConfig();
        attachment.initializeDefault();
    }

    @Setting
    public String chatTemplate;
    @Setting
    public ChannelMinecraftAttachmentConfig attachment;

    @Override
    public void inherit(ChannelMinecraftConfigCore parent) {
        if (chatTemplate == null) chatTemplate = parent.chatTemplate;
        if (attachment == null) attachment = parent.attachment;
        else attachment.inherit(parent.attachment);
    }
}
