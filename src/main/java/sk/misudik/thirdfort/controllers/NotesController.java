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
    public ResponseEntity<?> updateNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.updateNote(note));
    }

    @PutMapping("/notes/archive/{id}")
    public ResponseEntity<?> archiveNote(@PathVariable long id) {
        return ResponseEntity.ok(notesService.archiveNote(id));
    }

    @PutMapping("/notes/unarchive/{id}")
    public ResponseEntity<?> unarchiveNote(@PathVariable long id) {
        return ResponseEntity.ok(notesService.unarchiveNote(id));
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok().build();
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
