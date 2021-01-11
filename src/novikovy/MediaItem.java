package novikovy;

public abstract class MediaItem {
	//Declare field variables
	private String _title;
	private String  _productionYear;
	private String _imagePath;

	//Create a constructor
	protected MediaItem (String title, String productionYear, String imagePath){
		setTitle(title);
		setProductionYear(productionYear);
		setImagePath(imagePath);

		//Create setters and getters
	}
	public String getImagePath(){
		return _imagePath;
	}
	public String getTitle(){
		return _title;
	}
	public String getProductionYear (){
		return _productionYear;
	}
	public void setImagePath (String imagePath){
		_imagePath = imagePath;
	}
	public void setTitle (String title){
		_title = title;
	}
	public void setProductionYear (String productionYear){
		_productionYear = productionYear;
	}
	//Create the abstract class
	public abstract String playMedia ();
}
