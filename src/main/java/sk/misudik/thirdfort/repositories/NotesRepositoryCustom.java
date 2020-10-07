package sk.misudik.thirdfort.repositories;

import sk.misudik.thirdfort.entities.Note;

import java.util.List;

interface NotesRepositoryCustom {
    Note createNote(Note note);

    Note updateNote(Note note, long id);

    Note archiveNote(Note note, long id);

    Note unarchiveNote(Note note, long id);

    Note deleteNote(long id);

    List<Note> getArchived();

    List<Note> getUnarchived();
}
