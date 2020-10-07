package sk.misudik.thirdfort.services;

import sk.misudik.thirdfort.entities.Note;

import java.util.List;

public interface NotesService {
    Note createNote(Note note);

    Note updateNote(Note note);

    Note archiveNote(long id);

    Note unarchiveNote(long id);

    void deleteNote(long id);

    List<Note> getArchived();

    List<Note> getUnarchived();

    Note find(long id);

}
