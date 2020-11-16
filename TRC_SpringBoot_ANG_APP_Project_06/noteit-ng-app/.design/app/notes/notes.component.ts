import {ElementSelectionService} from './../element-selection.service';
import {ComponentInspectorService} from './../component-inspector.service';
import {Component, OnInit} from '@angular/core';
import {Notebook} from './model/notebook';
import {ApiService} from '../shared/api.service';
import {Note} from './model/note';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
     notebooks: Notebook[] = [];
     notes: Note[] = [];
     selectedNotebook: Notebook;
     searchText: string;

  constructor(public __elementSelectionService:ElementSelectionService, private __componentInspectorService:ComponentInspectorService,
private apiService: ApiService ) {this.__componentInspectorService.getComp(this);

  }

  ngOnInit(): void {
    this.getAllNotebooks();
    this.getAllNotes();
  }

  public getAllNotebooks() {
        this.apiService.getAllNotebooks().subscribe(
    res => {
    this.notebooks = res;
    },
    err => {
      alert('An error has occured');
     }
  );
}
createNotebook() {
  let newNotebook : Notebook = {
    name: 'New notebook',
    id: null,
    nbOfNotes: 0
   };

  this.apiService.postNotebook(newNotebook).subscribe(
  res => {
    newNotebook.id = res.id;
    this.notebooks.push(newNotebook);
  },
  err => {alert('An error has ocured while saving the notebook');
               }
         );
     }


  updateNotebook(updatedNotebook: Notebook) {
    this.apiService.postNotebook(updatedNotebook).subscribe(
      res => {

      },
      err => {alert('An error has occurred while saving the notebook'); }
    );
  }

  deleteNotebook(notebook: Notebook) {
    if (confirm('Are you sure you want to delete notebook?')){
      this.apiService.deleteNotebook(notebook.id).subscribe(
        res => {
          let indexOfNotebook = this.notebooks.indexOf(notebook);
          this.notebooks.splice(indexOfNotebook, 1 );
        },
        err => {
          alert('Could not delete notebook');
        }
      );
    }
  }

  getAllNotes(){
    this.apiService.getAllNotes().subscribe(
      res => {
        this.notes = res;
      },
      err => {alert('Error occurred while downloading the notes'); }
    );
  }

   deleteNote(note: Note){
    if (confirm('Are you sure you want to delete this note?')){
      this.apiService.deleteNote(note.id).subscribe(
        res => {
          let indexOfNote = this.notes.indexOf(note);
          this.notes.splice(indexOfNote, 1);
        },
        err => {alert('An error has occurred deleting the note'); }
      );
    }
  }

  createNote(notebookId1: string) {
    let newNote:Note = {
      id: null,
      title: 'New Note',
      text: 'Write some text in here',
      lastModifiedOn: null,
      notebookId: notebookId1
    };

    this.apiService.saveNote(newNote).subscribe(
      res => {
        newNote.id = res.id;
        this.notes.push(newNote);
      },
      err => {alert('An error occurred while saving the note'); }
    );
  }

  selectNotebook(notebook: Notebook) {
    this.selectedNotebook = notebook;
    this.apiService.getNotesByNotebook(notebook.id).subscribe(
      res => {
        this.notes = res;
      },
      err => {alert('An error has occurred while downloading the notes;')}
    );
  }

  updateNote(updatedNote: Note) {
    this.apiService.saveNote(updatedNote).subscribe(
      res => {
      },
      err => {alert('An error occurred while saving the note'); }
    );
  }

  selectAllNotes() {
    this.selectedNotebook = null;
    this.getAllNotes();
  }
}