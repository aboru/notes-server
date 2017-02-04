package com.aboru.notes.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.MessageFormat;

public class NoteBean {

    private Long id;

    @NotNull(message = "The note body is required to create a new note.")
    @Size(min = 1, max = 255, message = "The note body must be at least one and not more than 255 characters.")
    private String body;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public final String toString() {
        return MessageFormat.format("[id={0} body={1}]", this.id, this.body);
    }

    public NoteBean(final Long id, final String body) {
        this.id = id;
        this.body = body;
    }

    protected NoteBean()
    {}

}
