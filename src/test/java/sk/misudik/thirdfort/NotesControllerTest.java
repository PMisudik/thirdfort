package sk.misudik.thirdfort;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.repositories.NotesRepository;
import sk.misudik.thirdfort.services.NotesService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class NotesControllerTest {

	@Autowired
	private NotesService notesService;

    void contextLoads() {
    }

    @Test
	public void createNote()  {
		assertNotNull(notesService.createNote(new Note("test")));
	}

	@Test
	public void updateNote() {
		var note = notesService.createNote(new Note("test"));
		note.setText("test updated");
		var newNote = notesService.updateNote(note, note.getId());
		assertEquals(newNote.getText(), "test updated");
	}

	@Test
	public void archiveNote() {
		var note = notesService.createNote(new Note("test"));
		note.setArchived(true);
		var newNote = notesService.updateNote(note, note.getId());
		assertTrue(newNote.isArchived());
	}

	@Test
	public void unarchiveNote() {
		var note = notesService.createNote(new Note("test"));
		note.setArchived(false);
		var newNote = notesService.updateNote(note, note.getId());
		assertTrue(newNote.isArchived());
	}

	@Test
	public void deleteNote() {
		var note = notesService.createNote(new Note("test"));
		assertNotNull(notesService.deleteNote(note.getId()));
	}

	@Test
	public void getArchived() {
		notesService.createNote(new Note("test1", true));
		notesService.createNote(new Note("test2", true));
		notesService.createNote(new Note("test3", false));
		assertEquals(notesService.getArchived().size(), 2);
	}

	@Test
	public void getUnarchived() {
		notesService.createNote(new Note("test1", true));
		notesService.createNote(new Note("test2", true));
		notesService.createNote(new Note("test3", false));
		assertEquals(notesService.getUnarchived().size(), 1);
	}

}
