## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: Ruslan_Kashapau@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 1. Labels text
 2. Header text
 3. User cannot select more toppings than specified in pizza type
 4. User cannot type character, negative or fractional values into “quantity” input
 5. The max value that user can type into “quantity” input
 6. User cannot edit “cost” textbox
 7. “Cost” textbox displayed correct value
 8. The maximum value “cost” textbox can display
 9. Max number of characters for “name” input
 10. “name” input support other languages
 11.  “name” input support special symbols
 12. Max number of characters for “email” input
 13. “email” input support other languages
 14.  “email” input support special symbols
 15. Email format validation on “email” input
 16. Max number of characters for “phone” input
 17. Phone format validation on “phone” input
 18. User can’t type + into “phone” input
 19. User can’t type non numerical symbols into “phone” input
 20. User can check only one payment method
 21. “Reset” button will reset form to its default state
 22. “Order” button will show dialog window
 23. Dialog window can fully display text
 24. Dialog window has “close” button
 25. User cannot interact with form until he close dialog window
 26. Happy path:
     1. dialog window contains “Thank you for your order!” text on one line, “Total:” with total cost on second line and selected pizza type on third line
     2. Form is reset to default state
 27. Unhappy path:
     1. dialog window contains error messages describing what user forgot to specify or typed incorrectly. 
     2. Form is not reset to default state

