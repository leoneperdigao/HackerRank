package nl.yacht.doccollaborator.poc;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Professional {
	
	private List<PostIt> postItList = new ArrayList<>();
	private Whiteboard whiteboard;

    public Professional(Whiteboard whiteboard) {
    	this.whiteboard = whiteboard;
    }

    public Whiteboard getWhiteboard() {
        return whiteboard;
    }

    public List<PostIt> getPostItList() {
        return this.postItList;
    }
    
    public void updatePostIt(PostIt postIt, PostItActions action) {}

    public abstract void addPostIt(PostIt postIt);

    public abstract void removePostIT(long id);

    public abstract void movePostIt(long id, Point location);

    public abstract void refreshBoard(PostIt postIt, PostItActions action);
}
