package team.lum.model.newsapi;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class DateSerializer extends StdSerializer<Long> {

    private SimpleDateFormat simpleDateFormat;

    public DateSerializer() {
        super((Class) null);
        this.simpleDateFormat = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        this.simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    protected DateSerializer(Class<Long> vc) {
        super(vc);
        this.simpleDateFormat = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        this.simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(simpleDateFormat.format(new Date(value)));
    }
}
