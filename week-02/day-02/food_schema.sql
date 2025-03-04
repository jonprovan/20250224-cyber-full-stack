# A SCHEMA FOR OUR FOOD DATABASE
-- one cook can have many recipes
-- one recipe can have many ingredients
-- one ingredient can go in many recipes
-- one recipe can go in many categories
-- one category can have many recipes
-- one recipe can have many ratings
-- one cook can have one bio

-- cook ONE TO ONE bio
-- cook ONE TO MANY recipe
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
    
CREATE TABLE `food`.`recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `recipe_name` VARCHAR(64) NOT NULL,
  `recipe_description` VARCHAR(500) NULL,
  `cook` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `recipe_cook1_idx` (`cook` ASC) VISIBLE,
  CONSTRAINT `recipe_cook1`
    FOREIGN KEY (`cook`)
    REFERENCES `food`.`cook` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `food`.`recipe_ingredient` (
  `recipe_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  `amount` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`recipe_id`, `ingredient_id`),
  INDEX `ingredient_id1_idx` (`ingredient_id` ASC) VISIBLE,
  CONSTRAINT `recipe_id1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `food`.`recipe` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ingredient_id1`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `food`.`ingredient` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `food`.`recipe_category` (
  `recipe_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`recipe_id`, `category_id`),
  INDEX `category_id1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `recipe_id2`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `food`.`recipe` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `category_id1`
    FOREIGN KEY (`category_id`)
    REFERENCES `food`.`category` (`id`)
    ON DELETE CASCADE
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
INSERT INTO bio(cook_description) VALUES("This is Dave, he cooks with an old Hedley Bennett apron, his Japanese Santoku, and an old restaurant towel in hand."),
										('This is Jon. He cannot cook and cannot learn. He is hopeless and shameless.');

INSERT INTO cook(first_name, last_name, bio) VALUES('Dave', 'Lazaro', 1), ('Jon', 'Provan', 2);

INSERT INTO recipe(recipe_name, recipe_description, cook) VALUES('Marinated Chicken', 'Drool-worthy chicken with flatbread on the side.', 1),
															    ('Tagliatelle alla Bolognese', 'Italian ragu-style with long pasta.', 1),
																('Cuban Sandwich', 'Cuban bread cradling pulled pork, sweet ham, mustard and pickles.', 1),
                                                                ('The Total Mess', 'A whole bunch of stuff, whatever is left in the fridge.', 2);
                                                                
INSERT INTO recipe_category(recipe_id, category_id) VALUES(1, 1), (2, 1), (3, 5), (4, 2);

INSERT INTO recipe_ingredient(recipe_id, ingredient_id, amount) VALUES(4, 1, 'Six pounds'), (4, 2, 'A shovelful'), (4, 3, 'One-tenth of a teaspoon'), (4, 4, 'As many as fit');

-- updating a record
-- this will change EVERY record where the 'where' clause is true, so this is a little unsafe
-- UPDATE cook SET id = 2 WHERE first_name = 'Dave';
-- better to do it via id
UPDATE cook SET id = 1 WHERE id = 2;

-- deleting a record
DELETE FROM recipe WHERE id = 1;

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
SELECT * FROM recipe;
SELECT * FROM cook JOIN recipe ON cook.id = recipe.cook;
SELECT * FROM recipe_category;
-- joins with multiple tables get complex!
SELECT recipe_name, recipe_description, category_name FROM recipe 
	JOIN recipe_category ON recipe.id = recipe_category.recipe_id
    JOIN category ON category.id = recipe_category.category_id;
    
SELECT * FROM recipe 
	JOIN recipe_ingredient ON recipe.id = recipe_ingredient.recipe_id
    JOIN ingredient ON ingredient.id = recipe_ingredient.ingredient_id;
    
# TRANSACTIONS
-- by default, MySQL is autocommitted
-- turn this off like this (this is SUPPOSED to work)
SET autocommit=0;
INSERT INTO category(category_name) VALUES('Sample');
-- roll back to before the last transaction began using this:
ROLLBACK;

-- not a great way to run a transaction in MySQL Workbench without a stored procedure if we want to use conditional logic
-- we can work around this with a stored procedure

-- a stored procedure is a method we can call to run a block of code, including conditional logic
-- e.g., insert a record, check something, then either commit it or roll back

-- inside, we have a transaction, and until we either commit or roll back the transaction, anything within it is temporary
-- but, we can package multiple statements together, then either commit them all or reverse them

-- changing the delimiter temporarily so we can include semi-colons in the procedure stored in the database
delimiter //
CREATE PROCEDURE sample_procedure (IN cat_name VARCHAR(32)) -- include parameters and returns here
	BEGIN
		DECLARE result_name VARCHAR(32);

		START TRANSACTION;
			INSERT INTO category(category_name) VALUES(cat_name);
			SET result_name = (SELECT category_name FROM category WHERE category_name = cat_name);
			IF result_name = 'Sample' THEN
				ROLLBACK;
			ELSE
				COMMIT;
			END IF;
	END //
delimiter ; -- changing the delimiter back

CALL sample_procedure('Sample');