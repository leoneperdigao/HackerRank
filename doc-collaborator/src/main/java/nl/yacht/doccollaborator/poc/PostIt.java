package nl.yacht.doccollaborator.poc;

import java.awt.Point;

public class PostIt {

	private long id;
	private String note;
	private Point location;

	public PostIt() {
	}

	public PostIt(long id) {
		super();
		this.id = id;
	}

	public PostIt(long id, String note, Point location) {
		super();
		this.id = id;
		this.note = note;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
}
