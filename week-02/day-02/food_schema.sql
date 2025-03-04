# A SCHEMA FOR OUR FOOD DATABASE
-- one user can have many recipes
-- one recipe can have many ingredients
-- one ingredient can go in many recipes
-- one recipe can go in many categories
-- one category can have many recipes
-- one recipe can have many ratings
-- one user can have one bio

-- user ONE TO ONE bio
-- user ONE TO MANY recipe
-- recipe ONE TO MANY rating
-- recipe MANY TO MANY ingredient
-- recipe MANY TO MANY category

# creating our overall database
-- backticks optional but helpful for readability
CREATE SCHEMA `food`;

# creating our tables
CREATE TABLE `food`.`ingredient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingredient_name` VARCHAR(32) NOT NULL,
  `ingredient_type` VARCHAR(32) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ingredient_name_UNIQUE` (`ingredient_name` ASC) VISIBLE);
  
CREATE TABLE `food`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) VISIBLE);

-- without backticks
CREATE TABLE food.bio (
	id INT NOT NULL AUTO_INCREMENT,
    cook_description VARCHAR(1000) NULL,
    PRIMARY KEY (id));
    
CREATE TABLE `food`.`cook` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) NOT NULL,
  `last_name` VARCHAR(32) NOT NULL,
  `bio` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `bio_UNIQUE` (`bio` ASC) VISIBLE,
  CONSTRAINT `cook_bio1`
    FOREIGN KEY (`bio`)
    REFERENCES `food`.`bio` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);
  
-- to drop a table -- CAREFUL!!!
-- DROP TABLE ingredient;
  
-- creating records in our ingredient table
-- you can do it this way, following the order of the columns as they were created
-- INSERT INTO ingredient VALUES(3, 'test', 'test type');

# CREATING ACTUAL RECORDS IN OUR DATABASE
INSERT INTO ingredient(ingredient_name, ingredient_type) VALUES('Ground Beef', 'Meat');
INSERT INTO ingredient(ingredient_name, ingredient_type) VALUES('Cayenne Pepper', 'Spice'),
															   ('Swiss Chard', 'Vegetable'),
															   ('Green Onions', 'Vegetable');
                                                               
INSERT INTO category(category_name) VALUES('Entree'), ('Appetizer'), ('Dessert'), ('Beverage'), ('Snack'), ('Soup'), ('Salad');

-- single or double quotes are fine for strings
INSERT INTO bio(cook_description) VALUES("This is Dave, he cooks with an old Hedley Bennett apron, his Japanese Santoku, and an old restaurant towel in hand.");

INSERT INTO cook(first_name, last_name, bio) VALUES('Dave', 'Lazaro', 1);

-- some select statements
SELECT * FROM ingredient;
SELECT * FROM ingredient WHERE id > 3;
SELECT * FROM ingredient WHERE ingredient_type LIKE 'V%'; -- wildcard for 0-any # of characters
SELECT * FROM ingredient WHERE ingredient_type LIKE 'Mea_'; -- wildcard for 1 and only 1 character
SELECT * FROM ingredient LIMIT 2;
SELECT ingredient_name AS Ingredient, ingredient_type AS Type FROM ingredient;
SELECT ingredient_type AS 'Type', COUNT(ingredient_type) AS '# Ingredients' FROM ingredient GROUP BY ingredient_type ORDER BY COUNT(ingredient_type) DESC;

SELECT * FROM category;
SELECT * FROM bio;
SELECT * FROM cook;
SELECT * FROM cook JOIN bio ON cook.bio = bio.id;


  
  
  
  
  
  