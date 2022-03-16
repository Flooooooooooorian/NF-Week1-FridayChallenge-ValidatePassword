import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void isAllowedTestForbiddenPW() {
        assertEquals(false, validation.isAllowed("12345678"));
    }

    @Test
    void isAllowedTestNoSpecialCharAndNumAndToShort() {
        assertEquals(false, validation.isAllowed("Banane"));
    }

    @Test
    void isAllowedTestNoSpecialChar() {
        assertEquals(false, Validation.isAllowed("IrgendwasOhneSonderzeichen213"));
    }

    @Test
    void isAllowedTestToShort() {
        assertEquals(false, validation.isAllowed("Al!35"));
    }

    @Test
    void isAllowedTestNoLowerCase() {
        assertEquals(false, validation.isAllowed("YAYPASSWORD123!!"));
    }

    @Test
    void isAllowedTestNoUpperCase() {
        assertFalse(validation.isAllowed("flüsterpasswort123!"));
    }

    @Test
    void isAllowedTestCorrect() {
        assertEquals(true, validation.isAllowed("VorblidlichesPasswort123!§%"));
    }

}