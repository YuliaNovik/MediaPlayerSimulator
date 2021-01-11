package novikovy;

import java.util.ArrayList;


public class MediaList {
	//Create an arrayList to hold the objects
	private static ArrayList <MediaItem> _mediaList = new ArrayList <MediaItem>();


	//Create the constructor and add the objects to the ArrayList
	MediaList (){
		Movie movie1 = new Movie("The Blind Side","2009", "File:Image/blind.jpg" );
		Movie movie2 = new Movie("What Dreams May Come","1998", "File:Image/dreams.jpg");
		Movie movie3 = new Movie("The Secret","2006", "File:Image/secret.jpg");
		Song song1 = new Song("You Are The Reason - Cover by Alexandra Porat","2018", "File:Image/reason.jpg");
		Song song2 = new Song("Sleeping at Last - Light","2017", "File:Image/Sleeping.jpg");
		Song song3 = new Song("Michael Buble - Let Me Go Home", "2018", "File:Image/home.jpg");

		_mediaList.add(movie1);
		_mediaList.add(movie2);
		_mediaList.add(movie3);
		_mediaList.add(song1);
		_mediaList.add(song2);
		_mediaList.add(song3);
	}

	//Created lookup method to get the objects

	public static MediaItem lookup(int index){
		return _mediaList.get(index);

	}

}
