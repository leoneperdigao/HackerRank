package nl.yacht.doccollaborator;

import java.awt.*;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import nl.yacht.doccollaborator.poc.PostIt;
import nl.yacht.doccollaborator.poc.PostItActions;
import nl.yacht.doccollaborator.poc.SalesProfessional;
import nl.yacht.doccollaborator.poc.WhiteboardImpl;

@SpringBootApplication
public class DocCollaboratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocCollaboratorApplication.class, args);

		// TESTING
		WhiteboardImpl whiteboard = new WhiteboardImpl();
		SalesProfessional pro1 = new SalesProfessional(whiteboard);
		SalesProfessional pro2 = new SalesProfessional(whiteboard);
		SalesProfessional pro3 = new SalesProfessional(whiteboard);
		SalesProfessional pro4 = new SalesProfessional(whiteboard);
		PostIt postIt1 = createPostIt();
		PostIt postIt2 = createPostIt();
		whiteboard.addProfessional(pro1);
		whiteboard.addProfessional(pro2);
		whiteboard.addProfessional(pro3);
		whiteboard.addProfessional(pro4);
		pro1.addPostIt(postIt1);
		pro1.updatePostIt(postIt1, PostItActions.ADD);
		System.out.println(pro2.getPostItList());
		pro3.addPostIt(postIt2);
		pro3.updatePostIt(postIt2, PostItActions.ADD);
		System.out.println(pro1.getPostItList());
	}

	public static PostIt createPostIt() {
		Random random = new Random();
		PostIt postIt = new PostIt();
		postIt.setId(random.nextInt(100));
		postIt.setNote("This is a random number: " + random.nextInt(500));
		postIt.setLocation(new Point(random.nextInt(25), random.nextInt(25)));
		return postIt;
	}

}
