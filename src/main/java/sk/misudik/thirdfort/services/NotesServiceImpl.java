package sk.misudik.thirdfort.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.repositories.NotesRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Note createNote(Note note) {
        return notesRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return notesRepository.save(note);
    }

    @Override
    public Note archiveNote(long id) {
        var note = notesRepository.findById(id).orElseThrow();
        note.setArchived(true);
        return notesRepository.save(note);
    }

    @Override
    public Note unarchiveNote(long id) {
        var note = notesRepository.findById(id).orElseThrow();
        note.setArchived(false);
        return notesRepository.save(note);
    }

    @Override
    public void deleteNote(long id) {
        notesRepository.deleteById(id);
    }

    @Override
    public List<Note> getArchived() {
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(Note.class);
        var stud = cq.from(Note.class);
        cq.where(cb.isTrue(stud.get("isArchived")));
        var select = cq.select(stud);
        return entityManager.createQuery(select).getResultList();
    }

    @Override
    public List<Note> getUnarchived() {
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(Note.class);
        var stud = cq.from(Note.class);
        cq.where(cb.isFalse(stud.get("isArchived")));
        var select = cq.select(stud);
        return entityManager.createQuery(select).getResultList();
    }

    @Override
    public Note find(long id) {
        return notesRepository.findById(id).orElse(null);
    }

}
