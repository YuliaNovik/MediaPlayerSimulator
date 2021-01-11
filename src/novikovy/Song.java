package novikovy;
//Create subclass Song that extends MediaItem super class
public class Song extends MediaItem{
	//Create constructor
	public Song (String title, String productionYear, String imagePath){
		super(title, productionYear, imagePath);
	}
	//Override abstract class playMedia to "play" song
	@Override
	public String playMedia() {

		return "Now playing song " + getTitle();
	}

}
