package helpers;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomUtils {

  private static final Faker faker = new Faker();
  private static final Random random;

  static {
    random = new Random();
  }

  public static <T> T getRandomElement(Collection<T> elementList) {
    // receive another list for keep initial list order
    List<T> randomList = new ArrayList<>(elementList);
    // perform shuffle of list and just take first one element
    // because it will be not the first one from initial list
    Collections.shuffle(randomList);
    return randomList.get(0);
  }

  public static Integer getRandomNumber(int bound) {
    return random.nextInt(bound);
  }

  public static String getRandomNumberWithFixedLength(int length) {
    return String.valueOf(
        length < 1
            ? 0
            : random.nextInt((9 * (int) Math.pow(10, length - 1)) - 1)
                + (int) Math.pow(10, length - 1));
  }

  public static String getRandomFullName() {
    return String.format("%s %s", faker.name().firstName(), faker.name().lastName());
  }

  public static String getRandomFirstName() {
    return faker.name().firstName();
  }

  public static String getRandomLastName() {
    return faker.name().lastName();
  }

  public static String getRandomEmail() {
    return faker.internet().emailAddress();
  }

  public static String getRandomCity() {
    return faker.address().city();
  }

  public static String getStreetAddress() {
    return faker.address().streetAddress();
  }
}
