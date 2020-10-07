package sk.misudik.thirdfort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.repositories.NotesRepository;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesRepository.createNote(note));
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<?> updateNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesRepository.updateNote(note, id));
    }

    @PutMapping("/notes/archive/{id}")
    public ResponseEntity<?> archiveNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesRepository.archiveNote(note, id));
    }

    @PutMapping("/notes/unarchive/{id}")
    public ResponseEntity<?> unarchiveNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesRepository.unarchiveNote(note, id));
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        return ResponseEntity.ok(notesRepository.deleteNote(id));
    }

    @GetMapping("/notes/archived")
    public ResponseEntity<?> getArchived() {
        return ResponseEntity.ok(notesRepository.getArchived());
    }

    @GetMapping("/notes/unarchived")
    public ResponseEntity<?> getUnarchived() {
        return ResponseEntity.ok(notesRepository.getUnarchived());
    }
}
