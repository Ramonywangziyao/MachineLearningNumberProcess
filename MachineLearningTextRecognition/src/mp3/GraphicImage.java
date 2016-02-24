package mp3;

public class GraphicImage {
	Pixel [][] pixelImage = new Pixel[28][28];
	private int label;
	public double map;
	
	public MapClass[] Probability = new MapClass[10]; //for testing
	
	public GraphicImage()
	{
		
	}
	
	public GraphicImage(Pixel[][] image, int label, int probability)
	{
		this.label = label;
		//this.probability = probability;
		this.pixelImage = image;
	}
	
	public Pixel[][] getPixelImage()
	{
		return pixelImage;
	}
	
	public void setPixelImage(Pixel[][] image)
	{
		this.pixelImage = image;
	}
	
	public int getLabel()
	{
		return this.label;
	}
	
	public void setLabel(int value)
	{
		this.label = value;
	}
/*
	@Override
	public int compareTo(GraphicImage o) {
		// TODO Auto-generated method stub
		 if(this.Probability[] < o.Probability[])
         {
             return -1;
         }
         else if(this.pro> arg0.pro)
         {
             return 1;
         }

         return 0;
	}
	*/
}
