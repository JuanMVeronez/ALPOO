DELIMITER //

CREATE PROCEDURE deleteAuthor(
    IN authorId INT,
    IN deleteCascade BOOLEAN
)
BEGIN
    SELECT COUNT(*) INTO @book_count FROM BooksAuthors WHERE author_id = authorId;
    
    IF @book_count > 0 THEN
        IF deleteCascade = 1  THEN
            CREATE TEMPORARY TABLE IF NOT EXISTS temp_books (isbn VARCHAR(13));
            INSERT INTO temp_books (isbn) SELECT isbn FROM BooksAuthors WHERE author_id = authorId;

            DELETE FROM BooksAuthors WHERE isbn IN (SELECT isbn FROM temp_books);
            DELETE FROM Books WHERE isbn IN (SELECT isbn FROM temp_books);

            DROP TEMPORARY TABLE IF EXISTS temp_books;
        ELSE
            DELETE FROM BooksAuthors WHERE author_id = authorId;
        END IF;
    END IF;

    DELETE FROM Authors WHERE author_id = authorId;
END;
//

CREATE PROCEDURE deletePublisher(
    IN publisherId INT,
    IN deleteCascade BOOLEAN
)
BEGIN
    IF deleteCascade = 1  THEN
        DELETE FROM BooksAuthors WHERE isbn IN (SELECT isbn FROM Books WHERE publisher_id = publisherId);
        DELETE FROM Books WHERE publisher_id = publisherId; 
    END IF;

    DELETE FROM Publishers WHERE publisher_id = publisherId;
END;
//

CREATE PROCEDURE deleteBook(
    IN bIsbn VARCHAR(13)
)
BEGIN
    DELETE FROM BooksAuthors WHERE isbn = bIsbn;
    DELETE FROM Books WHERE isbn = bIsbn; 
END;
//