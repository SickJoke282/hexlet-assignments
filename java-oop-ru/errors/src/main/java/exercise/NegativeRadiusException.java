package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String message;
    NegativeRadiusException(String message) {
        this.message = message;
    }
}
// END
