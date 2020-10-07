package sk.misudik.thirdfort.controllers;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Creates a new note")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    @PutMapping("/notes/{id}")
    @ApiOperation(value = "Updates existing note")
    public ResponseEntity<?> updateNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.updateNote(note));
    }

    @PutMapping("/notes/archive/{id}")
    @ApiOperation(value = "Archives existing note")
    public ResponseEntity<?> archiveNote(@PathVariable long id) {
        return ResponseEntity.ok(notesService.archiveNote(id));
    }

    @PutMapping("/notes/unarchive/{id}")
    @ApiOperation(value = "Removes note from archive")
    public ResponseEntity<?> unarchiveNote(@PathVariable long id) {
        return ResponseEntity.ok(notesService.unarchiveNote(id));
    }

    @DeleteMapping("/notes/{id}")
    @ApiOperation(value = "Removes note")
    public ResponseEntity<?> deleteNote(@PathVariable long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/notes/archived")
    @ApiOperation(value = "Returns all archived notes")
    public ResponseEntity<?> getArchived() {
        return ResponseEntity.ok(notesService.getArchived());
    }

    @GetMapping("/notes/unarchived")
    @ApiOperation(value = "Returns all not archived notes")
    public ResponseEntity<?> getUnarchived() {
        return ResponseEntity.ok(notesService.getUnarchived());
    }
}
