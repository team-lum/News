package team.lum.model.newsapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DateDeserializer extends StdDeserializer<Long> {

    private List<SimpleDateFormat> simpleDateFormatList;

    public DateDeserializer() {
        super((Class) null);
        this.simpleDateFormatList = Arrays.asList( new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("HH:mm:ss yyyy-MM-dd"));

    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
        this.simpleDateFormatList = Arrays.asList( new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("HH:mm:ss yyyy-MM-dd"));
    }

    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) {

        for (SimpleDateFormat f : this.simpleDateFormatList) {
            try {
                return f.parse(p.getText()).getTime();
            } catch (Exception e) {

            }
        }
        return null;
    }
}
