package com.karimi.note_app_backend.repository;

import java.util.List;

import com.karimi.note_app_backend.entity.Note;

public interface  NoteRepository {
    List<Note> getAllNotes();
    Note getNotById(Long id);
    void updateNote(Note note);
    void saveNote(Note note);
    void deleteNote(Note note);
    
    
}
