package com.karimi.note_app_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karimi.note_app_backend.entity.Note;
import com.karimi.note_app_backend.service.NoteService;

@RestController
@RequestMapping(path="api/notes")
public class NoteRestController {
    @Autowired
    private NoteService noteService;

    @GetMapping(path="/all")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
        
    }

    @GetMapping(path="/id/{noteId}")
    public Note getNoteById(@PathVariable Long noteId){
        return noteService.getNotById(noteId);
    }
    
    @PutMapping(path="/id/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable Long noteId, @RequestBody Note note){
        Note updatedNote = noteService.updateNote(noteId, note);

        if (updatedNote == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedNote);
    }
    
    @DeleteMapping(path="/delete/{noteId}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long noteId){
        Note theNote = noteService.deleteNote(noteId);
        if(theNote == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(theNote);

    }

    @PostMapping(path="/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        try{
            Note theNote = noteService.saveNote(note);
            return ResponseEntity.status(HttpStatus.CREATED).body(theNote);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
