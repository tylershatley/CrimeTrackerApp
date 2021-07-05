// Tested by Reece Peters

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuspectTest {
    private Suspects suspects = Suspects.getInstance();
    private ArrayList<Suspect> suspectList = suspects.getSuspects();

    @BeforeEach
    public void setup() {
        suspectList.clear();
        suspectList.add(new Suspect("Louis", "Emmery", "4347774234", "55 Reach Rd.", "Emerald", 24, 178, "6'3", "White",
                "Male", "brown", 10, "Black", "long", "none", "Black hoodie and red shoes", false, true, "Sedan Toyota",
                "33r-ty6"));
        DataWriter.saveSuspects();
    }

    @AfterEach
    public void tearDown() {
        Suspects.getInstance().getSuspects().clear();
        DataWriter.saveSuspects();
    }

    // Reason adding test
    @Test
    void testAddReason() {
        String reason = "Owns car similar to reported vehicle in crime";
        suspectList.get(0).addReason(reason);
        assertEquals("Owns car similar to reported vehicle in crime", suspectList.get(0).getReasons().get(0));
    }
}
