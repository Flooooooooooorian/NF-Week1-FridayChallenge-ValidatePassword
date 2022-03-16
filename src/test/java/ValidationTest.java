import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void isAllowedTestVerbotenePW() {
        assertEquals(false, validation.isAllowed("12345678"));
    }

    @Test
    void isAllowedTestKeinSonderzeichenUndZahlUndKurz() {
        assertEquals(false, validation.isAllowed("Banane"));
    }

    @Test
    void isAllowedTestOhneSonderzeichen() {
        assertEquals(false, Validation.isAllowed("IrgendwasOhneSonderzeichen213"));
    }

    @Test
    void isAllowedTestZuKurz() {
        assertEquals(false, validation.isAllowed("Al!35"));
    }

    @Test
    void isAllowedTestKeinKlein() {
        assertEquals(false, validation.isAllowed("YAYPASSWOR123!!"));
    }

    @Test
    void isAllowedTestkeinGroß() {
        assertFalse(validation.isAllowed("flüsterpasswort123!"));
    }

    @Test
    void isAllowedTestKorrekt() {
        assertEquals(true, validation.isAllowed("VorblidlichesPasswort123!§%"));
    }

}