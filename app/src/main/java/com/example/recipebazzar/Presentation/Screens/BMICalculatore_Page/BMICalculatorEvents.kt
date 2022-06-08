package com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page

sealed class BMICalculatorEvents {
    data class OnHeightChange(val height: String): BMICalculatorEvents()
    data class OnWeightChange(val weight: String): BMICalculatorEvents()
    data class OnAgeChange(val age: String): BMICalculatorEvents()
    object OnClickCalculate: BMICalculatorEvents()
}