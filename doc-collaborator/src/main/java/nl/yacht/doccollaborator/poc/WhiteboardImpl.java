package nl.yacht.doccollaborator.poc;

import java.util.ArrayList;
import java.util.List;

public class WhiteboardImpl implements Whiteboard {

	private List<Professional> professionalList = new ArrayList<>();

	public void addProfessional(Professional professional) {
		this.getProfessionalList().add(professional);
	}

	@Override
	public List<Professional> getProfessionalList() {
		return this.professionalList;
	}

	@Override
	public void updateBoard(PostIt postIt, PostItActions action, Professional professional) {

		switch (action) {
		case ADD:
			addPostIt(professional, postIt);
			break;
		case REMOVE:
			removePostIt(professional, postIt);
			break;
		case MOVE:
			movePostIt(professional, postIt);
			break;
		default:
			break;
		}
	}

	private void addPostIt(Professional professional, PostIt postIt) {
		if (professional != null) {
			professional.getPostItList().add(postIt);
		} else {
			addPostItToAll(postIt);
		}
	}

	private void removePostIt(Professional professional, PostIt postIt) {
		if (professional == null) {
			removePostItFromAll(postIt);
		} else {
			professional.getPostItList().remove(postIt);
		}
	}

	private void movePostIt(Professional professional, PostIt postIt) {
		if (professional == null) {
			movePostItFromAll(postIt);
		} else {
			professional.getPostItList().stream()
			.filter(post -> post.getId() == postIt.getId())
			.forEach(post -> post.setLocation(postIt.getLocation()));
		}
	}

	private void addPostItToAll(PostIt postIt) {
		this.getProfessionalList().stream().forEach(pr -> {
			if (!pr.getPostItList().contains(postIt)) {
				pr.getPostItList().add(postIt);
			}
		});
	}

	private void removePostItFromAll(PostIt postIt) {
		this.getProfessionalList().stream().forEach(pr -> {
			if (pr.getPostItList().contains(postIt)) {
				pr.getPostItList().remove(postIt);
			}
		});
	}

	private void movePostItFromAll(PostIt postIt) {
		this.getProfessionalList()
				.stream()
				.forEach(pr -> pr.getPostItList().stream()
								.filter(post -> post.getId() == postIt.getId())
								.forEach(post -> post.setLocation(postIt.getLocation())));
	}
}
