# Travel Booking System

A Java-based simulation of a simple **travel and booking management system**.  
It models airports, hotels, and reservations through an object-oriented design, allowing extension to more complex booking scenarios.

---

## Project Explanation
This project demonstrates **object-oriented programming principles** applied to travel and booking management.

### Core Components
- **Airport**  
  - Stores coordinates (`x`, `y`) with a 1:1000 meter ratio.  
  - Stores airport fees.  
  - Provides static method to compute distance (in km) between two airports.  

- **Room**  
  - Represents hotel rooms of type `King`, `Queen`, or `Double`.  
  - Stores availability and price (in cents).  
  - Includes utilities to:
    - Find an available room of a given type.
    - Change room availability (reserve/release).  
    - Calculate price based on room type.  

- **(Other classes such as Hotel/Reservation)**  
  - Manage hotels, reservations, and customer choices.  
  - Extend system functionality.

---

## Repository Structure
Travel-Booking-System/
┣ src/ 
┃ ┣ Airport.java
┃ ┣ Room.java
┃ ┗ ... other files
┣ LICENSE
┣ README.md 

---

## Features
- Object-oriented modeling of travel entities
- Distance calculation between airports
- Hotel room management:
  - Pricing by type
  - Reservation & availability tracking
- Extendable system for future booking/reservation logic

---

## Technologies
- Language: Java
- Paradigm: Object-Oriented Programming
- Tools: Any Java IDE (Eclipse, IntelliJ IDEA, VS Code)

---

## Author
- Developed by Nicolas Constantinou
- 2025

---

## Usage

### Compile/ Run:
```bash
javac src/*.java -d bin
java -cp bin hw2.Main
