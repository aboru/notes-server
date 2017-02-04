package com.aboru.notes.service;

import com.aboru.notes.model.NoteBean;

import java.util.List;

public interface NotesService {

    NoteBean createNote(final NoteBean noteBean);

    NoteBean getNote(final Long id);

    List<NoteBean> searchNotes(final String query);

}
