DROP TABLE IF EXISTS EMPLOYEES;
CREATE TABLE EMPLOYEES(
    id INT AUTO_INCREMENT  PRIMARY KEY, 
    empCode VARCHAR(50) NOT NULL, 
    jobTitleName VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    emailId VARCHAR(50),
    phoneNumber VARCHAR(50),
	address1 VARCHAR(50),
	address2 VARCHAR(50),
	age VARCHAR(50),
	salary VARCHAR(50)
)