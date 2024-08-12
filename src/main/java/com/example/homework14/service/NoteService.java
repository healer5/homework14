package com.example.homework14.service;

import com.example.homework14.dao.NoteDao;
import com.example.homework14.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> listAll() {
        return noteDao.listAll();
    }

    public Note add(Note note) {
        return noteDao.add(note);
    }

    public void deleteById(long id) {
        if (!noteDao.getById(id).isPresent()) {
            throw new RuntimeException("Note not found");
        }
        noteDao.deleteById(id);
    }

    public void update(Note note) {
        if (!noteDao.getById(note.getId()).isPresent()) {
            throw new RuntimeException("Note not found");
        }
        noteDao.update(note);
    }

    public Note getById(long id) {
        return noteDao.getById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
