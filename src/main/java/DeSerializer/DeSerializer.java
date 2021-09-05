package DeSerializer;

import Model.UserInput;

    import com.fasterxml.jackson.databind.ObjectMapper;
import Model.UserInput;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

    public class DeSerializer implements Deserializer<UserInput> {
        @Override public void close() {
        }
        @Override public void configure(Map<String, ?> arg0, boolean arg1) {
        }
        @Override
        public UserInput deserialize(String arg0, byte[] arg1) {
            ObjectMapper mapper = new ObjectMapper();
            UserInput user = null;
            try {
                user = mapper.readValue(arg1, UserInput.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }



