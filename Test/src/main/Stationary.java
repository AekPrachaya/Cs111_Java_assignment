package main;

public class Stationary {
	public static void main(String[] args) {
		Pen redPen = new Pen("red");
		replaceInk(redPen, "blue");
		System.out.println("Pen color:" + redPen.getInkColor());
	}

	public static void replaceInk(Pen pen, String color) {
		pen = new Pen();
		pen.setInkColor(color);
	}
}

class Pen {
	private String inkColor;

	public Pen(String color) {
		inkColor = color;
	}

	public void setInkColor(String color) {
		inkColor = color;
	}

	public Pen() {
		inkColor = "black";
	}

	public String getInkColor() {
		return inkColor;
	}
}