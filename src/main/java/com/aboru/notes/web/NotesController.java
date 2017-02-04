package com.aboru.notes.web;

import com.aboru.notes.model.NoteBean;
import com.aboru.notes.service.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
public class NotesController {

    private final Logger logger = LoggerFactory.getLogger(NotesController.class);

    @Autowired
    private NotesService notesService;

    @RequestMapping(value = "/notes", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public final NoteBean createOne(@Validated @RequestBody NoteBean body) {
        logger.trace(MessageFormat.format("create note: {0}", body));
        return this.notesService.createNote(body);
    }

    @RequestMapping(value = "/notes/{id:[\\d]+}", method = RequestMethod.GET, produces = "application/json")
    public final NoteBean getOne(@PathVariable("id") Long id) {
        logger.trace(MessageFormat.format("getting note: {0}", id));
        return this.notesService.getNote(id);
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    public final List<NoteBean> getAll(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
        logger.trace(MessageFormat.format("getting all notes with search query: [{0}]", query));
        return this.notesService.searchNotes(query);
    }

}
