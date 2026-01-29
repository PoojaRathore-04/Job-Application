# Job Application & Interview Tracker System

## 📌 Project Overview
The **Job Application & Interview Tracker System** is a **console-based Java application** designed to manage job candidates, job openings, and their application status throughout the hiring process.  
The project follows **Object-Oriented Programming (OOP) principles**, uses **collections**, **enums**, and **file handling** to ensure clean architecture and data persistence.

This system helps track applications from **APPLIED** status to **HIRED**, while enforcing real-world business rules such as experience validation and valid status transitions.

---

## 🚀 Features

### Core Features
- Add and manage candidates
- Add and manage job openings
- Apply for jobs with validation
- Track application status
- Enforce valid application status flow
- Prevent duplicate job applications
- Automatically reject candidates with insufficient experience
- View applications by status
- View complete application history of a candidate

### Technical Features
- Uses **OOP concepts** (Encapsulation, Abstraction)
- Uses **HashMap** and **ArrayList**
- **Enum** for application status
- **Custom exception handling**
- **File I/O** for saving and loading data
- Input validation for user data

### Bonus Features (Optional)
- Search and sort applications
- Export hired candidates list
- Unit testing
- UML / flow diagram

---

## ▶️ How to Run the Project

1. Clone or download the project
2. Open the project in any Java IDE (IntelliJ / Eclipse / VS Code)
3. Navigate to the `main` package
4. Run the `JobTrackerApp.java` file
5. Follow the console menu options

### Requirements
- Java JDK 8 or above
- Basic command-line knowledge

---

## 📂 Folder Structure

JobTrackerSystem/
│
├── model/
│ ├── Candidate.java
│ ├── Job.java
│ ├── Application.java
│ └── ApplicationStatus.java
│
├── service/
│ ├── CandidateService.java
│ ├── JobService.java
│ └── ApplicationService.java
│
├── util/
│ ├── FileUtil.java
│
└── main/


---

## ⚠️ Assumptions & Limitations

### Assumptions
- Each candidate and job has a unique ID
- One candidate cannot apply for the same job more than once
- Application status must follow a valid transition flow
- Data is stored locally using file handling

### Limitations
- Console-based application (no GUI)
- Single-user system
- No database integration (file-based storage only)
- No authentication or role management

---

## 🧠 Learning Outcomes
- Strong understanding of Java OOP concepts
- Hands-on experience with collections and enums
- Practical implementation of business rules
- File handling and exception management
- Clean code structure and modular design
