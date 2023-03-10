package com.realworld.config;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonCustomizations {
    @Bean
    public Module realWorldModules(){
        return new RealWorldModules();
    }

    public static class RealWorldModules extends SimpleModule{
        public RealWorldModules(){
            addSerializer(DateTime.class,new DateTimeSerializer());
        }
    }

    public static class DateTimeSerializer extends StdSerializer<DateTime>{
        protected DateTimeSerializer(){
            super(DateTime.class);
        }

        @Override
        public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if(dateTime==null){
                jsonGenerator.writeNull();;
            }else {
                jsonGenerator.writeString(dateTime.toString());
            }
        }
    }
}
