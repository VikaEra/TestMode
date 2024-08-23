package data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.util.Locale;

public class DataGenerator {
    private static final Faker Faker = new Faker(new Locale("en"));

    private DataGenerator() {
    }

    public static String getRandomLogin() {
        return Faker.name().username();
    }

    public static String getRandomPassword() {
        return Faker.internet().password();
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationDto getUser(String status) {
            return new RegistrationDto(getRandomLogin(), getRandomPassword(), status);
        }

        public static RegistrationDto getRegisteredUser(String status) {
            return ApiHelper.sendRequest(getUser(status));
        }
    }


    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String status;
    }
}