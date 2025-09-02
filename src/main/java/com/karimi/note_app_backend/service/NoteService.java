package com.karimi.note_app_backend.service;

import java.util.List;

import com.karimi.note_app_backend.entity.Note;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNotById(Long id);
    Note updateNote(Long id, Note note);
    Note saveNote(Note note);
    Note deleteNote(Long id);
    
    
}
