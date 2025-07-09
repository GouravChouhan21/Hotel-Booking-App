# Hotel Booking Application

## Project Overview
This project is a full-stack hotel booking application. It consists of a Java Spring Boot backend and a React frontend. The application allows users to browse rooms, make bookings, manage profiles, and for admins to manage rooms and bookings.

## Features
- User registration and login with JWT authentication
- Browse available rooms with search and pagination
- Book rooms and view booking details
- Admin panel to add, edit, and manage rooms and bookings
- AWS S3 integration for image storage
- Secure backend with Spring Security and JWT
- Responsive React frontend with clean UI

## Project Structure
- `Marriott_Hotel_Backend/`: Java Spring Boot backend source code
- `marriott-hotel-react/`: React frontend source code
- `application.properties.example`: Example backend config file 

## Setup and Running
1. Backend:
   - Configure your environment variables for database and AWS keys.
   - Use `application.properties.example` as a template.
   - Build and run with Maven.
2. Frontend:
   - Install dependencies with `npm install`.
   - Run the React app with `npm start`.

## Screenshots

### Login Page
![image](https://github.com/user-attachments/assets/b05c6512-83bb-455b-8a6d-9123e2321fef)

### Home Page
![image](https://github.com/user-attachments/assets/cd1fc07f-2e46-4f8b-ba54-6a6d02ab7566)

### Admin Dashboard
![image](https://github.com/user-attachments/assets/7257865d-82f5-4210-89a3-c92092ec4670)
![image](https://github.com/user-attachments/assets/b33373bf-15b7-4fe3-b7ca-3cb4d7b75af7)
![image](https://github.com/user-attachments/assets/13b6dd16-c8e0-4f75-8c16-d8678f187fbb)
![image](https://github.com/user-attachments/assets/cedd14ba-55aa-4ffe-b864-cb513532c701)
(add new room page by admin)
### Rooms Page
![image](https://github.com/user-attachments/assets/fb9022bc-9edc-4454-8970-d9e47b2b653d)

### Bookings page
![image](https://github.com/user-attachments/assets/f09967ba-ce8b-47c4-b60e-f612ca65da2c)
### User Profile
![image](https://github.com/user-attachments/assets/7ba85ad9-1bf0-45c1-8d24-b1bbd44e91e7)


## Security Notes
- Do NOT commit sensitive data like tokens, passwords, or keys.
- Use environment variables or external config files for secrets.
- The `application.properties` file is excluded from git; use the example file for reference.

## Contribution
Feel free to fork and submit pull requests. Please follow coding standards and test your changes.

## License
This project is licensed under the MIT License.

---

*This README was generated to provide a comprehensive overview and usage guide for this Hotel Booking Application.*
