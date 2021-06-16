import { Component, OnInit } from '@angular/core';
import { ContactService } from '../shared/contact.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Contact } from '../shared/contact.model';
import { defaultObj } from '../shared/utils';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent implements OnInit {
  contacts: Contact[];
  selectedContact: FormGroup;

  constructor(private contactService: ContactService, private fm: FormBuilder, private snackBar: MatSnackBar) {
    this.selectedContact = fm.group({
      id: [],
      firstName: [],
      lastName: [],
      email: [''],
      subject: ['', Validators.required],
      message: ['', Validators.required]
    });
    this.contacts = [];
  }

  ngOnInit() {
    this.contactService.getContacts().subscribe(value => this.contacts = value);
  }

  display(contact: Contact) {
    this.selectedContact.patchValue(contact);
  }

  send() {
    if (this.selectedContact.valid) {
      this.contactService.sendEmail({
        contactId: this.getSelectedContactAttr('id').value,
        subject: this.getSelectedContactAttr('subject').value,
        message: this.getSelectedContactAttr('message').value
      })
        .subscribe(
          () => {
            this.cancel();
            this.showMessage('Email envoyé');
          },
          () => this.showMessage('Une erreur est survenue'));
    } else {
      this.showMessage('Veuillez remplir les champs requis');
    }
  }

  cancel() {
    this.selectedContact.reset();
  }

  getSelectedContactAttr = (attr: string) => defaultObj(this.selectedContact.get(attr));

  private showMessage(message: string) {
    this.snackBar.open(message, '', {
      duration: 2000
    });
  }
}
