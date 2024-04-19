package org.example.exception;

/**
 * Any exception that occurs while parsing a custom query.
 */
public class QueryParsingException extends RuntimeException {
    public QueryParsingException() {
    }

    public QueryParsingException(String message) {
        super(message);
    }

    public QueryParsingException(String message, Exception e) {
        super(message, e);
    }

    public QueryParsingException(Exception e) {
        super(e);
    }
}
