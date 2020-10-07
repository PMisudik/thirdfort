package sk.misudik.thirdfort.repositories;

import org.springframework.http.ResponseEntity;
import sk.misudik.thirdfort.entities.Note;

import java.util.List;

public class NotesRepositoryImpl implements NotesRepositoryCustom {

    @Override
    public Note createNote(Note note) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Note updateNote(Note note, long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Note archiveNote(Note note, long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Note unarchiveNote(Note note, long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Note deleteNote(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Note> getArchived() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Note> getUnarchived() {
        throw new UnsupportedOperationException();
    }

}
