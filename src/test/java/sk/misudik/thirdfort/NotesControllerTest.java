package sk.misudik.thirdfort;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.repositories.NotesRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class NotesControllerTest {

	@Autowired
	private NotesRepository notesRepository;

    void contextLoads() {
    }

    @Test
	public void createNote()  {
		assertNotNull(notesRepository.createNote(new Note("test")));
	}

	@Test
	public void updateNote() {
		var note = notesRepository.createNote(new Note("test"));
		note.setText("test updated");
		var newNote = notesRepository.updateNote(note, note.getId());
		assertEquals(newNote.getText(), "test updated");
	}

	@Test
	public void archiveNote() {
		var note = notesRepository.createNote(new Note("test"));
		note.setArchived(true);
		var newNote = notesRepository.updateNote(note, note.getId());
		assertTrue(newNote.isArchived());
	}

	@Test
	public void unarchiveNote() {
		var note = notesRepository.createNote(new Note("test"));
		note.setArchived(false);
		var newNote = notesRepository.updateNote(note, note.getId());
		assertTrue(newNote.isArchived());
	}

	@Test
	public void deleteNote() {
		var note = notesRepository.createNote(new Note("test"));
		assertNotNull(notesRepository.deleteNote(note.getId()));
	}

	@Test
	public void getArchived() {
		notesRepository.createNote(new Note("test1", true));
		notesRepository.createNote(new Note("test2", true));
		notesRepository.createNote(new Note("test3", false));
		assertEquals(notesRepository.getArchived().size(), 2);
	}

	@Test
	public void getUnarchived() {
		notesRepository.createNote(new Note("test1", true));
		notesRepository.createNote(new Note("test2", true));
		notesRepository.createNote(new Note("test3", false));
		assertEquals(notesRepository.getUnarchived().size(), 1);
	}

}
