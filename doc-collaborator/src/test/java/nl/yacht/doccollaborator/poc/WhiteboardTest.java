package nl.yacht.doccollaborator.poc;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class WhiteboardTest {

    @Test
    public void testProfessionalHasAccessToWhiteboard() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professional = new SalesProfessional(whiteboard);

        assertNotNull(professional.getWhiteboard());
    }

    @Test
    public void testWhiteboardHasNoProfessionalsOnInit() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();

        assertNotNull(whiteboard.getProfessionalList());
        assertTrue(whiteboard.getProfessionalList().isEmpty());
    }

    @Test
    public void testProfessionalIsCorrectlyAddedToWhiteboard() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professional = new SalesProfessional(whiteboard);

        whiteboard.addProfessional(professional);

        assertNotNull(whiteboard.getProfessionalList());
        assertEquals(professional, whiteboard.getProfessionalList().get(0));
    }

    @Test
    public void testProfessionalCanAddNoteAndIsNotDuplicated() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professional = new SalesProfessional(whiteboard);
        final PostIt postIt = this.createRandomPostIt();
        final int totalPosts = 1;

        whiteboard.addProfessional(professional);
        professional.addPostIt(postIt);
        professional.updatePostIt(postIt, PostItActions.ADD);

        assertNotNull(professional.getPostItList());
        assertEquals(totalPosts, professional.getPostItList().size());
    }

    @Test
    public void testSecondProfessionalGetsNotesFromFirstProfessional() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professionalOne = new SalesProfessional(whiteboard);
        final SalesProfessional professionalTwo = new SalesProfessional(whiteboard);
        final PostIt postIt = this.createRandomPostIt();
        final int totalPosts = 1;

        whiteboard.addProfessional(professionalOne);
        whiteboard.addProfessional(professionalTwo);
        professionalOne.addPostIt(postIt);
        professionalOne.updatePostIt(postIt, PostItActions.ADD);

        assertNotNull(professionalOne.getPostItList());
        assertNotNull(professionalTwo.getPostItList());
        assertEquals(totalPosts, professionalOne.getPostItList().size());
        assertEquals(totalPosts, professionalTwo.getPostItList().size());
        assertEquals(postIt.getId(), professionalTwo.getPostItList().get(0).getId());
    }

    @Test
    public void testPostRemovalIsReflectedOnAllProfessionals() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professionalOne = new SalesProfessional(whiteboard);
        final SalesProfessional professionalTwo = new SalesProfessional(whiteboard);
        final PostIt postIt = this.createRandomPostIt();
        final int totalPosts = 0;

        whiteboard.addProfessional(professionalOne);
        whiteboard.addProfessional(professionalTwo);
        professionalOne.addPostIt(postIt);
        professionalOne.updatePostIt(postIt, PostItActions.ADD);

        professionalTwo.removePostIT(postIt.getId());
        professionalTwo.updatePostIt(postIt, PostItActions.REMOVE);

        assertNotNull(professionalOne.getPostItList());
        assertNotNull(professionalTwo.getPostItList());
        assertEquals(totalPosts, professionalOne.getPostItList().size());
        assertEquals(totalPosts, professionalTwo.getPostItList().size());
    }

    @Test
    public void testPostRemovalIsTheCorrect() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professionalOne = new SalesProfessional(whiteboard);
        final SalesProfessional professionalTwo = new SalesProfessional(whiteboard);
        final PostIt postItOne = this.createRandomPostIt();
        final PostIt postItTwo = this.createRandomPostIt();
        final int totalPosts = 1;

        whiteboard.addProfessional(professionalOne);
        whiteboard.addProfessional(professionalTwo);

        professionalOne.addPostIt(postItOne);
        professionalOne.updatePostIt(postItOne, PostItActions.ADD);
        professionalTwo.addPostIt(postItTwo);
        professionalTwo.updatePostIt(postItTwo, PostItActions.ADD);

        professionalTwo.removePostIT(postItOne.getId());
        professionalTwo.updatePostIt(postItOne, PostItActions.REMOVE);

        assertNotNull(professionalOne.getPostItList());
        assertEquals(totalPosts, professionalOne.getPostItList().size());
        assertEquals(postItTwo.getId(), professionalOne.getPostItList().get(0).getId());
    }

    @Test
    public void testPostMoveIsOnCorrectPost() {
        final WhiteboardImpl whiteboard = new WhiteboardImpl();
        final SalesProfessional professionalOne = new SalesProfessional(whiteboard);
        final SalesProfessional professionalTwo = new SalesProfessional(whiteboard);
        final PostIt postItOne = this.createRandomPostIt();
        final PostIt postItTwo = this.createRandomPostIt();
        final Point newLocation = new Point(25, 25);

        whiteboard.addProfessional(professionalOne);
        whiteboard.addProfessional(professionalTwo);

        professionalOne.addPostIt(postItOne);
        professionalOne.updatePostIt(postItOne, PostItActions.ADD);
        professionalTwo.addPostIt(postItTwo);
        professionalTwo.updatePostIt(postItTwo, PostItActions.ADD);

        professionalTwo.movePostIt(postItOne.getId(), newLocation);
        professionalTwo.updatePostIt(postItOne, PostItActions.MOVE);

        assertNotNull(professionalTwo.getPostItList());
        assertEquals(postItTwo, professionalTwo.getPostItList().get(1));
        assertEquals(newLocation.x, professionalOne.getPostItList().get(0).getLocation().x);
        assertEquals(newLocation.y, professionalOne.getPostItList().get(0).getLocation().y);
    }

    private PostIt createRandomPostIt() {
        Random random = new Random();
        PostIt postIt = new PostIt();
        postIt.setId(random.nextInt(100000));
        postIt.setNote("Post it note with a numeric value of: " + random.nextInt(500));
        postIt.setLocation(new Point(random.nextInt(25), random.nextInt(25)));
        return postIt;
    }
}
