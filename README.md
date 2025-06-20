# 🗳️ Java Voting System
A comprehensive console-based voting system implemented in Java that simulates a complete election process with candidate management, voter registration, authentication, and result display.

## 📋 Table of Contents
- Features
- System Requirements
- Installation
- Usage
- System Architecture
- Screenshots
- Technical Features
- Future Enhancements
- Support

## ✨ Features

### 🏛️ Administrative Functions
- ➕ Add multiple candidates to the election
- 👥 Register voters with unique IDs and passwords
- 📊 View formatted tables of candidates and voters
- 🔍 Real-time duplicate checking for voter IDs and candidate names

### 🔐 Security & Authentication
- 🛡️ Secure voter authentication with ID and password
- 🚫 Prevention of duplicate voting
- ✅ Input validation and error handling

### 🗳️ Voting Process
- 🎯 Interactive voting interface
- 📝 Vote validation against registered candidates
- 📈 Real-time vote counting

### 📊 Results & Analytics
- 🏆 Automatic winner determination
- 📉 Vote percentage calculations
- 📋 Voter turnout statistics
- 🤝 Tie detection and reporting
- 📋 Professional table formatting with borders

## 🖥️ System Requirements
- **Java Version**: Java 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512 MB RAM
- **Storage**: 10 MB free space

## 🚀 Installation

### Option 1: Clone Repository
```bash
git clone https://github.com/yourusername/java-voting-system.git
cd java-voting-system
```

### Option 2: Download ZIP

* Click the "Code" button above
* Select "Download ZIP"
* Extract the files to your desired location

### Compilation & Execution

```bash
# Compile the Java file
javac VotingSystem.java

# Run the application
java VotingSystem
```

## 📖 Usage

### 1. Starting the Application

Run the program and you'll see the main menu:

```
=============================================================
                    VOTING SYSTEM MENU
=============================================================
1. Manage Candidates
2. Manage Voters  
3. Start Voting
4. Display Results
5. Exit
=============================================================
```

### 2. Managing Candidates

* Select option 1 to manage candidates
* Add candidates by entering their names
* View all registered candidates in a formatted table

### 3. Managing Voters

* Select option 2 to manage voters
* Register voters with:

  * Full name
  * Unique voter ID
  * Secure password
* View all registered voters and their voting status

### 4. Voting Process

* Select option 3 to start voting
* Voters authenticate with their ID and password
* Select candidates from the available list
* System prevents duplicate voting

### 5. View Results

* Select option 4 to display election results
* See vote counts, percentages, and winner
* View voter turnout statistics

## 🏗️ System Architecture

### Class Structure

```
VotingSystem.java  # Single file containing all classes and logic
```

### Key Components

#### 🧑‍💼 Candidate Class

```java
String name;       // Candidate's name
int votes;         // Vote count
// Methods: getName(), getVotes(), addVote()
```

#### 👤 Voter Class

```java
String name;       // Voter's full name
String voterID;    // Unique identifier
String password;   // Authentication credential
boolean hasVoted;  // Voting status flag
```

#### 🎛️ VotingSystem Class

```java
List<Candidate> candidates;  // Candidate storage
List<Voter> voters;          // Voter storage
Scanner scanner;             // Input handler
// Main system logic and UI
```

## 📸 Screenshots

### Main Menu

```
=============================================================
                    VOTING SYSTEM MENU
=============================================================
1. Manage Candidates
2. Manage Voters
3. Start Voting
4. Display Results
5. Exit
=============================================================
```

### Candidates Table

```
|-------|--------------------------------|------------------|
| S.No  | Candidate Name                 | Votes            |
|-------|--------------------------------|------------------|
| 1     | John Doe                       | 5                |
| 2     | Jane Smith                     | 3                |
| 3     | Mike Johnson                   | 2                |
|-------|--------------------------------|------------------|
```

### Election Results

```
|-------|--------------------------------|------------|-------------------------|
| Rank  | Candidate Name                 | Votes      | Percentage              |
|-------|--------------------------------|------------|-------------------------|
| 1     | John Doe                       | 5          | 50.00%                  |
| 2     | Jane Smith                     | 3          | 30.00%                  |
| 3     | Mike Johnson                   | 2          | 20.00%                  |
|-------|--------------------------------|------------|-------------------------|
```

## 🔧 Technical Features

### Data Validation

* ✅ Duplicate candidate name prevention
* ✅ Unique voter ID enforcement
* ✅ Password requirement validation
* ✅ Numeric input validation

### Error Handling

* 🛡️ Invalid menu selection handling
* 🔒 Authentication failure management
* 📝 Input format validation
* 🚫 Duplicate voting prevention

### User Experience

* 📱 Intuitive menu navigation
* 📊 Professional table formatting
* 🎨 Visual separators and borders
* 💬 Clear success/error messages
* ⏸️ "Press Enter to continue" prompts

## 📋 Future Enhancements

* 🗄️ Database integration (MySQL/PostgreSQL)
* 🌐 Web-based interface
* 📊 Advanced analytics and reporting
* 🔐 Enhanced security with encryption
* 📱 Mobile application
* 🌍 Multi-language support
* 📧 Email notifications
* 📈 Real-time vote tracking
* 🏛️ Multi-election support
* 📋 Voter registration approval workflow

## 📞 Support

If you encounter any issues or have questions:

* 📋 Check the Issues page
* 🆕 Create a new issue if your problem isn't listed
* 📧 **Email:** swarup8125@gmail.com  
* 🔗 **GitHub:** [Chennuru Swarup](https://github.com/swarup79997/)

```
```
