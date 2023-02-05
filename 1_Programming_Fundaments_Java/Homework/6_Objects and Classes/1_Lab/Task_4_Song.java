import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_4_Song {
    private String typeList;
    private String name;
    private String time;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numSongs = Integer.parseInt(scan.nextLine());

        List<Task_4_Song> songs = new ArrayList<>();

        for (int i = 0; i < numSongs; i++) {
            String[] data = scan.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Task_4_Song song = new Task_4_Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scan.nextLine();

        if (typeList.equals("all")) {
            for (Task_4_Song song : songs ) {
                System.out.println(song.getName());
            }
        } else {
            for (Task_4_Song song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}