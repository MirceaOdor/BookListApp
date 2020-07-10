BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Books " (
	"Index"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"Title"	String NOT NULL,
	"Author"	String NOT NULL,
	"Genre"	String,
	"Year"	String,
	"Favorite"	INTEGER
);
INSERT INTO "Books " VALUES (1,'In Search of Lost Time','Marcel Proust','Modernist',1913,0);
INSERT INTO "Books " VALUES (2,'Ulysses','James Joyce','Modernist',1922,0);
INSERT INTO "Books " VALUES (3,'Don Quixote','Miguel de Cervantes','Novel','1605-1612',0);
INSERT INTO "Books " VALUES (4,'The Great Gatsby','F. Scott Fitzgerald','Tragedy',1925,0);
INSERT INTO "Books " VALUES (5,'One Hundred Years of Solitude','Gabriel García Márquez','Magic Realism',1967,0);
INSERT INTO "Books " VALUES (6,'Moby Dick','Herman Melville','Novel',1851,0);
INSERT INTO "Books " VALUES (7,'War and Peace','Leo Tolstoy','Historical Novel',1869,0);
INSERT INTO "Books " VALUES (8,'Lolita','Vladimir Nabokov','Novel',1955,'false');
INSERT INTO "Books " VALUES (9,'Hamlet','William Shakespeare','Tragedy','somewhere between 1599-1601',0);
INSERT INTO "Books " VALUES (10,'The Catcher in the Rye','J. D. Salinger','Realistic',1951,0);
COMMIT;
