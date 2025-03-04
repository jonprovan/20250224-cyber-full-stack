# this is a comment
-- this is also a comment

# SQL BASICS
-- SQL = Structured Query Language
-- we're using the MySQL variant/flavor
-- but all SQL databases are relational, meaning there are tables (rows/columns)
-- they can be related via foreign keys

# KEY TYPES
-- primary key = a unique identifier for a record/row in a specific table
-- foreign key = a column (or columns) in a table containing primary keys from another table to relate them
-- composite key = a primary key comprised of more than one column
-- candidate key = something present in the data that COULD BE a primary key, whether it is or not

# RELATIONSHIPS BETWEEN TABLES
-- okay to to have totally unrelated tables
-- one-to-one = one record in this table relates to one and only one record in the other table (lookup)
	-- foreign key can be in either table
-- one-to-many/many-to-one = one record in this table relates to many records in the other table (or vice versa)
	-- foreign key is on the many side, referring to the one side
    -- otherwise, we'd either have a list of keys in a field or a potentially infinite # of required columns
-- many-to-many = many records in this table relate to many records in the other table
	-- foreign keys are not direct in this case
    -- we need a junction/join table to bring them together
    -- this j/j table ONLY contains the foreign keys leading to both tables
    -- AND, this j/j table has a composite key -- both columns ARE the primary key together

# ACID -- principles for how databases should operate per transaction
-- Atomicity = either the entire transaction happens, or it doesn't -- no partial execution
-- Consistency = actions execute the same way each time, without creating errors/issues
-- Isolation = only affects what you're trying to affect, and other transactions don't affect mine (or vice versa)
-- Durability = successful transactions are permanently stored in the database, even if it fails afterward

















