package novikovy;
//Create subclass Movie that extends MediaItem super class
public class Movie extends MediaItem{
	//Create constructor
	public Movie (String title, String productionYear, String imagePath){
		super (title, productionYear, imagePath);
	}
	//Override abstract class playMedia to "present" movie
	@Override
	public String playMedia() {

		return "Now presenting movie "+ getTitle() ;


	}

}
