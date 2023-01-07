import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("_");

            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = Arrays.stream(methods)
                    .filter(f -> f.getName().equalsIgnoreCase(command))
                    .findFirst().orElse(null);

            assert method != null;
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));
        }
    }
}