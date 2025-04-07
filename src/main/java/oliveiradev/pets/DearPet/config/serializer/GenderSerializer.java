package oliveiradev.pets.DearPet.config.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GenderSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String genero, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        String formatedGender = "Masculino".equals(genero) ? "M" : "F";
        gen.writeString(formatedGender);
    }
}