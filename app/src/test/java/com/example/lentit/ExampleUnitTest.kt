package com.example.lentit

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private var underTest: Greeter = Greeter()
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testInit() {
        val result = underTest.greet(name = "Bam")

        assertEquals("Hello Bam", result)
    }

    @Test
    fun testInit_Trim() {
        val result = underTest.greet(name = " Bam ")

        assertEquals("Hello Bam", result)
    }

    @Test
    fun testInit_CapitalizeStartLetter() {
        val result = underTest.greet(name = "bam")

        assertEquals("Hello Bam", result)
    }

//    @Test
//    fun testInit_BeforeStartMorningTime() {
//        underTest = Greeter(time = "05:59")
//        val result = underTest.greet(name = "bam")
//
//        assertEquals("Hello Bam", result)
//    }

    @Test
    fun testInit_StartMorningTime() {
        underTest = Greeter(time = "06:01")
        val result = underTest.greet(name = "bam")

        assertEquals("Good morning Bam", result)
    }

    @Test
    fun testInit_BetweenMorningTimePeriod() {
        underTest = Greeter(time = "08:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Good morning Bam", result)
    }

    @Test
    fun testInit_EndMorningTime() {
        underTest = Greeter(time = "11:59")
        val result = underTest.greet(name = "bam")

        assertEquals("Good morning Bam", result)
    }

    @Test
    fun testInit_AfterEndMorningTime() {
        underTest = Greeter(time = "12:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Hello Bam", result)
    }

//    @Test
//    fun testInit_BeforeStartEveningTime() {
//        underTest = Greeter(time = "17:59")
//        val result = underTest.greet(name = "bam")
//
//        assertEquals("Hello Bam", result)
//    }

    @Test
    fun testInit_StartEveningTime() {
        underTest = Greeter(time = "18:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Good evening Bam", result)
    }

    @Test
    fun testInit_BetweenEveningTimePeriod() {
        underTest = Greeter(time = "19:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Good evening Bam", result)
    }

    @Test
    fun testInit_EndEveningTime() {
        underTest = Greeter(time = "22:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Good evening Bam", result)
    }

    @Test
    fun testInit_BetweenNightTime() {
        underTest = Greeter(time = "22:01")
        val result = underTest.greet(name = "bam")

        assertEquals("Hello Bam", result)
    }

    @Test
    fun testInit_EndNightTime() {
        underTest = Greeter(time = "06:00")
        val result = underTest.greet(name = "bam")

        assertEquals("Good evening Bam", result)
    }
}

class Greeter(private val time: String? = null) {
    fun greet(name: String): String {
        val ourName  = name.trim().replaceFirstChar {
            it.uppercase()
        }

        return if (isBetweenOrEqualTime("06:00", "12:00")) {
                "Good morning $ourName"
        } else if (isBetweenOrEqualTime("18:00", "22:00")) {
            "Good evening $ourName"
         }else {
            "Hello $ourName"
        }
    }

    private fun isBetweenOrEqualTime(startTime:String, endTime: String): Boolean {
        return time?.let {
            val timeFormat = "HH:mm"
            val initTime = SimpleDateFormat(timeFormat).parse(time)
            val startTime = SimpleDateFormat(timeFormat).parse(startTime)
            val endTime = SimpleDateFormat(timeFormat).parse(endTime)
            (initTime.after(startTime) && initTime.before(endTime)) || initTime.equals(startTime)  || initTime.equals(endTime)
        } ?: false
    }
}