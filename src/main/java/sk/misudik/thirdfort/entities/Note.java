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
}
