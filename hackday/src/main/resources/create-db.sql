CREATE table CUBICLE (
	location VARCHAR(7) PRIMARY KEY
);

CREATE table EMPLOYEE (
alias CHAR(4) PRIMARY KEY,
firstName VARCHAR(225),
lastName VARCHAR(225),
cubicle VARCHAR(7) FOREIGN KEY REFERENCES CUBICLE(location),
title VARCHAR(225),
phoneNumber VARCHAR(20),
supervisorAlias CHAR(4)
);