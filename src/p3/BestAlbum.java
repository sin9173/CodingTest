package p3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class BestAlbum {

    public static HashMap<String, Integer> gen_map = new HashMap<>();
    public static HashMap<String, PriorityQueue<Album>> album_map = new HashMap<>();

    public static PriorityQueue<Genre> total_queue = new PriorityQueue<>((o1, o2) -> o2.play.compareTo(o1.play));

    public static int size;

    public static void main(String[] args) {
        String[] genres = {"classic", "classic", "classic", "pop", "pop", "pop"};
        int[] plays = {500, 500, 500, 400, 500, 600};

        store(genres, plays);
        int[] result = output();

        System.out.print("result : ");
        printArray(result);
    }

    public static int[] output() {
        int[] result = new int[size];
        int point = 0;
        int count;

        while(point<size && total_queue.size()>0) {
            Genre genre = total_queue.poll();
            PriorityQueue<Album> album = album_map.get(genre.genre);
            count = 0;
            System.out.println("album : " + album);
            while(count<2 && album.size()>0 && point<size) {
                result[point] = album.poll().id;
                printArray(result);
                System.out.println("album : " + album);
                point++;
                count++;
            }
        }

        return result;
    }

    public static void store(String[] genres, int[] plays) {
        for(int i=0 ; i<genres.length ; i++) {
            if(gen_map.get(genres[i])==null) {
                gen_map.put(genres[i], plays[i]);
                album_map.put(genres[i], new PriorityQueue<>((o1, o2) -> o2.compare(o1.play, o1.id)));
            } else {
                gen_map.put(genres[i], (gen_map.get(genres[i]) + plays[i]));
            }
            album_map.get(genres[i]).offer(new Album(i, plays[i]));
            System.out.println("gen : " + gen_map);
            System.out.println("album : " + album_map);
        }

        Iterator<String> iterator = gen_map.keySet().iterator();


        String g;
        int as;
        while(iterator.hasNext()) {
            g = iterator.next();
            total_queue.offer(new Genre(g, gen_map.get(g)));
            as = album_map.get(g).size();
            size += (as>2)?2:as;
        }

        System.out.println(total_queue);
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }

}

class Album {
    public int id;
    public Integer play;

    public Album(int id, int play) {
        this.id = id;
        this.play = play;
    }

    public int compare(Integer i, Integer id) {
        if(this.play.equals(i)) {
            return id.compareTo(this.id);
        } else {
            return play.compareTo(i);
        }
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", play=" + play +
                '}';
    }
}

class Genre {
    public String genre;
    public Integer play;

    public Genre(String genre, Integer play) {
        this.genre = genre;
        this.play = play;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre='" + genre + '\'' +
                ", play=" + play +
                '}';
    }
}
