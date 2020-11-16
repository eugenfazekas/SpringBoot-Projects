package rc.noteit.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rc.noteit.Mapper;
import rc.noteit.api.viewmodel.NoteViewModel;
import rc.noteit.db.NoteRepository;
import rc.noteit.db.NotebookRepository;
import rc.noteit.model.Note;
import rc.noteit.model.Notebook;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController {
    private NoteRepository noteRepository;
    private NotebookRepository notebookRepository;
    private Mapper mapper;

    public NoteController(NoteRepository noteRepository, NotebookRepository notebookRepository, Mapper mapper) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<Object> all() {
        List<Note> notes = this.noteRepository.findAll();

        // map from entity to view model
        List<Object> notesViewModel = notes.stream()
                .map(new Function<Note, Object>() {
					public Object apply(Note note) {
						return NoteController.this.mapper.convertToNoteViewModel(note);
					}
				})
                .collect(Collectors.toList());

        return notesViewModel;
    }

    @GetMapping("/byId/{id}")
    public NoteViewModel byId(@PathVariable String id) {
        Note note = this.noteRepository.findById(UUID.fromString(id)).orElse(null);

        if (note == null) {
            throw new EntityNotFoundException();
        }

        NoteViewModel noteViewModel = this.mapper.convertToNoteViewModel(note);

        return noteViewModel;
    }

    @GetMapping("/byNotebook/{notebookId}")
    public List<Object> byNotebook(@PathVariable String notebookId) {
        List<Note> notes = new ArrayList<Note>();

        Optional<Notebook> notebook = this.notebookRepository.findById(UUID.fromString(notebookId));
        if (notebook.isPresent()) {
            notes = this.noteRepository.findAllByNotebook(notebook.get());
        }

        // map to note view model
        List<Object> notesViewModel = notes.stream()
                .map(new Function<Note, Object>() {
					public Object apply(Note note) {
						return NoteController.this.mapper.convertToNoteViewModel(note);
					}
				})
                .collect(Collectors.toList());

        return notesViewModel;
    }

    @PostMapping
    public Note save(@RequestBody NoteViewModel noteCreateViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Note noteEntity = this.mapper.convertToNoteEntity(noteCreateViewModel);

        // save note instance to db
        this.noteRepository.save(noteEntity);

        return noteEntity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.noteRepository.deleteById(UUID.fromString(id));
    }
}
