package nl.yacht.doccollaborator.poc;

import java.awt.Point;

public class SalesProfessional extends Professional {

    public SalesProfessional(Whiteboard whiteboard) {
        super(whiteboard);
    }

    @Override
    public void addPostIt(PostIt postIt) {
       this.getWhiteboard().updateBoard(postIt, PostItActions.ADD, this);
    }

    @Override
    public void removePostIT(long id) {
    	this.getWhiteboard().updateBoard(new PostIt(id), PostItActions.REMOVE, this);
    }

    @Override
    public void movePostIt(long id, Point location) {
    	this.getWhiteboard().updateBoard(new PostIt(id, null, location), PostItActions.MOVE, this);
    }
    
    @Override
	public void updatePostIt(PostIt postIt, PostItActions action) {
    	this.getWhiteboard().updateBoard(postIt, action, null);
	}

	@Override
    public void refreshBoard(PostIt postIt, PostItActions action) {
		this.getWhiteboard().updateBoard(postIt, action, null);
    }
}
