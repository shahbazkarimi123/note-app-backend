package com.karimi.note_app_backend.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.karimi.note_app_backend.entity.Note;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

    private EntityManager entityManager;
    public NoteRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Note> getAllNotes() {
        TypedQuery<Note> query = entityManager.createQuery(
            "SELECT n FROM Note n",
            Note.class
        );

        return query.getResultList();
    }

    @Override
    public Note getNotById(Long id) {
        return entityManager.find(Note.class,id);
    }

    @Override
    public void updateNote(Note note) {
        entityManager.merge(note);
    }

    @Override
    public void saveNote(Note note) {
        entityManager.persist(note);
    }

    @Override
    public void deleteNote(Note note) {
        entityManager.remove(note);
    }

   
}
