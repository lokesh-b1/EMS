package com.springboot.crud.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Column
		private String firstName;
		
		@Column
		private String lastName;
		
		@Column
		private String email;
		
		@Column
		private long phoneNumber;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		}

<<<<<<< HEAD
=======
		@Override
		public int hashCode() {
			return Objects.hash(email, firstName, id, lastName, phoneNumber);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
					&& Objects.equals(lastName, other.lastName) && phoneNumber == other.phoneNumber;
		}
		

		 

}

>>>>>>> Pandu
