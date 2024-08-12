package com.example.homework14.dao;
import com.example.homework14.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryNoteDao implements NoteDao {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes);
    }

    @Override
    public Optional<Note> getById(long id) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst();
    }

    @Override
    public Note add(Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }

    @Override
    public void update(Note note) {
        getById(note.getId()).ifPresent(existingNote -> {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        });
    }

    @Override
    public void deleteById(long id) {
        getById(id).ifPresent(notes::remove);
    }
}

