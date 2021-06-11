export class Email {
  contactId: number;
  subject: string;
  message: string;

  constructor(contactId: number, subject: string, message: string) {
    this.contactId = contactId;
    this.subject = subject;
    this.message = message;
  }
}
