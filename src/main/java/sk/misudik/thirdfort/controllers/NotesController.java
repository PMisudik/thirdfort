package sk.misudik.thirdfort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.misudik.thirdfort.entities.Note;
import sk.misudik.thirdfort.services.NotesService;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<?> updateNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesService.updateNote(note, id));
    }

    @PutMapping("/notes/archive/{id}")
    public ResponseEntity<?> archiveNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesService.archiveNote(note, id));
    }

    @PutMapping("/notes/unarchive/{id}")
    public ResponseEntity<?> unarchiveNote(@RequestBody Note note, @PathVariable long id) {
        return ResponseEntity.ok(notesService.unarchiveNote(note, id));
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        return ResponseEntity.ok(notesService.deleteNote(id));
    }

    @GetMapping("/notes/archived")
    public ResponseEntity<?> getArchived() {
        return ResponseEntity.ok(notesService.getArchived());
    }

    @GetMapping("/notes/unarchived")
    public ResponseEntity<?> getUnarchived() {
        return ResponseEntity.ok(notesService.getUnarchived());
    }
}
