package com.example.mk4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        // Original test cases
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false),
                "Expected false: un-cited publicly-available code");
        assertTrue(RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true),
                "Expected true: self-written required code");

        // Additional test cases

        // Case: Not written by yourself, publicly available, and not cited
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, true, false, false, true),
                "Expected false: un-cited publicly-available code");

        // Case: Not written by yourself, available to others, written as coursework, but not cited
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, true, true, false, true),
                "Expected false: publicly available code not properly cited");

        // Case: Not written by yourself, available to others, written as coursework, and cited
        assertTrue(RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false),
                "Expected true: publicly available code properly cited and written as coursework");

        // Case: Not written by yourself, not available to others, not cited
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, false, false, false, false),
                "Expected false: code not available to others and not cited");

        // Case: Self-written code but not required for the assignment
        assertTrue(RulesOf6005.mayUseCodeInAssignment(true, false, true, true, false),
                "Expected true: self-written code not required for the assignment");

        // Case: All parameters false (should return false)
        assertFalse(RulesOf6005.mayUseCodeInAssignment(false, false, false, false, false),
                "Expected false: no valid conditions met");
    }
}
