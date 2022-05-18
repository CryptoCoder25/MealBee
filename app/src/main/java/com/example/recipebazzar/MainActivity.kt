package com.example.recipebazzar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPage
import com.example.recipebazzar.Presentation.Screens.MealInfo_Page.MealInfoPage
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListPage
import com.example.recipebazzar.Presentation.Screens.NoteScreen_Page.NoteScreenPage
import com.example.recipebazzar.Presentation.Screens.ScheduledMeal_Page.ScheduleMealPage
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.AppBottomItem
import com.example.recipebazzar.Presentation.ui.theme.RecipeBazzarTheme
import com.example.recipebazzar.Presentation.ui.theme.White
import com.example.recipebazzar.Utils.Constants
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentScreen= mutableStateOf<AppBottomItem>(AppBottomItem.Home)

        setContent {
            RecipeBazzarTheme {

                ProvideWindowInsets {

                    Surface(color = White) {
                        val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = Routes.MainScreen
                        )
                        {
                            composable(Routes.MainScreen) {
                               MainPage(
                                   onNavigate = {navController.navigate(it.route)},
                                   currentScreen
                                   )

                            }
                            composable(route = Routes.MealListScreen + "?category={category}",
                                arguments = listOf(
                                    navArgument(name = Constants.MealsCategory) {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    }
                                )
                            ) {
                                MealsListPage(onNavigate = {
                                    navController.navigate(it.route)
                                }
                                )
                            }
                            composable(route = Routes.MealInfoScreen + "?MEAL_ID={MEAL_ID}",
                                arguments = listOf(
                                    navArgument(name = Constants.MealsId) {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    }
                                )
                            ) {
                                MealInfoPage(onNavigate = {
                                    navController.navigate(it.route)
                                }
                                )
                            }
                            composable(Routes.NoteScreen) {
                                NoteScreenPage(
                                    onNavigate = {navController.navigate(it.route)}
                                )

                            }
                            composable(Routes.ScheduledMealScreen) {
                                ScheduleMealPage(
                                    onNavigate = {navController.navigate(it.route)}
                                )

                            }
                        }
                    }


                }

            }



        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeBazzarTheme {
       //RecipeCategory()
    }
}

