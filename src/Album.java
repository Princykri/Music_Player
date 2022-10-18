
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private  String artist;
    private final ArrayList<Song> songs;
    public Album(String name,String artist){
        this.name=name;
        this.artist=artist;
        this.songs=new ArrayList<Song>();
    }
    public void addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration));
            // return true;
        }else{
            System.out.println("already present in the album");
        }
    }

    public Song findSong(String title){
        for(Song checkSong:songs){
            if(checkSong.getTitle().equals(title)) return checkSong;
        }
        return null;
    }
    public  boolean addToList(int trackNumber, LinkedList<Song> PlayList){
        int index=trackNumber-1;
        if(index>0 && index <=this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
       // System.out.println("this album does not have song with trackNumber"+trackNumber);
        return false;
    }
    public  boolean addToList(String title,LinkedList<Song>PlayList){
        for(Song checkSong: this.songs){
            if(checkSong.getTitle().equals((title))){
                PlayList.add(checkSong);
                return true;
            }
        }

        return false;
    }
}
