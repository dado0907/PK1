//package pixelPic;
//
///**
// * The lens shows the original image although some transformations 
// * have already been applied on the image.
// * The lens can be positioned on any part of the image and can
// * vary in size.
// * 
// * @author fuchs
// *
// */
//public class Lens 
//{
//	
//	private int cx;
//	private int cy;
//	private int radiusX;
//	private int radiusY;
//	private boolean isActive;
//	
//	public Lens(int cx, int cy, int radiusX, int radiusY) 
//	{
//		this.cx = cx;
//		this.cy = cy;
//		this.radiusX = radiusX;
//		this.radiusY = radiusY;
//		
//		//TODO:
//		//Add more methods as you see fit.
//	}
//	
//	
//	public void setCX(int cx)
//	{
//		this.cx = cx;
//	}
//	
//	public void setCY(int cy)
//	{
//		this.cy = cy;
//	}
//	
//	public boolean isActive()
//	{
//		return this.isActive;
//	}
//	
//	public void activate()
//	{
//		this.isActive = true;
//	}
//	
//	public void deactivate()
//	{
//		this.isActive = false;
//	}
//	
//	public void setRadiusX(int radiusX)
//	{
//		this.radiusX = radiusX;
//	}
//
//	public void setRadiusY(int radiusY)
//	{
//		this.radiusY = radiusY;
//	}
//
//}
package pixelPic;

public class Lens {
    private int cx;
    private int cy;
    private int radiusX;
    private int radiusY;
    private boolean isActive;

    public Lens(int cx, int cy, int radiusX, int radiusY) {
        this.cx = cx;
        this.cy = cy;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public int getCX() {
        return cx;
    }

    public void setCX(int cx) {
        this.cx = cx;
    }

    public int getCY() {
        return cy;
    }

    public void setCY(int cy) {
        this.cy = cy;
    }

    public int getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }
}
