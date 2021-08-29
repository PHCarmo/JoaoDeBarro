package br.com.fatecmc.joaodebarro.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:features/Cliente.feature",
        "classpath:features/Pedido.feature"},
        tags="@regressivo",
        glue="br.com.fatecmc.joaodebarro.stepdefinition")
public class AllFeaturesRunner {
    
}
