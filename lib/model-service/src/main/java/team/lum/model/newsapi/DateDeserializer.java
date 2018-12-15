package team.lum.model.newsapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@Slf4j
public class DateDeserializer extends StdDeserializer<Long> {

    private SimpleDateFormat simpleDateFormat;

    public DateDeserializer() {
        super((Class) null);
        this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
        this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    }

    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) {
        try {
            return Long.parseLong(p.getText());
        } catch (Exception e) {

        }
        try {
            return simpleDateFormat.parse(p.getText()).getTime();
        } catch (Exception e) {
            log.error("Can`t parse date", e);
            return null;
        }
    }
}
