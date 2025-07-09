# Setup and Upload Guide for Marriott Hotel Project

## 1. Setting Up Environment Variables

Before running the backend, set the required environment variables as described in `Marriott_Hotel_Backend/README_ENVIRONMENT_VARIABLES.md`.

Example for Windows Command Prompt:
```
set DB_USERNAME=your_db_username
set DB_PASSWORD=your_db_password
set AWS_S3_SECRET_KEY=your_aws_s3_secret_key
set AWS_S3_ACCESS_KEY=your_aws_s3_access_key
```

Example for Linux/macOS bash:
```
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password
export AWS_S3_SECRET_KEY=your_aws_s3_secret_key
export AWS_S3_ACCESS_KEY=your_aws_s3_access_key
```

## 2. Running the Backend

- Navigate to the `Marriott_Hotel_Backend` directory.
- Use Maven to build and run the project:
```
./mvnw spring-boot:run
```
or on Windows:
```
mvnw.cmd spring-boot:run
```

The backend will start on port 4040 as configured.

## 3. Running the Frontend

- Navigate to the `marriott-hotel-react` directory.
- Install dependencies if not done yet:
```
npm install
```
- Start the React development server:
```
npm start
```

The frontend will start on the default port (usually 3000).

## 4. Initializing Git Repository (if not already)

- In the root directory of your project (or each subproject), initialize git if not done:
```
git init
```

## 5. Adding Files and Committing

- Add all files except those excluded by `.gitignore`:
```
git add .
```
- Commit the changes:
```
git commit -m "Initial commit - project setup with secure environment variables"
```

## 6. Creating a GitHub Repository

- Go to GitHub and create a new repository.
- Follow the instructions to add the remote repository URL:
```
git remote add origin https://github.com/yourusername/your-repo-name.git
```

## 7. Pushing to GitHub

- Push your local commits to GitHub:
```
git push -u origin master
```

## Notes

- Make sure `application.properties` is excluded from git and not pushed.
- Use `application.properties.example` as a template for others to configure their environment.
- Keep your environment variables secure and do not share them publicly.

This guide will help you set up and upload your project safely to GitHub.
