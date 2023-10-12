import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Person {
  personalIdentificationNumber: string;
  surName: string;
  firstNames: string;
  email: string;
  telephone: string;
  streetAddress: string;
  zipCode: string;
  postalDistrict: string;
  country: string;
}

@Component({
  selector: 'app-person',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  person: Person = {
    personalIdentificationNumber: '',
    surName: '',
    firstNames: '',
    email: '',
    telephone: '',
    streetAddress: '',
    zipCode: '',
    postalDistrict: '',
    country: ''
  };
  persons: Person[] = [];

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.loadPersons();
  }

  isZipCodeValid(): boolean {
    const zipCode = this.person.zipCode;
    const zipCodePattern = /^\d{5}$/;
    if (zipCode && zipCodePattern.test(zipCode)) {
      return true;
    } else {
      return false;
    }
  }

  isPersonalIdentificationNumberValid(): boolean {
    const personalIdentificationNumber = this.person.personalIdentificationNumber;
    const personalIdentificationNumberPattern = /^[0-9]{6}[+\-A][0-9]{3}[0-9A-Za-z]$/;
    if (personalIdentificationNumber && personalIdentificationNumberPattern.test(personalIdentificationNumber)) {
      return true;
    } else {
      return false;
    }
  }

  isEmailValid(): boolean {
    const email = this.person.email;
    // Yksinkertainen sähköpostiosoitteen tarkistus
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (email && emailPattern.test(email)) {
      return true;
    } else {
      return false;
    }  
  }

  loadPersons() {
    this.httpClient.get('http://localhost:8080/person')
      .subscribe(
        (response: any) => {
        this.persons = response;        
      });
  }

  addPerson() {
    this.httpClient.post('http://localhost:8080/person', this.person).subscribe(() => {
        // Updates list of persons
        this.person = {
          personalIdentificationNumber: '',
          surName: '',
          firstNames: '',          
          email: '',
          telephone: '',
          streetAddress: '',
          zipCode: '',
          postalDistrict: '',
          country: ''
        };
        
        this.loadPersons();
      });
  }
}