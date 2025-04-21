
# Unit Converter Web Application

This is a simple Unit Converter web application developed using Spring Boot for the backend and Thymeleaf for the frontend. The application allows users to convert values between different units of length, weight, and temperature.

## Features

- Convert units of length (e.g., meter to kilometer, inch to foot)
- Convert units of weight (e.g., gram to kilogram, pound to ounce)
- Convert units of temperature (e.g., Celsius to Fahrenheit, Kelvin to Celsius)
- Tab-based navigation for selecting unit category (Length, Weight, Temperature)
- Form submission triggers real-time conversion and displays the result
- Clean and responsive UI using HTML and CSS

## Technology Stack

- Backend: Spring Boot
- Frontend: Thymeleaf, HTML, CSS
- Build Tool: Maven

## How to Run the Application

1. Clone the repository:
   ```
   git clone https://github.com/your-username/unit-converter.git
   ```
2. Navigate to the project directory:
   ```
   cd unit-converter
   ```
3. Build and run the application using Maven:
   ```
   mvn spring-boot:run
   ```
4. Open your browser and go to:
   ```
   http://localhost:8080/convert
   ```

## Project Structure

- Controller: Handles HTTP requests and manages data between view and service
- Service Layer: Contains logic for unit conversion
- Thymeleaf Templates: Frontend UI for unit input and result display

## Screenshots

![Screenshot 2025-04-22 000649](https://github.com/user-attachments/assets/4e4736d4-41ff-406e-8084-3f46d046631a)


## License

This project is open-source and available under the MIT License.
