package sk.misudik.thirdfort.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private boolean isArchived;

    public Note(String text) {
        this.text = text;
    }

    public Note(String text, boolean isArchived) {
        this.text = text;
        this.isArchived = isArchived;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
}
