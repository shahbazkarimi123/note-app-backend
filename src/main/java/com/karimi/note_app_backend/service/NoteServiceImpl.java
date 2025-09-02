package com.karimi.note_app_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karimi.note_app_backend.entity.Note;
import com.karimi.note_app_backend.repository.NoteRepository;

import jakarta.transaction.Transactional;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.getAllNotes();
    }

    @Override
    public Note getNotById(Long id) {
       return noteRepository.getNotById(id);
    }

    @Override
    @Transactional
    public Note updateNote(Long id, Note note) {
        Note theNote = noteRepository.getNotById(id);
        if(theNote == null){
            return null;
        }
        theNote.setTitle(note.getTitle());
        theNote.setContent(note.getContent());
        noteRepository.updateNote(theNote);
        return theNote;
    }

    @Override
    @Transactional
    public Note saveNote(Note note) {
        noteRepository.saveNote(note);
        return note;
    }

    @Override
    @Transactional
    public Note deleteNote(Long id) {
        Note theNote = noteRepository.getNotById(id);
        if(theNote == null){
            return null;
        }

        noteRepository.deleteNote(theNote);
        return theNote;
    }
    
}
