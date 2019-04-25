package nl.yacht.doccollaborator.poc;


import java.util.List;

public interface Whiteboard {

    List<Professional> getProfessionalList();
    void updateBoard(PostIt postIt, PostItActions action, Professional professional);
}
