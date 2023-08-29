package com.example.unit_tests;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UItest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setup() {
        Intents.init(); // Inicializar Intents para capturar intenciones
    }

    @After
    public void teardown() {
        Intents.release(); // Liberar Intents después de las pruebas
    }

    @Test
    public void testButtonOpensActivity() {
        // Realizar clic en el botón Calculadora
        Espresso.onView(ViewMatchers.withId(R.id.calculator)).perform(ViewActions.click());

        // Verificar que se envió una intención para abrir Calculator
        Intents.intended(IntentMatchers.hasComponent(Calculator.class.getName()));

        //Volver al activity main
        Espresso.pressBack();

        // Realizar clic en el botón Salario
        Espresso.onView(ViewMatchers.withId(R.id.salary)).perform(ViewActions.click());

        // Verificar que se envió una intención para abrir Salary
        Intents.intended(IntentMatchers.hasComponent(Salary.class.getName()));
    }
}
