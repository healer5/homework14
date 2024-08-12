package com.example.homework14.dao;

import com.example.homework14.model.Note;
import java.util.List;
import java.util.Optional;

public interface NoteDao {
    List<Note> listAll();
    Optional<Note> getById(long id);
    Note add(Note note);
    void update(Note note);
    void deleteById(long id);
}
