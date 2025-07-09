# Setting Environment Variables for Marriott Hotel Backend

This project uses environment variables to keep sensitive data secure. Please set the following environment variables before running the application:

## Required Environment Variables

- DB_USERNAME: Your database username (e.g., root)
- DB_PASSWORD: Your database password
- AWS_S3_SECRET_KEY: Your AWS S3 secret key
- AWS_S3_ACCESS_KEY: Your AWS S3 access key

## How to Set Environment Variables

### On Windows (Command Prompt)

```cmd
set DB_USERNAME=your_db_username
set DB_PASSWORD=your_db_password
set AWS_S3_SECRET_KEY=your_aws_s3_secret_key
set AWS_S3_ACCESS_KEY=your_aws_s3_access_key
```

### On Windows (PowerShell)

```powershell
$env:DB_USERNAME="your_db_username"
$env:DB_PASSWORD="your_db_password"
$env:AWS_S3_SECRET_KEY="your_aws_s3_secret_key"
$env:AWS_S3_ACCESS_KEY="your_aws_s3_access_key"
```

### On Linux/macOS (bash)

```bash
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password
export AWS_S3_SECRET_KEY=your_aws_s3_secret_key
export AWS_S3_ACCESS_KEY=your_aws_s3_access_key
```
