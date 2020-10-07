package sk.misudik.thirdfort.services;

import sk.misudik.thirdfort.entities.Note;

import java.util.List;

public interface NotesService {
    abstract Note createNote(Note note);

    abstract Note updateNote(Note note, long id);

    abstract Note archiveNote(Note note, long id);

    abstract Note unarchiveNote(Note note, long id);

    abstract Note deleteNote(long id);

    abstract List<Note> getArchived();

    abstract List<Note> getUnarchived();
}
