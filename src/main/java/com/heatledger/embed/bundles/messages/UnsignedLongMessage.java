package com.heatledger.embed.bundles.messages;

import java.nio.ByteBuffer;

import org.json.simple.JSONObject;

public class UnsignedLongMessage extends LongIdMessage {
    public long value;

    @Override
    public void read(ByteBuffer buffer) {
        super.read(buffer);
        value = buffer.getLong();
    }

    @Override
    public void write(ByteBuffer buffer) {
        super.write(buffer);
        buffer.putLong(value);
    }

    @Override
    public void read(JSONObject json) {
        super.read(json);
        value = Long.parseUnsignedLong((String) json.get("value"));
    }

    @Override
    public void write(JSONObject json) {
        super.write(json);
        json.put("value", Long.toUnsignedString(value));
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof LongMessage && ((LongMessage)obj).value == value;
    }
}
