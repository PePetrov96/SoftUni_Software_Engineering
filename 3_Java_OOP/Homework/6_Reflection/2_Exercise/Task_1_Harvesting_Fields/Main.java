import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static Field[] fields = RichSoilLand.class.getDeclaredFields();
	static List<String> filtered = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		filter();

		String input;
		while (!"HARVEST".equals(input = reader.readLine())) {
			print(input);
		}

	}

	private static void print(String type) {
		if (type.equals("all")) {
			filtered.forEach(System.out::println);
		} else {
			filtered.stream()
					.filter(fields -> fields.startsWith(type))
					.forEach(System.out::println);
		}
	}
	private static void filter() {
		Arrays.stream(fields).forEach(field -> {
			switch (field.getModifiers()) {
				case Modifier.PUBLIC: filtered.add(String.format("public %s %s", field.getType().getSimpleName(), field.getName()));
					break;
				case Modifier.PRIVATE: filtered.add(String.format("private %s %s", field.getType().getSimpleName(), field.getName()));
					break;
				case Modifier.PROTECTED: filtered.add(String.format("protected %s %s", field.getType().getSimpleName(), field.getName()));
					break;
			}
		});
	}
}