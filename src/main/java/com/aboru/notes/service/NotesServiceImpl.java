package com.aboru.notes.service;

import com.aboru.notes.domain.Note;
import com.aboru.notes.domain.NoteRepository;
import com.aboru.notes.model.NoteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class
NotesServiceImpl implements NotesService {

    @Autowired
    private NoteRepository notesRepository;

    @Override
    public NoteBean createNote(final NoteBean noteBean) {
        Note record = new Note(noteBean.getBody());
        record = this.notesRepository.save(record);

        noteBean.setId(record.getId());

        return noteBean;
    }

    @Override
    public NoteBean getNote(final Long id) {
        Note record = this.notesRepository.getOne(id);
        return new NoteBean(record.getId(), record.getBody());
    }

    @Override
    public List<NoteBean> searchNotes(final String query) {
        return this.notesRepository.findByBodyContaining(query)
                .stream()
                .sorted(Comparator.comparingLong(Note::getId))
                .map(note -> new NoteBean(note.getId(), note.getBody()))
                .collect(Collectors.toList());
    }

}
