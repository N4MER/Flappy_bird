package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Bird;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdTest {
    private Bird bird;

    @BeforeEach
    public void setUp() {
        bird = new Bird("bird.png", "birdFalling.png", "birdSemiFalling.png", "birdJump.png");
    }

    @Test
    public void testJump() {
        bird.jump();
        assertEquals(bird.getJumpForce(),bird.getBirdSpeed());
    }
}
