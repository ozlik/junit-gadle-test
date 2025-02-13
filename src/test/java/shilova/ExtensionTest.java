package shilova;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import shilova.extensions.LifecycleExtension;
import shilova.extensions.ParameterExtension;
import shilova.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class ExtensionTest {
    @ExtendWith(LifecycleExtension.class)
    @Test
    void testWitLifecycleExtend() {
        int a = 1;

        int actualSum = a+a;
        int expectedSum = 2;

        assertEquals(expectedSum, actualSum);
    }

    @ExtendWith(ParameterExtension.class)
    @Test
    void testWithParameterExtend(User user) {
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Wrong first name"),
                () -> assertEquals("Doe", user.getLastName(), "Wrong last name"),
                () -> assertEquals(30, user.getAge(), "Wrong age")
        );
    }
}
