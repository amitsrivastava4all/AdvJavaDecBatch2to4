import java.util.TreeSet;
class Song {//implements Comparable<Song>{
	private String name;
	private String albumName;
	private double price;
	Song(String name, String albumName, double price){
		this.name = name ;
		this.albumName = albumName;
		this.price = price;
	}
//	public int compareTo(Song object){
//		return this.name.compareTo(object.name);
//	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString(){
		return "Name "+name+" Album "+albumName +" Price "+price+"\n";
	}
	
}
public class Demo2 {

	public static void main(String[] args) {
		TreeSet<Song> songs = new TreeSet<>((a,b)->((Double)a.getPrice()).compareTo(b.getPrice()));
		songs.add(new Song("it's my life","Mr Albon",2000));
		songs.add(new Song("bang bang","bang bang",1000));
		songs.add(new Song("it's my life","Mr Albon",2000));
		songs.add(new Song("bang bang","bang bang",1000));
		System.out.println(songs);
		/*TreeSet<String> songs = new TreeSet<>();
		songs.add("It's My Life");
		songs.add("Bang Bang");
		songs.add("It's My Life");
		System.out.println(songs);
		*/

	}

}
