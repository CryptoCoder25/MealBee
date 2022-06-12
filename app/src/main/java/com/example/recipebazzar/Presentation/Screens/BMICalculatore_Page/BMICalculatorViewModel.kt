package com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BMICalculatorViewModel  @Inject constructor()  : ViewModel() {


    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var age by mutableStateOf("")
        private set

    private val _bmi = mutableStateOf("00.0")
    val bmi: State<String> = _bmi

    private val _bmistatus = mutableStateOf("_")
    val bmistatus: State<String> = _bmistatus


    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: BMICalculatorEvents) {
        when(event) {
            is BMICalculatorEvents.OnHeightChange -> {
                height = event.height
            }
            is BMICalculatorEvents.OnWeightChange -> {
                weight = event.weight
            }

            is BMICalculatorEvents.OnAgeChange -> {
               age = event.age
            }
            is BMICalculatorEvents.OnClickCalculate -> {


                    if(height.isBlank() || height.equals("0")) {
                        sendUiEvent(PublicUiEvents.ShowToastMessage(
                            message = "Height is required!"
                        ))

                    } else if(weight.isBlank() || weight.equals("0")) {
                        sendUiEvent(PublicUiEvents.ShowToastMessage(
                            message = "Weight is required!"
                        ))

                    } else if(age.isBlank() || age.equals("0")) {
                        sendUiEvent(PublicUiEvents.ShowToastMessage(
                            message = "Age is required"
                        ))

                    } else {


                        val heightValue: Double = (height.toDouble())/100
                        val ageValue: Double =  age.toDouble()
                        val weightValue: Double = weight.toDouble()

                        val   bmiDouble = weightValue/(heightValue * heightValue);

                        _bmi.value =  String.format("%.1f", bmiDouble)


                         if(bmiDouble < 18.5)
                         {
                           _bmistatus.value = "Underweight"

                         }else if( bmiDouble >= 18.5 && bmiDouble <= 24.9) {

                             _bmistatus.value = "Normal"

                         }else if( bmiDouble >= 25.0 && bmiDouble <= 29.9) {

                             _bmistatus.value = "Overweight"

                         } else if( bmiDouble >= 30.0){

                             _bmistatus.value = "Obese"

                         }

                    }




            }
        }
    }



    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}