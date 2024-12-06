# STUDENTDATAMGMTSYS-SDMS-
# Student Data Management System

This is a Java-based **Student Data Management System** that allows users to manage student details, including personal information, semester grades, arrears summary, and photos. The application supports dynamic arrear management and stores all data in a database.

## Features

- Add, update, and delete student records.
- Store and display student photos.
- Manage semester grades and calculate arrears dynamically.
- View total arrears for each student.
- Simple and intuitive user interface.

## Installation

### Prerequisites
- **Java Runtime Environment (JRE)** version 8 or higher.
- **MySQL** for database management.

### Steps
1. Clone the repository or download the executable JAR file from the [Releases](https://github.com/your_username/your_repository/releases) section.
2. Set up the database:
   - Import the provided SQL script to create the `studentdatamgmt` table.
   - Update the database connection details in the `DataBaseConnection.java` file.
3. Run the application:
   - Open a terminal or command prompt.
   - Navigate to the directory containing the JAR file.
   - Run the command:
     ```bash
     java -jar StudentDataManagement.jar
     ```

## Usage

1. Launch the application.
2. Enter student details including ID, name, age, contact number, semester grades, and arrears.
3. Use the "Insert" button to save the data to the database.
4. Use the "Search by ID" field to fetch and display student details and arrears summary.
5. The "Reset" button clears all fields for new data entry.

## APPLICATION LINK

https://1drv.ms/u/c/fbd1bc063a96ca04/EQhLyBPHAJNLlu4q4JPOs9MBkBI8ei4MMIAckA4mEqr5ZQ?e=upAmFZ

## Database Structure

### Table: `studentdatamgmt`
| Column         | Type        | Description                     |
|----------------|-------------|---------------------------------|
| `Id`           | VARCHAR(12) | Student ID (Primary Key).       |
| `FirstName`    | VARCHAR(50) | First name of the student.      |
| `Surname`      | VARCHAR(50) | Last name of the student.       |
| `Age`          | INT         | Student age.                   |
| `DateOfBirth`  | DATE        | Student's date of birth.        |
| `ContactNo`    | VARCHAR(10) | Contact number.                 |
| `YearOfJoin`   | INT         | Year of joining.                |
| `Department`   | VARCHAR(2)  | Department code (e.g., CS, IT). |
| `Class`        | VARCHAR(50) | Class name or year.             |
| `Photo`        | BLOB        | Student's photo.                |
| `TotArr`       | INT         | Total arrears count.            |

## Contributing

If you would like to contribute:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch-name`).
3. Commit your changes (`git commit -m "Description of changes"`).
4. Push the branch (`git push origin feature-branch-name`).
5. Create a Pull Request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or issues, feel free to reach out:
- **Email**: your_email@example.com
- **GitHub**: [PAVITHRA278](https://github.com/PAVITHRA278)

