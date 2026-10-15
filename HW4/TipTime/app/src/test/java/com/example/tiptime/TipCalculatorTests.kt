package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test fun calculate_20_percent_tip() {
        assertEquals(NumberFormat.getCurrencyInstance().format(2), calculateTip(10.0, 20.0, false))
    }
    @Test fun round_up_fractional_tip() {
        assertEquals(NumberFormat.getCurrencyInstance().format(3), calculateTip(10.25, 20.0, true))
    }
    @Test fun zero_bill_has_zero_tip() {
        assertEquals(NumberFormat.getCurrencyInstance().format(0), calculateTip(0.0, 20.0, true))
    }
    @Test fun default_percentage_is_fifteen() {
        assertEquals(NumberFormat.getCurrencyInstance().format(15), calculateTip(100.0))
    }
}
