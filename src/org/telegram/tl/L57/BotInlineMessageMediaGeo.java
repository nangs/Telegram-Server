package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class BotInlineMessageMediaGeo extends org.telegram.tl.TLBotInlineMessage {

    public static final int ID = 0x3a8fd8b8;

    public int flags;
    public org.telegram.tl.TLGeoPoint geo;
    public org.telegram.tl.TLReplyMarkup reply_markup;

    public BotInlineMessageMediaGeo() {
    }

    public BotInlineMessageMediaGeo(int flags, org.telegram.tl.TLGeoPoint geo, org.telegram.tl.TLReplyMarkup reply_markup) {
        this.flags = flags;
        this.geo = geo;
        this.reply_markup = reply_markup;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        geo = (org.telegram.tl.TLGeoPoint) buffer.readTLObject(APIContext.getInstance());
        if ((flags & (1 << 2)) != 0) {
            reply_markup = (org.telegram.tl.TLReplyMarkup) buffer.readTLObject(APIContext.getInstance());
        }
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(24);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
        if (reply_markup != null) {
            flags |= (1 << 2);
        }
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeTLObject(geo);
        if ((flags & (1 << 2)) != 0) {
            buff.writeTLObject(reply_markup);
        }
    }


    public int getConstructor() {
        return ID;
    }
}