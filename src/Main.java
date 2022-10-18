import java.util.*;

public class Main {
    private static final ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album=new Album("Romantic","Arijit Singh");

        album.addSong("Kesariya",5.6);
        album.addSong("Humdard",3.6);
        album.addSong("Hawayein",6.7);
        album.addSong("Ve Maahi",3.6);
        albums.add(album);

         album=new Album("Hip Hop","Divine");

        album.addSong("Mere Gully Mein",5.6);
        album.addSong("Kohinoor",3.6);
        album.addSong("Junoon",6.7);
        album.addSong("Walking Miracle",5.6);
        albums.add(album);

        LinkedList<Song> PlayList_1=new LinkedList<>();
        albums.get(0).addToList("Kesariya",PlayList_1);
        albums.get(0).addToList("Humdard",PlayList_1);
        albums.get(1).addToList("Mere Gully Mein",PlayList_1);
        albums.get(1).addToList("Walking Miracle",PlayList_1);
        play(PlayList_1);


    }
    private static void play(LinkedList<Song> PlayList){
        Scanner sc=new Scanner(System.in);
        boolean quit= false;
        boolean forward=true;
        ListIterator<Song> listIterator=PlayList.listIterator();

        if(PlayList.size()==0){
            System.out.println("this PlayList has no songs");
        }else{
            printMenu();
            System.out.println("Now Playing"+listIterator.next().toString());

        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();

            switch (action){

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now Playing"+listIterator.next().toString());
                    }else{
                        System.out.println("No song available,reached to the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing"+listIterator.previous().toString());
                    }else {
                        System.out.println("We are in the first song");
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing"+listIterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(PlayList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(PlayList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now palying"+listIterator.next().toString());

                        }else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing"+listIterator.previous().toString());
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("PlayList complete");
                    quit=true;
                    break;
            }
        }


    }
    private static void printMenu(){

        System.out.println("     ---------------    Available options  --------------------   \n press");
        System.out.println("""
                1- to play next Song
                2- to play previous song
                3- to replay the current song
                4- list of all songs
                5- print all the available options
                6- delete current song
                7- to quit
                """);
    }
    private static void printList(LinkedList<Song>PlayList){
        Iterator<Song> iterator=PlayList.iterator();
        System.out.println("-----------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");
    }
}
