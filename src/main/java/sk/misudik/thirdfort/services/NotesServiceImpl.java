package sk.misudik.thirdfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.repositories.NotesRepository;

import java.util.List;

@Component
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

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
