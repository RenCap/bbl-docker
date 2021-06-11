import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from './contact.model';
import { Email } from './email.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) {
  }

  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${environment.API_URL}/contacts`);
  }

  sendEmail(email: Email): Observable<any> {
    return this.http.post(`${environment.API_URL}/emails`, email);
  }
}
